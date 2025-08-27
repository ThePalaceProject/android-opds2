package org.thepalaceproject.webpub.core

import one.irradia.mime.api.MIMEType
import java.net.URI

data class WPMLinkBasic(
  /**
   * The target of the link.
   */

  val href : URI,

  override val type : MIMEType?,
  override val relation : List<String>,
  override val title : String?,
  override val properties: WPMLinkProperties?,
  override val height : Int?,
  override val width : Int?,
  override val size : Int?,
  override val bitrate : Number?,
  override val duration : Number?,
  override val alternate : List<WPMLink>,
  override val children : List<WPMLink>
) : WPMLink()
