package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMLanguageMapSerializer : StdSerializer<WPMLanguageMap>(WPMLanguageMap::class.java) {
  override fun serialize(
    value : WPMLanguageMap,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    when (value) {
      is WPMLanguageMap.Mapped -> {
        generator.writeStartObject()
        for ((k, v) in value.byLanguage) {
          generator.writeFieldName(k)
          generator.writeString(v)
        }
        generator.writeEndObject()
      }
      is WPMLanguageMap.Scalar -> {
        generator.writeString(value.value)
      }
    }
  }
}