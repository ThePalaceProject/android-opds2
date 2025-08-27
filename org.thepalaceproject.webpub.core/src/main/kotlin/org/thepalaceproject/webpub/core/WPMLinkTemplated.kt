package org.thepalaceproject.webpub.core

import one.irradia.mime.api.MIMEType

data class WPMLinkTemplated(
  val href : String,
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
