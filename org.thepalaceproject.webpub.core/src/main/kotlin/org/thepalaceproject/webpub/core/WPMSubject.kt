package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMSubject(
  @JsonProperty(
    value = "scheme"
  )
  val scheme : URI?,

  @JsonProperty(
    value = "name",
    required = true
  )
  val name : String,

  @JsonProperty(
    value = "sortAs"
  )
  val sortAs: String?,

  @JsonProperty(
    value = "code"
  )
  val code: String?,

  @JsonProperty(
    value = "links"
  )
  val links: List<WPMLink> = listOf()

) : WPMSubjectOrString(), Comparable<WPMSubject> {
  override fun compareTo(other : WPMSubject) : Int {
    val s0 = this.sortAs ?: this.name
    val s1 = other.sortAs ?: other.name
    return s0.compareTo(s1)
  }
}
