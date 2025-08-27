package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/metadata.schema.json"
 */

enum class WPMLayout {
  @JsonProperty("fixed")
  FIXED,

  @JsonProperty("reflowable")
  REFLOWABLE,

  @JsonProperty("scrolled")
  SCROLLED
}
