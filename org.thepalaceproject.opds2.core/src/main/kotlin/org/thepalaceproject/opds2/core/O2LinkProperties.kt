package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2LinkProperties(
  @JsonProperty(
    value = "availability"
  )
  val availability : O2Availability?
) : O2Element()
