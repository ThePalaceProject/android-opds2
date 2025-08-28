package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMSeason {

  data class WPMSeasonNumber(
    val number : Number
  ) : WPMSeason()

  data class WPMSeasons(
    val seasons : List<WPMSeason>
  ) : WPMSeason()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMSeasonObject(
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

    @JsonProperty("episode")
    val episode : WPMEpisode?,
  ) : WPMSeason()
}
