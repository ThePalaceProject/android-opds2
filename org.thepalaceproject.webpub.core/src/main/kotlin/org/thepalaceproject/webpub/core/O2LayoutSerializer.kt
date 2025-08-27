package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.thepalaceproject.webpub.core.O2Layout.FIXED
import org.thepalaceproject.webpub.core.O2Layout.REFLOWABLE
import org.thepalaceproject.webpub.core.O2Layout.SCROLLED

class O2LayoutSerializer :
  StdSerializer<O2Layout>(O2Layout::class.java) {
  override fun serialize(
    value : O2Layout,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    generator.writeString(
      when (value) {
        FIXED      -> "fixed"
        REFLOWABLE -> "reflowable"
        SCROLLED   -> "scrolled"
      }
    )
  }
}
