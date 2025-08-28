package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMIssue {

  data class WPMIssueNumber(
    val number : Number
  ) : WPMIssue()

  data class WPMIssues(
    val numbers : List<WPMIssue>
  ) : WPMIssue()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMIssueObject(
    @JsonProperty(
      value = "name"
    )
    val name : WPMLanguageMap?,

    @JsonProperty(
      value = "identifier"
    )
    val identifier : URI?,

    /**
     * The alternative identifier(s).
     */

    @JsonProperty(
      value = "altIdentifier"
    )
    val altIdentifier : List<String> = listOf(),

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

    @JsonProperty("article")
    val article : WPMArticle?,

    @JsonProperty("chapter")
    val chapter : WPMChapter?
  ) : WPMIssue()
}
