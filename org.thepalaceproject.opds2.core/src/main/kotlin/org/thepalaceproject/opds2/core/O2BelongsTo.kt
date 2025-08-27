package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/metadata.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2BelongsTo(
  @JsonProperty(
    value = "collection"
  )
  val collection : O2Contributor?,

  @JsonProperty(
    value = "series"
  )
  val series : O2Contributor?,
)
