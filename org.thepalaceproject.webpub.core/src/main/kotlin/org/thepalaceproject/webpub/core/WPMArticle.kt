package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMArticle {

  data class WPMArticleString(
    val value : String
  ) : WPMArticle()

  data class WPMArticles(
    val value : List<WPMArticle>
  ) : WPMArticle()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMArticleObject(
    @JsonProperty(
      value = "name",
      required = true
    )
    val name : WPMLanguageMap,

    /**
     * The unique identifier for the article.
     */

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

    /**
     * The text value used to sort the article.
     */

    @JsonProperty(
      value = "sortAs"
    )
    val sortAs : String?,

    /**
     * The author of the article.
     */

    @JsonProperty(
      value = "author"
    )
    val author : List<WPMContributorOrString> = listOf(),

    /**
     * The translator of the article.
     */

    @JsonProperty(
      value = "translator"
    )
    val translator : List<WPMContributorOrString> = listOf(),

    /**
     * The editor of the article.
     */

    @JsonProperty(
      value = "editor"
    )
    val editor : List<WPMContributorOrString> = listOf(),

    /**
     * The artist of the article.
     */

    @JsonProperty(
      value = "artist"
    )
    val artist : List<WPMContributorOrString> = listOf(),

    /**
     * The illustrator of the article.
     */

    @JsonProperty(
      value = "illustrator"
    )
    val illustrator : List<WPMContributorOrString> = listOf(),

    /**
     * The contributor of the article.
     */

    @JsonProperty(
      value = "contributor"
    )
    val contributor : List<WPMContributorOrString> = listOf(),

    /**
     * The description of the article.
     */

    @JsonProperty(
      value = "description"
    )
    val description : String = "",

    /**
     * The number of pages in the article.
     */

    @JsonProperty(
      value = "numberOfPages"
    )
    val numberOfPages : Number?,

    /**
     * The position of the article.
     */

    @JsonProperty(
      value = "position"
    )
    val position : Number?,

    /**
     * The set of article links.
     */

    @JsonProperty(
      value = "links"
    )
    val links : List<WPMLink> = listOf(),
  ) : WPMArticle()
}
