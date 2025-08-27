package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The OPDS 2.0 navigation section.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMNavigation(

  /**
   * The set of navigation links.
   */

  @JsonProperty(
    value = "links"
  )
  val links : List<WPMNavigationLink> = listOf()
) : WPMElement()
