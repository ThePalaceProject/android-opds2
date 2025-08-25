package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * An OPDS 2.0 publication section.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Publication @JsonCreator constructor(

  /**
   * The metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : O2Metadata,

  /**
   * The set of links.
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<O2Link> = listOf()
) : O2Element()
