package org.thepalaceproject.webpub.tests

import com.fasterxml.jackson.databind.json.JsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.io.TempDir
import org.slf4j.LoggerFactory
import org.thepalaceproject.webpub.core.WPMFeed
import org.thepalaceproject.webpub.core.WPMMappers
import java.io.IOException
import java.io.InputStream
import java.nio.file.Path
import java.util.stream.Stream
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class WPMFeedTest {

  private val logger =
    LoggerFactory.getLogger(WPMFeedTest::class.java)

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

  @TestFactory
  fun testRoundTripMany() : Stream<DynamicTest> {
    return Stream.of(
      "anna_karenina_toc.audiobook-manifest.json",
      "bestnewhorror.audiobook-manifest.json",
      "feedbooks_0.json",
      "feedbooks_1.json",
      "feedbooks_2.json",
      "feedbooks_3.json",
      "feedbooks_rights_no_end.json",
      "feedbooks_rights_no_start.json",
      "feedbooks_rights_ok.json",
      "findaway.json",
      "findaway-20201015.json",
      "findaway_leading_0.json",
      "flatland.audiobook-manifest.json",
      "flatland_toc.audiobook-manifest.json",
      "groups-20250821.json",
      "igen.json",
      "null_link_type.json",
      "null_titles.json",
      "ok_minimal_0.json",
      "ok_minimal_1.json",
      "open_access_0.json",
      "random-game-audio.json",
      "random-game-audio-2.json",
      "rbdigital_large.json",
      "registry-20250826.json",
      "summerwives.audiobook-manifest.json",
    ).map { x -> roundTripDynamicTestOf(x) }
  }

  private fun roundTripDynamicTestOf(
    name : String
  ) : DynamicTest {
    return DynamicTest.dynamicTest("testRoundTrip_$name", {
      this.roundTrip(
        mapper.readValue(
          resource(name),
          WPMFeed::class.java
        )
      )
    })
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
      assertDataClassEquals(c0.metadata, c1.metadata)
      for ((l0, l1) in c0.links.zip(c1.links)) {
        assertEquals(l0, l1)
      }
      assertEquals(c0.links, c1.links)
      assertEquals(c0.images, c1.images)
      assertEquals(c0, c1)
    }

    assertDataClassEquals(feed.catalogs, rereadObject.catalogs)
    assertDataClassEquals(feed.publications, rereadObject.publications)
    assertDataClassEquals(feed.links, rereadObject.links)
    assertDataClassEquals(feed.metadata, rereadObject.metadata)

    assertEquals(feed.navigation, rereadObject.navigation)
    assertEquals(feed, rereadObject)
  }

  fun <T : Any> assertDataClassEquals(
    expected: T,
    actual: T
  ) {
    val kClass = expected::class
    this.logger.debug("Comparing class {}", kClass)

    if (!kClass.isData) {
      this.logger.debug("{} is not a data class, ignoring it.", kClass)
      return
    }

    val memberProperties = kClass.memberProperties
    this.logger.debug("Class {} has {} properties", kClass, memberProperties.size)

    for (prop in memberProperties) {
      @Suppress("UNCHECKED_CAST")
      val property = prop as KProperty1<T, Any?>
      this.logger.debug(
        "Comparing property {} of type {}",
        property.name,
        property.javaClass
      )
      val expectedValue =
        property.get(expected)
      val actualValue =
        property.get(actual)
      assertEquals(
        expectedValue,
        actualValue,
        "Mismatch in property: ${prop.name}"
      )
    }
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