package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMSeasonSerializer :
  StdSerializer<WPMSeason>(WPMSeason::class.java) {
  override fun serialize(
    value : WPMSeason,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMSeason.WPMSeasonNumber  -> {
        WPMNumbers.writeNumber(gen, value.number)
      }

      is WPMSeason.WPMSeasons -> {
        WPMArrays.writeArray(gen, value.seasons)
      }

      is WPMSeason.WPMSeasonObject  -> {
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

        gen.writeFieldName("episode")
        gen.writeObject(value.episode)

        gen.writeEndObject()
      }
    }
  }
}