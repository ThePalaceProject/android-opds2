package org.thepalaceproject.opds2.core

data class O2Name(
  val name : String = "",
  val byLanguage : Map<String, String> = mapOf()
) : O2Element() {

  fun ofLanguageOrDefault(language : String) : String =
    if (this.byLanguage.containsKey(language)) {
      this.byLanguage[language]!!
    } else {
      this.name
    }
}
