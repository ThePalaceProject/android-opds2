package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * An OPDS 2.0 feed.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Feed @JsonCreator constructor(
  /**
   * The feed metadata.
   */

  @JsonProperty(
    value = "metadata",
    required = true
  )
  val metadata : O2Metadata,

  /**
   * The navigation section, if any.
   */

  @JsonProperty(
    value = "navigation"
  )
  val navigation : O2Navigation?,

  /**
   * The feed links
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<O2Link> = listOf(),

  /**
   * The feed links
   */

  @JsonProperty(
    value = "publications"
  )
  val publications : List<O2Publication> = listOf()
) : O2Element()
