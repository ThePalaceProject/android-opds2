package org.thepalaceproject.opds2.core

import one.irradia.mime.api.MIMEType
import java.net.URI

data class O2LinkBasic(
  /**
   * The target of the link.
   */

  val href : URI,

  override val type : MIMEType? = null,
  override val relation : String? = null,
  override val title : String? = null,
  override val properties: O2LinkProperties?
) : O2Link()
