package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * An OPDS 2.0 facet.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMFacet @JsonCreator constructor(

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
) : WPMElement()
