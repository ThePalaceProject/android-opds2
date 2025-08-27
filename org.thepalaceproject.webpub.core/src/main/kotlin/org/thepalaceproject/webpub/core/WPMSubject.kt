package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMSubject(
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
) : WPMElement(), Comparable<WPMSubject> {
  override fun compareTo(other : WPMSubject) : Int {
    return this.sortAs.compareTo(other.sortAs)
  }
}
