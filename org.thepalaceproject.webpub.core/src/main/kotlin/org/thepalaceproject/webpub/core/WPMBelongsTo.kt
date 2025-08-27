package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/metadata.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMBelongsTo(
  @JsonProperty(
    value = "collection"
  )
  val collection : WPMContributor?,

  @JsonProperty(
    value = "series"
  )
  val series : WPMContributor?,
)
