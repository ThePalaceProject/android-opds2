package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMStoryArcSerializer :
  StdSerializer<WPMStoryArc>(WPMStoryArc::class.java) {
  override fun serialize(
    value : WPMStoryArc,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMStoryArc.WPMStoryArcNumber  -> {
        WPMNumbers.writeNumber(gen, value.number)
      }

      is WPMStoryArc.WPMStoryArcs -> {
        WPMArrays.writeArray(gen, value.storyArcs)
      }

      is WPMStoryArc.WPMStoryArcObject  -> {
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

        gen.writeFieldName("episode")
        gen.writeObject(value.episode)

        gen.writeFieldName("issue")
        gen.writeObject(value.issue)

        gen.writeEndObject()
      }
    }
  }
}