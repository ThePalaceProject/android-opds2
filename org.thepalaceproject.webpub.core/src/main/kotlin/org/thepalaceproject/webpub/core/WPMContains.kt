package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/metadata.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMContains(
  @JsonProperty(
    value = "article"
  )
  val article : List<WPMArticle> = listOf(),

  @JsonProperty(
    value = "chapter"
  )
  val chapter : List<WPMChapter> = listOf(),

  @JsonProperty(
    value = "episode"
  )
  val episode : List<WPMEpisode> = listOf(),

  @JsonProperty(
    value = "issue"
  )
  val issue : List<WPMIssue> = listOf(),

  @JsonProperty(
    value = "season"
  )
  val season : List<WPMSeason> = listOf(),

  @JsonProperty(
    value = "series"
  )
  val series : List<WPMSeries> = listOf(),

  @JsonProperty(
    value = "storyArc"
  )
  val storyArc : List<WPMStoryArc> = listOf(),

  @JsonProperty(
    value = "volume"
  )
  val volume : List<WPMVolume> = listOf(),
)
