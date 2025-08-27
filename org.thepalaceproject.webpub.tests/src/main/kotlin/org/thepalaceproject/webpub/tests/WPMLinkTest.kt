package org.thepalaceproject.webpub.tests

import com.fasterxml.jackson.databind.json.JsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.thepalaceproject.webpub.core.WPMLink
import org.thepalaceproject.webpub.core.WPMLinkBasic
import org.thepalaceproject.webpub.core.WPMLinkTemplated
import org.thepalaceproject.webpub.core.WPMMappers
import java.io.IOException
import java.io.InputStream
import java.nio.file.Path

class WPMLinkTest {

  private lateinit var mapper : JsonMapper
  private lateinit var directory : Path

  @BeforeEach
  fun setup(@TempDir directory : Path) {
    this.directory =
      directory
    this.mapper =
      WPMMappers.createMapper()
  }

  @Test
  fun testLinkBasic0() {
    val data =
      this.mapper.readValue<WPMLink>(
        this.resource("link-basic-0.json"),
        WPMLink::class.java
      ) as WPMLinkBasic
    assertEquals("http://www.example.com", data.href.toString())
  }

  @Test
  fun testLinkBasic1() {
    val data =
      this.mapper.readValue<WPMLink>(
        this.resource("link-basic-1.json"),
        WPMLink::class.java
      ) as WPMLinkBasic
    assertEquals("http://www.example.com", data.href.toString())
    assertEquals("text/plain", data.type?.fullType)
  }

  @Test
  fun testLinkTemplated0() {
    val data =
      this.mapper.readValue<WPMLink>(
        this.resource("link-templated-0.json"),
        WPMLink::class.java
      ) as WPMLinkTemplated
    assertEquals("http://www.example.com/{x}", data.href)
  }

  @Test
  fun testLinkTemplated1() {
    val data =
      this.mapper.readValue<WPMLink>(
        this.resource("link-templated-1.json"),
        WPMLink::class.java
      ) as WPMLinkTemplated
    assertEquals("http://www.example.com/{x}", data.href)
    assertEquals("text/plain", data.type?.fullType)
  }

  private fun resource(
    name : String
  ) : InputStream {
    val path =
      "/org/thepalaceproject/webpub/tests/$name"
    val stream =
      WPMLinkTest::class.java
        .getResourceAsStream(path)

    if (stream == null) {
      throw IOException("No such resource: $path")
    }

    return stream
  }
}