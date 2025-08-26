package org.thepalaceproject.opds2.core

import one.irradia.mime.api.MIMEType

data class O2LinkTemplated(
  val href : String,
  override val type : MIMEType? = null,
  override val relation : String? = null,
  override val title : String? = null,
  override val properties: O2LinkProperties?
) : O2Link()
