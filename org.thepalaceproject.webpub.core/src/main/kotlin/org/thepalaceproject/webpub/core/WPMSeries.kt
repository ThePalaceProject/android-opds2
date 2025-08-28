package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMSeries {

  data class WPMSeriesString(
    val value : String
  ) : WPMSeries()

  data class WPMSeriesSet(
    val value : List<WPMSeries>
  ) : WPMSeries()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMSeriesObject(
    @JsonProperty(
      value = "name",
      required = true
    )
    val name : WPMLanguageMap,

    /**
     * The unique identifier for the series.
     */

    @JsonProperty(
      value = "identifier"
    )
    val identifier : URI?,

    /**
     * The alternative identifier for the series.
     */

    @JsonProperty(
      value = "altIdentifier"
    )
    val altIdentifier : URI?,

    /**
     * The text value used to sort the series.
     */

    @JsonProperty(
      value = "sortAs"
    )
    val sortAs : String?,

    /**
     * The position of the series.
     */

    @JsonProperty(
      value = "position"
    )
    val position : Number?,

    /**
     * The set of series links.
     */

    @JsonProperty(
      value = "links"
    )
    val links : List<WPMLink> = listOf(),

    @JsonProperty("chapter")
    val chapter : WPMChapter?,

    @JsonProperty("episode")
    val episode : WPMEpisode?,

    @JsonProperty("issue")
    val issue : WPMIssue?,

    @JsonProperty("season")
    val season : WPMSeason?,

    @JsonProperty("storyArc")
    val storyArc : WPMStoryArc?,

    @JsonProperty("volume")
    val volume : WPMVolume?,
  ) : WPMSeries()
}
