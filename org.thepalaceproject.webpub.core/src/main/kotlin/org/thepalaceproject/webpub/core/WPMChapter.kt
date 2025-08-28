package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMChapter {

  data class WPMChapterNumber(
    val number : Number
  ) : WPMChapter()

  data class WPMChapters(
    val value : List<WPMChapter>
  ) : WPMChapter()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMChapterObject(
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
  ) : WPMChapter()
}
