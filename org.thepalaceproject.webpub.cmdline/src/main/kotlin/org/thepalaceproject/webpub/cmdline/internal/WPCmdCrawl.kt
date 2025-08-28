package org.thepalaceproject.webpub.cmdline.internal

import com.fasterxml.jackson.databind.json.JsonMapper
import com.io7m.quarrel.core.QCommandContextType
import com.io7m.quarrel.core.QCommandMetadata
import com.io7m.quarrel.core.QCommandStatus
import com.io7m.quarrel.core.QCommandType
import com.io7m.quarrel.core.QParameterNamed1
import com.io7m.quarrel.core.QParameterNamedType
import com.io7m.quarrel.core.QStringType
import com.io7m.quarrel.ext.logback.QLogback
import org.slf4j.LoggerFactory
import org.thepalaceproject.webpub.cmdline.WPVersion
import org.thepalaceproject.webpub.core.WPMLinkBasic
import org.thepalaceproject.webpub.core.WPMLinkTemplated
import org.thepalaceproject.webpub.core.WPMManifest
import org.thepalaceproject.webpub.core.WPMMappers
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.Optional
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class WPCmdCrawl : QCommandType {

  private lateinit var executor : ExecutorService
  private lateinit var visited : ConcurrentHashMap.KeySetView<URI, Boolean>
  private lateinit var mapper : JsonMapper
  private lateinit var client : HttpClient

  private val logger =
    LoggerFactory.getLogger(WPCmdCrawl::class.java)

  private val metadata : QCommandMetadata =
    QCommandMetadata(
      "crawl",
      QStringType.QConstant("Crawl WebPub feeds"),
      Optional.empty()
    )

  private val START_ADDRESS =
    QParameterNamed1(
      "--start",
      mutableListOf(),
      QStringType.QConstant("The starting address."),
      Optional.empty(),
      URI::class.java
    )

  private val OUTPUT_DIRECTORY =
    QParameterNamed1(
      "--output-directory",
      mutableListOf(),
      QStringType.QConstant("The output directory."),
      Optional.empty(),
      Path::class.java
    )

  override fun onListNamedParameters() : List<QParameterNamedType<*>> {
    return QLogback.plusParameters(
      listOf(
        this.START_ADDRESS,
        this.OUTPUT_DIRECTORY
      )
    )
  }

  override fun onExecute(
    context : QCommandContextType
  ) : QCommandStatus {
    val start =
      context.parameterValue(this.START_ADDRESS)
    val output =
      context.parameterValue(this.OUTPUT_DIRECTORY)

    this.visited =
      ConcurrentHashMap.newKeySet()
    this.mapper =
      WPMMappers.createMapper()
    this.client =
      HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build()
    this.executor =
      Executors.newFixedThreadPool(8)

    this.process(this.executor, output, start)

    this.executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS)
    return QCommandStatus.SUCCESS
  }

  private fun process(
    executor : ExecutorService,
    output : Path,
    target : URI
  ) {
    if (this.visited.contains(target)) {
      this.logger.info("[{}] Already visited, ignoring.", target)
      return
    }
    this.visited.add(target)

    executor.execute {
      val path =
        this.basicOutputPath(target)
      val pathJson =
        "$path.json"
      val pathURI =
        "$path.link"

      val outBase =
        output.resolve(target.host)
      val outFeedFile =
        outBase.resolve(pathJson)
      val outLinkFile =
        outBase.resolve(pathURI)

      this.logger.info("[{}] Download to {}", target, outFeedFile)
      Files.createDirectories(outFeedFile.parent)
      Files.writeString(outLinkFile, target.toString())

      val request =
        HttpRequest.newBuilder(target)
          .header("User-Agent", this.userAgent())
          .build()

      val response =
        this.client.send(
          request,
          HttpResponse.BodyHandlers.ofFile(
            outFeedFile,
            StandardOpenOption.CREATE,
            StandardOpenOption.WRITE,
            StandardOpenOption.TRUNCATE_EXISTING
          )
        )

      val statusCode = response.statusCode()
      if (statusCode >= 400) {
        this.logger.error("[{}] {}", target, statusCode)
        return@execute
      }

      val contentType =
        response.headers()
          .firstValue("Content-Type")
          .orElse("application/octet-stream")

      this.logger.debug("[{}] Content-Type: {}", target, contentType)
      if (this.isContentTypeAcceptable(contentType)) {
        try {
          val manifest =
            this.mapper.readValue(
              outFeedFile.toFile(),
              WPMManifest::class.java
            )

          for (link in manifest.links) {
            when (link) {
              is WPMLinkBasic     -> {
                this.process(executor, output, link.href)
              }
              is WPMLinkTemplated -> {
                // We don't know how to follow arbitrary templated links.
              }
            }
          }

          for (link in manifest.navigation) {
            when (link) {
              is WPMLinkBasic     -> {
                this.process(executor, output, link.href)
              }
              is WPMLinkTemplated -> {
                // We don't know how to follow arbitrary templated links.
              }
            }
          }
        } catch (e : Exception) {
          this.logger.debug("[{}] Parsing failed: ", target, e)
        }
      }
    }
  }

  private fun basicOutputPath(
    target : URI
  ) : String {
    val pathBuilder = StringBuilder()
    pathBuilder.append(target.rawPath)
    if (target.rawQuery != null) {
      pathBuilder.append('?')
      pathBuilder.append(target.rawQuery)
    }
    if (target.rawFragment != null) {
      pathBuilder.append('#')
      pathBuilder.append(target.rawFragment)
    }

    return pathBuilder.toString().removePrefix("/")
  }

  private fun isContentTypeAcceptable(
    contentType : String
  ) : Boolean {
    if (contentType.startsWith("application/opds+json")) {
      return true
    }
    return false
  }

  private fun userAgent() : String {
    return "org.thepalaceproject.webpub ${WPVersion.MAIN_VERSION} (https://github.com/ThePalaceProject/android-webpub)"
  }

  override fun metadata() : QCommandMetadata {
    return this.metadata
  }
}