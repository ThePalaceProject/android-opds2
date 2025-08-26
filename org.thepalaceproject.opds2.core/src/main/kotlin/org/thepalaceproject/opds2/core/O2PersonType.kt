package org.thepalaceproject.opds2.core

sealed interface O2PersonType {

  val name : String

  val links: List<O2Link>
}
