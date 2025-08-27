package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * A WebPub publication.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMPublication @JsonCreator constructor(

  /**
   * The context.
   */

  @JsonProperty(
    value = "@context"
  )
  val context : Set<String> = setOf(),

  /**
   * The metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : WPMMetadata,

  /**
   * The set of links.
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<WPMLink> = listOf(),

  /**
   * The reading order.
   */

  @JsonProperty(
    value = "readingOrder"
  )
  val readingOrder : List<WPMLink> = listOf(),

  /**
   * The resources.
   */

  @JsonProperty(
    value = "resources"
  )
  val resources : List<WPMLink> = listOf(),

  /**
   * The table of contents.
   */

  @JsonProperty(
    value = "toc"
  )
  val toc : List<WPMLink> = listOf(),

  /**
   * The set of image links.
   */

  @JsonProperty(
    value = "images"
  )
  val images : List<WPMLink> = listOf()
) : WPMElement()
