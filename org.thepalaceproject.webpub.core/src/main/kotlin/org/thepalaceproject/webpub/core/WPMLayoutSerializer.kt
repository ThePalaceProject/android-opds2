package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.thepalaceproject.webpub.core.WPMLayout.FIXED
import org.thepalaceproject.webpub.core.WPMLayout.REFLOWABLE
import org.thepalaceproject.webpub.core.WPMLayout.SCROLLED

class WPMLayoutSerializer :
  StdSerializer<WPMLayout>(WPMLayout::class.java) {
  override fun serialize(
    value : WPMLayout,
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
