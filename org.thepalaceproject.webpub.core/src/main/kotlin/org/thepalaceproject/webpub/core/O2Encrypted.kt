package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/extensions/encryption/properties.schema.json"
 */

@O2Extension
@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Encrypted(
  @JsonProperty(
    value = "algorithm",
    required = true
  )
  val algorithm : URI,

  @JsonProperty(
    value = "compression"
  )
  val compression : String?,

  @JsonProperty(
    value = "originalLength"
  )
  val originalLength : Int?,

  @JsonProperty(
    value = "profile"
  )
  val profile : URI?,

  @JsonProperty(
    value = "scheme"
  )
  val scheme : URI?
) : O2Element()
