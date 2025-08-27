package org.thepalaceproject.webpub.core

import one.irradia.mime.api.MIMEType
import java.net.URI

data class O2LinkBasic(
  /**
   * The target of the link.
   */

  val href : URI,

  override val type : MIMEType?,
  override val relation : List<String>,
  override val title : String?,
  override val properties: O2LinkProperties?,
  override val height : Int?,
  override val width : Int?,
  override val size : Int?,
  override val bitrate : Number?,
  override val duration : Number?,
  override val alternate : List<O2Link>,
  override val children : List<O2Link>
) : O2Link()
