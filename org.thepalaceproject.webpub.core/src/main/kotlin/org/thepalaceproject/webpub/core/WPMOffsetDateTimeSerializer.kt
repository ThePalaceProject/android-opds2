package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.time.OffsetDateTime

class WPMOffsetDateTimeSerializer :
  StdSerializer<OffsetDateTime>(OffsetDateTime::class.java) {
  override fun serialize(
    value : OffsetDateTime,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    return generator.writeString(value.toString())
  }
}
