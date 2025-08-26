package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonProperty

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
