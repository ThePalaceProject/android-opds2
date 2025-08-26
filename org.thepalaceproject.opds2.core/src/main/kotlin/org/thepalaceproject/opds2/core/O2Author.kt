package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

data class O2Author(
  @JsonProperty(
    value = "name",
    required = true
  )
  override val name : String,

  @JsonProperty(
    value = "links"
  )
  override val links: List<O2Link> = listOf()
) : O2Element(), O2PersonType
