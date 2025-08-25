package org.thepalaceproject.opds2.core

import one.irradia.mime.api.MIMEType

sealed class O2Link : O2Element() {

  /**
   * The declared MIME type of the link, if any.
   */

  abstract val type : MIMEType?

  /**
   * The declared link relations, if any.
   */

  abstract val relations : List<String>
}
