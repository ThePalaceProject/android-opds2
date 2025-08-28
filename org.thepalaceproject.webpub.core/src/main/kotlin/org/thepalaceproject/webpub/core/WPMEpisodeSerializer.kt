package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMEpisodeSerializer :
  StdSerializer<WPMEpisode>(WPMEpisode::class.java) {
  override fun serialize(
    value : WPMEpisode,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMEpisode.WPMEpisodeNumber  -> {
        WPMNumbers.writeNumber(gen, value.number)
      }

      is WPMEpisode.WPMEpisodes -> {
        WPMArrays.writeArray(gen, value.value)
      }

      is WPMEpisode.WPMEpisodeObject  -> {
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

        gen.writeEndObject()
      }
    }
  }
}