package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/contributor-object.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMSubjectOrString() : WPMElement() {
  data class WPMSubjectString(
    val value: String
  ): WPMSubjectOrString()
}
