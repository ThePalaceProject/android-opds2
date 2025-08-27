package org.thepalaceproject.webpub.core

import java.util.SortedMap

/**
 * A language-mapped string.
 *
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/language-map.schema.json"
 */

sealed class WPMLanguageMap() : WPMElement() {

  data class Scalar(
    val value : String
  ) : WPMLanguageMap()

  data class Mapped(
    val byLanguage : SortedMap<String, String>
  ) : WPMLanguageMap()
}
