package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/link.schema.json"
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/extensions/encryption/properties.schema.json"
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/extensions/epub/properties.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2LinkProperties(
  @JsonProperty(
    value = "availability"
  )
  val availability : O2Availability?,

  @JsonProperty(
    value = "encrypted"
  )
  val encrypted : O2Encrypted?
) : O2Element()
