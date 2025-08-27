package org.thepalaceproject.opds2.core

import java.util.SortedMap

/**
 * A language-mapped string.
 *
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/language-map.schema.json"
 */

sealed class O2LanguageMap() : O2Element() {

  data class Scalar(
    val value : String
  ) : O2LanguageMap()

  data class Mapped(
    val byLanguage : SortedMap<String, String>
  ) : O2LanguageMap()
}
