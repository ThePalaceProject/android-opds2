package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class O2LanguageMapSerializer : StdSerializer<O2LanguageMap>(O2LanguageMap::class.java) {
  override fun serialize(
    value : O2LanguageMap,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    when (value) {
      is O2LanguageMap.Mapped -> {
        generator.writeStartObject()
        for ((k, v) in value.byLanguage) {
          generator.writeFieldName(k)
          generator.writeString(v)
        }
        generator.writeEndObject()
      }
      is O2LanguageMap.Scalar -> {
        generator.writeString(value.value)
      }
    }
  }
}