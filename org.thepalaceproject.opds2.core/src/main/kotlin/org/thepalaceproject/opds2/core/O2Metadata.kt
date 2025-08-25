package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI
import java.time.OffsetDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Metadata @JsonCreator constructor(
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
  val languagesNullable : List<String> = listOf(),

  /**
   * The text value used to sort the publication.
   */

  @JsonProperty(
    value = "sortAs"
  )
  val sortAs : String?,
) : O2Element()
