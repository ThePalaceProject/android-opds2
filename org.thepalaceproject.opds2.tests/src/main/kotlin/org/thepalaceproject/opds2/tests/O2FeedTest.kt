package org.thepalaceproject.opds2.tests

import com.fasterxml.jackson.databind.json.JsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.thepalaceproject.opds2.core.O2Feed
import org.thepalaceproject.opds2.core.O2Mappers
import java.io.IOException
import java.io.InputStream
import java.nio.file.Path

class O2FeedTest {

  private lateinit var mapper : JsonMapper
  private lateinit var directory : Path

  @BeforeEach
  fun setup(@TempDir directory : Path) {
    this.directory =
      directory
    this.mapper =
      O2Mappers.createMapper()
  }

  @Test
  fun testGroups20250821() {
    val feed =
      this.mapper.readValue<O2Feed>(
        this.resource("groups-20250821.json"),
        O2Feed::class.java
      )

    assertEquals(0, feed.catalogs.size)
    assertEquals(14, feed.links.size)
    assertEquals(217, feed.publications.size)
  }

  @Test
  fun testRegistry20250826() {
    val feed =
      this.mapper.readValue<O2Feed>(
        this.resource("registry-20250826.json"),
        O2Feed::class.java
      )

    assertEquals(708, feed.catalogs.size)
    assertEquals(4, feed.links.size)
    assertEquals(0, feed.publications.size)
  }

  private fun resource(
    name : String
  ): InputStream {
    val path =
      "/org/thepalaceproject/opds2/tests/$name"
    val stream =
      O2FeedTest::class.java
        .getResourceAsStream(path)

    if (stream == null) {
      throw IOException("No such resource: $path")
    }

    return stream
  }
}