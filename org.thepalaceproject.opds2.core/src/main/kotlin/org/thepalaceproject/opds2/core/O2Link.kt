package org.thepalaceproject.opds2.core

import one.irradia.mime.api.MIMEType

sealed class O2Link : O2Element() {

  /**
   * The declared MIME type of the link, if any.
   */

  abstract val type : MIMEType?

  /**
   * The declared link relation, if any.
   */

  abstract val relation : String?

  /**
   * The declared link title, if any.
   */

  abstract val title : String?
}
