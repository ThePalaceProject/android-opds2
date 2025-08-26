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

  /**
   * The unique identifier for the publication.
   */

  @JsonProperty(
    value = "identifier"
  )
  val identifier : URI?,

  /**
   * The title of the publication.
   */

  @JsonProperty(
    value = "title"
  )
  val title : O2Title,

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
  val duration : Double = 0.0,

  /**
   * The subtitle of the publication.
   */

  @JsonProperty(
    value = "subtitle"
  )
  val subtitle : O2Title?,

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
   * The subjects that apply to the publication.
   */

  @JsonProperty(
    value = "subjects"
  )
  val subjects : List<O2Subject> = listOf(),

  /**
   * The author of the publication.
   */

  @JsonProperty(
    value = "author"
  )
  val author : O2Author? = null,

  /**
   * The narrator of the publication.
   */

  @JsonProperty(
    value = "narrator"
  )
  val narrator : O2Narrator? = null,

  /**
   * The text value used to sort the publication.
   */

  @JsonProperty(
    value = "sortAs"
  )
  val sortAs : String?,
) : O2Element()
