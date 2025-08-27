package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2IndirectAcquisitionTree(
  @JsonProperty(
    value = "type",
    required = true
  )
  val type : String,

  @JsonProperty(
    value = "child"
  )
  val children: List<O2IndirectAcquisitionTree> = listOf()
) : O2Element()
