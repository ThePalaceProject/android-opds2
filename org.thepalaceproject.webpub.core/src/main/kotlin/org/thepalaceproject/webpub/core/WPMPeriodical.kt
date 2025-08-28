package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMPeriodical {

  data class WPMPeriodicalString(
    val value : String
  ) : WPMPeriodical()

  data class WPMPeriodicals(
    val value : List<WPMPeriodical>
  ) : WPMPeriodical()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMPeriodicalObject(
    @JsonProperty(
      value = "name",
      required = true
    )
    val name : WPMLanguageMap,

    /**
     * The unique identifier for the periodical.
     */

    @JsonProperty(
      value = "identifier"
    )
    val identifier : URI?,

    /**
     * The alternative identifier for the periodical.
     */

    @JsonProperty(
      value = "altIdentifier"
    )
    val altIdentifier : URI?,

    /**
     * The text value used to sort the periodical.
     */

    @JsonProperty(
      value = "sortAs"
    )
    val sortAs : String?,

    /**
     * The position of the periodical.
     */

    @JsonProperty(
      value = "position"
    )
    val position : Number?,

    /**
     * The set of periodical links.
     */

    @JsonProperty(
      value = "links"
    )
    val links : List<WPMLink> = listOf(),

    @JsonProperty("issue")
    val issue : WPMIssue?,

    @JsonProperty("volume")
    val volume : WPMVolume?,
  ) : WPMPeriodical()
}
