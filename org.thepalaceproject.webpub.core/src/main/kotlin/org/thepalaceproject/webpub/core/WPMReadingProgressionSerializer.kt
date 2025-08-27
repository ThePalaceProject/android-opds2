package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.thepalaceproject.webpub.core.WPMReadingProgression.LTR
import org.thepalaceproject.webpub.core.WPMReadingProgression.RTL

class WPMReadingProgressionSerializer :
  StdSerializer<WPMReadingProgression>(WPMReadingProgression::class.java) {
  override fun serialize(
    value : WPMReadingProgression,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    generator.writeString(
      when (value) {
        LTR -> "ltr"
        RTL -> "rtl"
      }
    )
  }
}
