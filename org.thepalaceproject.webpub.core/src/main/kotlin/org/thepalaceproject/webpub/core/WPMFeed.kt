package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * An OPDS 2.0 feed.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMFeed @JsonCreator constructor(
  /**
   * The feed metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : WPMMetadata,

  /**
   * The navigation section, if any.
   */

  @JsonProperty(
    value = "navigation"
  )
  val navigation : WPMNavigation?,

  /**
   * The feed links
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<WPMLink> = listOf(),

  /**
   * The feed publications
   */

  @JsonProperty(
    value = "publications"
  )
  val publications : List<WPMPublication> = listOf(),

  /**
   * The feed catalogs
   */

  @JsonProperty(
    value = "catalogs"
  )
  val catalogs : List<WPMCatalog> = listOf()
) : WPMElement()
