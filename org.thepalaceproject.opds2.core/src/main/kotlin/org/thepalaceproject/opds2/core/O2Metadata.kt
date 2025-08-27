package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI
import java.time.OffsetDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Metadata @JsonCreator constructor(
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
  val title : O2LanguageMap,

  /**
   * The text value used to sort the publication.
   */

  @JsonProperty(
    value = "sortAs"
  )
  val sortAs : O2LanguageMap?,

  /**
   * The subtitle of the publication.
   */

  @JsonProperty(
    value = "subtitle"
  )
  val subtitle : O2LanguageMap?,

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
  val author : O2Contributor? = null,

  /**
   * The translator of the publication.
   */

  @JsonProperty(
    value = "translator"
  )
  val translator : O2Contributor? = null,

  /**
   * The editor of the publication.
   */

  @JsonProperty(
    value = "editor"
  )
  val editor : O2Contributor? = null,

  /**
   * The artist of the publication.
   */

  @JsonProperty(
    value = "artist"
  )
  val artist : O2Contributor? = null,

  /**
   * The illustrator of the publication.
   */

  @JsonProperty(
    value = "illustrator"
  )
  val illustrator : O2Contributor? = null,

  /**
   * The letterer of the publication.
   */

  @JsonProperty(
    value = "letterer"
  )
  val letterer : O2Contributor? = null,

  /**
   * The penciler of the publication.
   */

  @JsonProperty(
    value = "penciler"
  )
  val penciler : O2Contributor? = null,

  /**
   * The colorist of the publication.
   */

  @JsonProperty(
    value = "colorist"
  )
  val colorist : O2Contributor? = null,

  /**
   * The inker of the publication.
   */

  @JsonProperty(
    value = "inker"
  )
  val inker : O2Contributor? = null,

  /**
   * The narrator of the publication.
   */

  @JsonProperty(
    value = "narrator"
  )
  val narrator : O2Contributor? = null,

  /**
   * The contributor of the publication.
   */

  @JsonProperty(
    value = "contributor"
  )
  val contributor : O2Contributor? = null,

  /**
   * The publisher of the publication.
   */

  @JsonProperty(
    value = "publisher"
  )
  val publisher : O2Contributor? = null,

  /**
   * The imprint of the publication.
   */

  @JsonProperty(
    value = "imprint"
  )
  val imprint : O2Contributor? = null,

  /**
   * The subjects that apply to the publication.
   */

  @JsonProperty(
    value = "subject"
  )
  val subjects : List<O2Subject> = listOf(),

  /**
   * The layout of the publication.
   */

  @JsonProperty(
    value = "layout"
  )
  val layout : O2Layout?,

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
  val belongsTo : O2BelongsTo?,
) : O2Element()
