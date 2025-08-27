package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Subject(
  @JsonProperty(
    value = "scheme"
  )
  val scheme : URI,

  @JsonProperty(
    value = "name"
  )
  val name : String,

  @JsonProperty(
    value = "sortAs"
  )
  val sortAs: String
) : O2Element(), Comparable<O2Subject> {
  override fun compareTo(other : O2Subject) : Int {
    return this.sortAs.compareTo(other.sortAs)
  }
}
