package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import one.irradia.mime.api.MIMEType

class WPMLinkSerializer : StdSerializer<WPMLink>(WPMLink::class.java) {
  override fun serialize(
    value : WPMLink,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    when (value) {
      is WPMLinkBasic -> {
        generator.writeStartObject()

        generator.writeFieldName("href")
        generator.writeString(value.href.toString())

        value.title?.let { text ->
          generator.writeFieldName("title")
          generator.writeString(text)
        }
        value.type?.let { type ->
          this.writeType(type, generator)
        }

        if (value.relation.size == 1) {
          generator.writeFieldName("rel")
          generator.writeString(value.relation[0])
        } else if (value.relation.size > 1) {
          generator.writeFieldName("rel")
          generator.writeArray(value.relation.toTypedArray(), 0, value.relation.size)
        }

        value.properties?.let { properties ->
          generator.writeFieldName("properties")
          generator.writeObject(properties)
        }

        generator.writeEndObject()
      }
      is WPMLinkTemplated -> {
        generator.writeStartObject()

        generator.writeFieldName("href")
        generator.writeString(value.href)

        generator.writeFieldName("templated")
        generator.writeBoolean(true)

        value.title?.let { text ->
          generator.writeFieldName("title")
          generator.writeString(text)
        }
        value.type?.let { type ->
          this.writeType(type, generator)
        }

        if (value.relation.size == 1) {
          generator.writeFieldName("rel")
          generator.writeString(value.relation[0])
        } else if (value.relation.size > 1) {
          generator.writeFieldName("rel")
          generator.writeArray(value.relation.toTypedArray(), 0, value.relation.size)
        }

        value.properties?.let { properties ->
          generator.writeFieldName("properties")
          generator.writeObject(properties)
        }

        generator.writeEndObject()
      }
    }
  }

  private fun writeType(
    type : MIMEType,
    generator : JsonGenerator
  ) {
    val text = StringBuilder()
    text.append(type.toString())
    if (type.parameters.isNotEmpty()) {
      text.append(';')
      for ((k, v) in type.parameters) {
        text.append(k)
        text.append('=')
        text.append(v)
        text.append(';')
      }
    }
    generator.writeFieldName("type")
    generator.writeString(text.toString())
  }
}