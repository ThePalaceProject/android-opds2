package org.thepalaceproject.webpub.tests

import com.fasterxml.jackson.databind.json.JsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.thepalaceproject.webpub.core.WPMFeed
import org.thepalaceproject.webpub.core.WPMMappers
import java.io.IOException
import java.io.InputStream
import java.nio.file.Path

class WPMFeedTest {

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
  fun testGroups20250821() {
    val feed =
      this.mapper.readValue<WPMFeed>(
        this.resource("groups-20250821.json"),
        WPMFeed::class.java
      )

    assertEquals(0, feed.catalogs.size)
    assertEquals(14, feed.links.size)
    assertEquals(217, feed.publications.size)

    this.roundTrip(feed)
  }

  @Test
  fun testRegistry20250826() {
    val feed =
      this.mapper.readValue<WPMFeed>(
        this.resource("registry-20250826.json"),
        WPMFeed::class.java
      )

    assertEquals(708, feed.catalogs.size)
    assertEquals(4, feed.links.size)
    assertEquals(0, feed.publications.size)

    this.roundTrip(feed)
  }

  private fun roundTrip(
    feed : WPMFeed
  ) {
    val serializedText =
      this.mapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(feed)
    val rereadObject =
      this.mapper.readValue(
        serializedText,
        WPMFeed::class.java
      )

    for ((c0, c1) in feed.catalogs.zip(rereadObject.catalogs)) {
      assertEquals(c0.metadata, c1.metadata)
      for ((l0, l1) in c0.links.zip(c1.links)) {
        assertEquals(l0, l1)
      }
      assertEquals(c0.links, c1.links)
      assertEquals(c0.images, c1.images)
      assertEquals(c0, c1)
    }

    assertEquals(feed.catalogs, rereadObject.catalogs)
    assertEquals(feed.publications, rereadObject.publications)
    assertEquals(feed.links, rereadObject.links)
    assertEquals(feed.metadata, rereadObject.metadata)
    assertEquals(feed.navigation, rereadObject.navigation)
    assertEquals(feed, rereadObject)
  }

  private fun resource(
    name : String
  ) : InputStream {
    val path =
      "/org/thepalaceproject/webpub/tests/$name"
    val stream =
      WPMFeedTest::class.java
        .getResourceAsStream(path)

    if (stream == null) {
      throw IOException("No such resource: $path")
    }

    return stream
  }
}