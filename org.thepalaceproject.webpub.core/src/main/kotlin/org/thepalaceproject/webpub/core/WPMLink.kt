package org.thepalaceproject.webpub.core

import one.irradia.mime.api.MIMEType

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/link.schema.json"
 */

sealed class WPMLink : WPMElement() {

  /**
   * The declared MIME type of the link, if any.
   */

  abstract val type : MIMEType?

  /**
   * The declared link relation, if any.
   */

  abstract val relation : List<String>

  /**
   * The declared link title, if any.
   */

  abstract val title : String?

  /**
   * The declared link properties, if any
   */

  abstract val properties: WPMLinkProperties?

  /**
   * Height of the linked resource in pixels.
   */

  abstract val height: Int?

  /**
   * Width of the linked resource in pixels.
   */

  abstract val width: Int?

  /**
   * Original size of the resource in bytes, prior to any use of encryption or compression in an archive.
   */

  abstract val size: Int?

  /**
   * Bitrate of the linked resource in kbps.
   */

  abstract val bitrate: Number?

  /**
   * Length of the linked resource in seconds.
   */

  abstract val duration: Number?

  /**
   * Alternate resources for the linked resource
   */

  abstract val alternate: List<WPMLink>

  /**
   * Resources that are children of the linked resource, in the context of a given collection role
   */

  abstract val children: List<WPMLink>
}
