package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * An OPDS 2.0 group.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMGroup @JsonCreator constructor(

  /**
   * The metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : WPMMetadata,

  /**
   * The set of navigation links.
   */

  @JsonProperty(
    value = "navigation"
  )
  val navigation : List<WPMLink> = listOf(),
) : WPMElement()
