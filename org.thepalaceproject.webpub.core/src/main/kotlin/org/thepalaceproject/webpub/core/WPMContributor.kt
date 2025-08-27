package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/contributor-object.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMContributor(
  @JsonProperty(
    value = "name"
  )
  val name : String?,

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
    value = "role"
  )
  val role : List<String> = listOf(),

  @JsonProperty(
    value = "position"
  )
  val position : Number?,

  @JsonProperty(
    value = "links"
  )
  val links: List<WPMLink> = listOf()
) : WPMContributorOrString()
