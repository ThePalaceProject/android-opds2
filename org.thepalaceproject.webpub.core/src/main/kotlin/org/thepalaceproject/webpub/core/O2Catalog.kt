package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The OPDS 2.0 catalog section.
 */

@O2Extension
@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Catalog(

  /**
   * The catalog metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : O2Metadata,

  /**
   * The set of catalog links.
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<O2Link> = listOf(),

  /**
   * The set of image links.
   */

  @JsonProperty(
    value = "images"
  )
  val images : List<O2Link> = listOf()
) : O2Element()
