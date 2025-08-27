package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import one.irradia.mime.api.MIMEType
import java.net.URI
import java.net.URISyntaxException


class WPMLinkDeserializer : StdDeserializer<WPMLink>(WPMLink::class.java) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMLinkRaw(
    @JsonProperty(value = "href")
    val href : String,
    @JsonProperty(value = "type")
    val type : MIMEType? = null,
    @JsonProperty(value = "templated")
    val templated : Boolean = false,
    @JsonProperty(value = "rel")
    val relation : List<String> = listOf(),
    @JsonProperty(value = "title")
    val title : String = "",
    @JsonProperty(value = "properties")
    val properties : WPMLinkProperties?,
    @JsonProperty(value = "height")
    val height : Int? = null,
    @JsonProperty(value = "width")
    val width : Int? = null,
    @JsonProperty(value = "size")
    val size : Int? = null,
    @JsonProperty(value = "bitrate")
    val bitrate : Number? = null,
    @JsonProperty(value = "duration")
    val duration : Number? = null,
    @JsonProperty(value = "alternate")
    val alternate : List<WPMLinkRaw> = listOf(),
    @JsonProperty(value = "children")
    val children : List<WPMLinkRaw> = listOf(),
  )

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMLink {
    return this.transformRawLink(
      context.readValue<WPMLinkRaw>(
        parser,
        WPMLinkRaw::class.java
      )
    )
  }

  private fun transformRawLink(
    raw : WPMLinkRaw
  ) : WPMLink {
    return if (raw.templated) {
      WPMLinkTemplated(
        href = raw.href,
        type = raw.type,
        relation = raw.relation,
        properties = raw.properties,
        title = raw.title,
        height = raw.height,
        width = raw.width,
        size = raw.size,
        bitrate = raw.bitrate,
        duration = raw.duration,
        alternate = raw.alternate.map(this::transformRawLink),
        children = raw.children.map(this::transformRawLink),
      )
    } else {
      val input = raw.href

      try {
        return WPMLinkBasic(
          href = URI(raw.href),
          type = raw.type,
          relation = raw.relation,
          properties = raw.properties,
          title = raw.title,
          height = raw.height,
          width = raw.width,
          size = raw.size,
          bitrate = raw.bitrate,
          duration = raw.duration,
          alternate = raw.alternate.map(this::transformRawLink),
          children = raw.children.map(this::transformRawLink),
        )
      } catch (_ : URISyntaxException) {
        val colon : Int =
          input.indexOf(':')
        if (colon <= 0) {
          throw URISyntaxException(input, "Missing scheme")
        }

        val scheme =
          input.take(colon)
        val sspAndFrag =
          input.substring(colon + 1)
        val hash =
          sspAndFrag.indexOf('#')

        val schemeSpecific =
          if (hash >= 0) {
            sspAndFrag.take(hash)
          } else {
            sspAndFrag
          }

        val frag =
          if (hash >= 0) {
            sspAndFrag.substring(hash + 1)
          } else {
            null
          }

        return WPMLinkBasic(
          href = URI(scheme, schemeSpecific, frag),
          type = raw.type,
          relation = raw.relation,
          properties = raw.properties,
          title = raw.title,
          height = raw.height,
          width = raw.width,
          size = raw.size,
          bitrate = raw.bitrate,
          duration = raw.duration,
          alternate = raw.alternate.map(this::transformRawLink),
          children = raw.children.map(this::transformRawLink),
        )
      }
    }
  }
}
