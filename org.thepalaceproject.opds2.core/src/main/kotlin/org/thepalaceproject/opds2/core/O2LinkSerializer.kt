package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import one.irradia.mime.api.MIMEType

class O2LinkSerializer : StdSerializer<O2Link>(O2Link::class.java) {
  override fun serialize(
    value : O2Link,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    when (value) {
      is O2LinkBasic     -> {
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
        value.relation?.let { text ->
          generator.writeFieldName("rel")
          generator.writeString(text)
        }
        value.properties?.let { properties ->
          generator.writeFieldName("properties")
          generator.writeObject(properties)
        }

        generator.writeEndObject()
      }
      is O2LinkTemplated -> {
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
        value.relation?.let { text ->
          generator.writeFieldName("rel")
          generator.writeString(text)
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