package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.time.OffsetDateTime

class WPMContributorOrStringSerializer :
  StdSerializer<WPMContributorOrString>(WPMContributorOrString::class.java) {
  override fun serialize(
    value : WPMContributorOrString,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMContributor                              -> {
        gen.writeStartObject()

        value.name?.let { text ->
          gen.writeFieldName("name")
          gen.writeString(text)
        }
        value.identifier?.let { text ->
          gen.writeFieldName("identifier")
          gen.writeString(text.toString())
        }

        WPMArrays.writeArrayField(gen, "altIdentifier", value.altIdentifier)

        value.sortAs?.let { text ->
          gen.writeFieldName("sortAs")
          gen.writeString(text)
        }
        value.position?.let { text ->
          gen.writeFieldName("position")
          gen.writeNumber(text.toDouble())
        }
        if (value.links.isNotEmpty()) {
          gen.writeFieldName("links")
          value.links.forEach { link -> gen.writeObject(link) }
        }
        if (!value.role.isEmpty()) {
          gen.writeFieldName("role")
          gen.writeArray(value.role.toTypedArray(), 0, value.role.size)
        }

        gen.writeEndObject()
      }
      is WPMContributorOrString.WPMContributorString ->
        gen.writeString(value.value)
    }
  }
}