package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/metadata.schema.json"
 */

enum class WPMReadingProgression {
  @JsonProperty("rtl")
  RTL,
  @JsonProperty("ltr")
  LTR
}
