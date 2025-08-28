package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMVolume {

  data class WPMVolumeNumber(
    val number : Number
  ) : WPMVolume()

  data class WPMVolumes(
    val volumes : List<WPMVolume>
  ) : WPMVolume()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMVolumeObject(
    @JsonProperty(
      value = "name",
      required = true
    )
    val name : WPMLanguageMap,

    @JsonProperty(
      value = "identifier"
    )
    val identifier : URI?,

    @JsonProperty(
      value = "altIdentifier"
    )
    val altIdentifier : URI?,

    @JsonProperty(
      value = "sortAs"
    )
    val sortAs : String?,

    @JsonProperty(
      value = "position"
    )
    val position : Number?,

    @JsonProperty(
      value = "links"
    )
    val links : List<WPMLink> = listOf(),

    @JsonProperty("chapter")
    val chapter : WPMChapter?,

    @JsonProperty("issue")
    val issue : WPMIssue?,

    @JsonProperty("storyArc")
    val storyArc : WPMStoryArc?,
  ) : WPMVolume()
}
