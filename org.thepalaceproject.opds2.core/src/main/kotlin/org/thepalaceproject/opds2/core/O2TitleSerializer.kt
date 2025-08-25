package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class O2TitleSerializer : StdSerializer<O2Title>(O2Title::class.java) {
  override fun serialize(
    value : O2Title,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    TODO("Not yet implemented")
  }
}