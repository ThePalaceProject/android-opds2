package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.thepalaceproject.opds2.core.O2ReadingProgression.*

class O2ReadingProgressionSerializer :
  StdSerializer<O2ReadingProgression>(O2ReadingProgression::class.java) {
  override fun serialize(
    value : O2ReadingProgression,
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
