package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.net.URI

/**
 * A contributor.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class O2Contributor(

  /**
   * The name of the contributor.
   */

  val name : O2Name,

  /**
   * The identifier for the contributor.
   */

  val identifier : URI? = null,

  /**
   * The string used to sort the contributor name.
   */

  val sortAs : String = name.name,

  /**
   * The contributor links.
   */

  val links : List<O2Link> = listOf()
) : Comparable<O2Contributor> {

  override fun compareTo(other : O2Contributor) : Int {
    return this.sortAs.compareTo(other.sortAs)
  }
}

