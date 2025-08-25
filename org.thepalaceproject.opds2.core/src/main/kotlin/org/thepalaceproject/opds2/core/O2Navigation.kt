package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The OPDS 2.0 navigation section.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Navigation(

  /**
   * The set of navigation links.
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<O2NavigationLink> = listOf()
) : O2Element()
