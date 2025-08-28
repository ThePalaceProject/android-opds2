package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * A WebPub manifest.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMManifest @JsonCreator constructor(
  /**
   * The metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : WPMMetadata,

  /**
   * The navigation links, if any.
   */

  @JsonProperty(
    value = "navigation"
  )
  val navigation : List<WPMLink> = listOf(),

  /**
   * The links
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<WPMLink> = listOf(),

  /**
   * The publications
   */

  @JsonProperty(
    value = "publications"
  )
  val publications : List<WPMPublication> = listOf(),

  /**
   * The catalogs
   */

  @JsonProperty(
    value = "catalogs"
  )
  val catalogs : List<WPMCatalog> = listOf()
) : WPMElement()
