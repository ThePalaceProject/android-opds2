package org.thepalaceproject.opds2.core

import one.irradia.mime.api.MIMEType

data class O2LinkTemplated(
  val href : String,
  override val type : MIMEType? = null,
  override val relations : List<String> = listOf()
) : O2Link()
