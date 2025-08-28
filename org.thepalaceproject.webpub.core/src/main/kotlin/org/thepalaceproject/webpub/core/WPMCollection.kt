package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class WPMCollection {

  data class WPMCollectionString(
    val value : String
  ) : WPMCollection()

  data class WPMCollections(
    val value : List<WPMCollection>
  ) : WPMCollection()

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class WPMCollectionObject(
    @JsonProperty(
      value = "name",
      required = true
    )
    val name : WPMLanguageMap,

    /**
     * The unique identifier for the collection.
     */

    @JsonProperty(
      value = "identifier"
    )
    val identifier : URI?,

    /**
     * The alternative identifier for the collection.
     */

    @JsonProperty(
      value = "altIdentifier"
    )
    val altIdentifier : URI?,

    /**
     * The text value used to sort the collection.
     */

    @JsonProperty(
      value = "sortAs"
    )
    val sortAs : String?,

    /**
     * The position of the collection.
     */

    @JsonProperty(
      value = "position"
    )
    val position : Number?,

    /**
     * The set of collection links.
     */

    @JsonProperty(
      value = "links"
    )
    val links : List<WPMLink> = listOf(),
  ) : WPMCollection()
}
