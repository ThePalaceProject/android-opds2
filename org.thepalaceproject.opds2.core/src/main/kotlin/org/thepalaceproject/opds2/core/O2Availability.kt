package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonProperty

data class O2Availability(
  @JsonProperty(
    value = "state",
    required = true
  )
  val state : String
) : O2Element()
