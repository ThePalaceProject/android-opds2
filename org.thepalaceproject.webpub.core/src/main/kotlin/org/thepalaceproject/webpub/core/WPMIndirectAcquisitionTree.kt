package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMIndirectAcquisitionTree(
  @JsonProperty(
    value = "type",
    required = true
  )
  val type : String,

  @JsonProperty(
    value = "child"
  )
  val children: List<WPMIndirectAcquisitionTree> = listOf()
) : WPMElement()
