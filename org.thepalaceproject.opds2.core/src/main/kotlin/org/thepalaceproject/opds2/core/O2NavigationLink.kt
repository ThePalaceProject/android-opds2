package org.thepalaceproject.opds2.core

import one.irradia.mime.api.MIMEType
import java.net.URI

/**
 * An OPDS 2.0 navigation link.
 */

data class O2NavigationLink(

  /**
   * The target of the link.
   */

  val href : URI,

  /**
   * The title of the link.
   */

  val title : String,

  /**
   * The declared MIME type of the link, if any.
   */

  val type : MIMEType?,

  /**
   * The declared link relation, if any.
   */

  val relation : String?
) : O2Element()
