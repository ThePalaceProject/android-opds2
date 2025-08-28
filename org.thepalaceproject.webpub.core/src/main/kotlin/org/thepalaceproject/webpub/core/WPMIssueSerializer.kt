package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMIssueSerializer :
  StdSerializer<WPMIssue>(WPMIssue::class.java) {
  override fun serialize(
    value : WPMIssue,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMIssue.WPMIssueNumber  -> {
        WPMNumbers.writeNumber(gen, value.number)
      }

      is WPMIssue.WPMIssues -> {
        WPMArrays.writeArray(gen, value.numbers)
      }

      is WPMIssue.WPMIssueObject  -> {
        gen.writeStartObject()

        gen.writeFieldName("name")
        gen.writeObject(value.name)

        gen.writeFieldName("identifier")
        gen.writeObject(value.identifier)

        WPMArrays.writeArrayField(gen, "altIdentifier", value.altIdentifier)

        gen.writeFieldName("sortAs")
        gen.writeObject(value.sortAs)

        gen.writeFieldName("position")
        gen.writeObject(value.position)

        WPMArrays.writeArrayField(gen, "links", value.links)

        gen.writeFieldName("chapter")
        gen.writeObject(value.chapter)

        gen.writeFieldName("article")
        gen.writeObject(value.article)

        gen.writeEndObject()
      }
    }
  }
}