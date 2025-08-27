package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonProperty

data class O2Availability(
  @JsonProperty(
    value = "state",
    required = true
  )
  val state : String,

  @JsonProperty(
    value = "indirectAcquisition"
  )
  val indirectAcquisitionTree : O2IndirectAcquisitionTree? = null
) : O2Element()
