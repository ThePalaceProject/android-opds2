package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMChapterSerializer :
  StdSerializer<WPMChapter>(WPMChapter::class.java) {
  override fun serialize(
    value : WPMChapter,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMChapter.WPMChapterNumber  -> {
        WPMNumbers.writeNumber(gen, value.number)
      }

      is WPMChapter.WPMChapters -> {
        WPMArrays.writeArray(gen, value.value)
      }

      is WPMChapter.WPMChapterObject  -> {
        gen.writeStartObject()

        gen.writeFieldName("name")
        gen.writeObject(value.name)

        gen.writeFieldName("identifier")
        gen.writeObject(value.identifier)

        gen.writeFieldName("altIdentifier")
        gen.writeObject(value.altIdentifier)

        gen.writeFieldName("sortAs")
        gen.writeObject(value.sortAs)

        gen.writeFieldName("position")
        gen.writeObject(value.position)

        WPMArrays.writeArrayField(gen, "links", value.links)

        gen.writeEndObject()
      }
    }
  }
}