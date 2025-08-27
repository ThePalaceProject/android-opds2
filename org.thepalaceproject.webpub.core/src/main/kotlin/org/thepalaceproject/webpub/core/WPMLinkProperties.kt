package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/link.schema.json"
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/extensions/encryption/properties.schema.json"
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/extensions/epub/properties.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMLinkProperties(
  @JsonProperty(
    value = "availability"
  )
  val availability : WPMAvailability?,

  @JsonProperty(
    value = "encrypted"
  )
  val encrypted : WPMEncrypted?
) : WPMElement()
