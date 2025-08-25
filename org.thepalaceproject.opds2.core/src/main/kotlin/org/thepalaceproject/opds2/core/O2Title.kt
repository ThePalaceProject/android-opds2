package org.thepalaceproject.opds2.core

data class O2Title(
  val title : String = "",
  val byLanguage : Map<String, String> = mapOf()
) : O2Element() {

  fun ofLanguageOrDefault(language : String) : String =
    if (this.byLanguage.containsKey(language)) {
      this.byLanguage[language]!!
    } else {
      this.title
    }
}
