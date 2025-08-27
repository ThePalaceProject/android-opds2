package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonProperty

data class WPMAvailability(
  @JsonProperty(
    value = "state",
    required = true
  )
  val state : String,

  @JsonProperty(
    value = "indirectAcquisition"
  )
  val indirectAcquisitionTree : WPMIndirectAcquisitionTree? = null
) : WPMElement()
