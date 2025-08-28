package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMStoryArc {

  data class WPMStoryArcNumber(
    val number : Number
  ) : WPMStoryArc()

  data class WPMStoryArcs(
    val storyArcs : List<WPMStoryArc>
  ) : WPMStoryArc()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMStoryArcObject(
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

    @JsonProperty("episode")
    val episode : WPMEpisode?,

    @JsonProperty("issue")
    val issue : WPMIssue?
  ) : WPMStoryArc()
}
