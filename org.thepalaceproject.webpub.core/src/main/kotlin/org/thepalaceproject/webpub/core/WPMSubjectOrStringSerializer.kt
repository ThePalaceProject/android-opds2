package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.time.OffsetDateTime

class WPMSubjectOrStringSerializer :
  StdSerializer<WPMSubjectOrString>(WPMSubjectOrString::class.java) {
  override fun serialize(
    value : WPMSubjectOrString,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMSubject                              -> {
        gen.writeStartObject()

        value.name.let { text ->
          gen.writeFieldName("name")
          gen.writeString(text)
        }
        value.sortAs?.let { text ->
          gen.writeFieldName("sortAs")
          gen.writeString(text)
        }
        value.code?.let { text ->
          gen.writeFieldName("code")
          gen.writeString(text)
        }
        value.scheme?.let { text ->
          gen.writeFieldName("scheme")
          gen.writeString(text.toString())
        }
        if (value.links.isNotEmpty()) {
          gen.writeFieldName("links")
          value.links.forEach { link -> gen.writeObject(link) }
        }

        gen.writeEndObject()
      }
      is WPMSubjectOrString.WPMSubjectString ->
        gen.writeString(value.value)
    }
  }
}