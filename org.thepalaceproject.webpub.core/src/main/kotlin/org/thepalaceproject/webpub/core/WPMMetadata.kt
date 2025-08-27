package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI
import java.time.OffsetDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMMetadata @JsonCreator constructor(
  /**
   * The type of the publication.
   */

  @JsonProperty(
    value = "@type"
  )
  val type : String? = null,

  @JsonProperty(
    value = "conformsTo"
  )
  val conformsTo : List<URI> = listOf(),

  /**
   * The title of the publication.
   */

  @JsonProperty(
    value = "title"
  )
  val title : WPMLanguageMap,

  /**
   * The text value used to sort the publication.
   */

  @JsonProperty(
    value = "sortAs"
  )
  val sortAs : WPMLanguageMap?,

  /**
   * The subtitle of the publication.
   */

  @JsonProperty(
    value = "subtitle"
  )
  val subtitle : WPMLanguageMap?,

  /**
   * The unique identifier for the publication.
   */

  @JsonProperty(
    value = "identifier"
  )
  val identifier : URI?,

  /**
   * The alternative identifier for the publication.
   */

  @JsonProperty(
    value = "altIdentifier"
  )
  val altIdentifier : URI?,

  /**
   * The accessibility metadata.
   */

  @JsonProperty(
    value = "accessibility"
  )
  val accessibility : WPMAccessibility?,

  /**
   * The time the publication was last modified.
   */

  @JsonProperty(
    value = "modified"
  )
  val modified : OffsetDateTime?,

  /**
   * The time the publication was published.
   */

  @JsonProperty(
    value = "published"
  )
  val published : OffsetDateTime?,

  /**
   * The languages that apply to the publication.
   */

  @JsonProperty(
    value = "languages"
  )
  val languages : List<String> = listOf(),

  /**
   * The author of the publication.
   */

  @JsonProperty(
    value = "author"
  )
  val author : WPMContributor? = null,

  /**
   * The translator of the publication.
   */

  @JsonProperty(
    value = "translator"
  )
  val translator : WPMContributor? = null,

  /**
   * The editor of the publication.
   */

  @JsonProperty(
    value = "editor"
  )
  val editor : WPMContributor? = null,

  /**
   * The artist of the publication.
   */

  @JsonProperty(
    value = "artist"
  )
  val artist : WPMContributor? = null,

  /**
   * The illustrator of the publication.
   */

  @JsonProperty(
    value = "illustrator"
  )
  val illustrator : WPMContributor? = null,

  /**
   * The letterer of the publication.
   */

  @JsonProperty(
    value = "letterer"
  )
  val letterer : WPMContributor? = null,

  /**
   * The penciler of the publication.
   */

  @JsonProperty(
    value = "penciler"
  )
  val penciler : WPMContributor? = null,

  /**
   * The colorist of the publication.
   */

  @JsonProperty(
    value = "colorist"
  )
  val colorist : WPMContributor? = null,

  /**
   * The inker of the publication.
   */

  @JsonProperty(
    value = "inker"
  )
  val inker : WPMContributor? = null,

  /**
   * The narrator of the publication.
   */

  @JsonProperty(
    value = "narrator"
  )
  val narrator : WPMContributor? = null,

  /**
   * The contributor of the publication.
   */

  @JsonProperty(
    value = "contributor"
  )
  val contributor : WPMContributor? = null,

  /**
   * The publisher of the publication.
   */

  @JsonProperty(
    value = "publisher"
  )
  val publisher : WPMContributor? = null,

  /**
   * The imprint of the publication.
   */

  @JsonProperty(
    value = "imprint"
  )
  val imprint : WPMContributor? = null,

  /**
   * The subjects that apply to the publication.
   */

  @JsonProperty(
    value = "subject"
  )
  val subjects : List<WPMSubject> = listOf(),

  /**
   * The layout of the publication.
   */

  @JsonProperty(
    value = "layout"
  )
  val layout : WPMLayout?,

  /**
   * The description of the publication.
   */

  @JsonProperty(
    value = "description"
  )
  val description : String = "",

  /**
   * The duration of the publication.
   */

  @JsonProperty(
    value = "duration"
  )
  val duration : Number?,

  /**
   * The number of pages in the publication.
   */

  @JsonProperty(
    value = "numberOfPages"
  )
  val numberOfPages : Number?,

  /**
   * The owner of the publication.
   */

  @JsonProperty(
    value = "belongsTo"
  )
  val belongsTo : WPMBelongsTo?,
) : WPMElement()
