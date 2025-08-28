package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMSeriesSerializer :
  StdSerializer<WPMSeries>(WPMSeries::class.java) {
  override fun serialize(
    value : WPMSeries,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMSeries.WPMSeriesString  -> {
        gen.writeString(value.value)
      }

      is WPMSeries.WPMSeriesSet -> {
        WPMArrays.writeArray(gen, value.value)
      }

      is WPMSeries.WPMSeriesObject  -> {
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

        gen.writeFieldName("season")
        gen.writeObject(value.season)

        gen.writeFieldName("storyArc")
        gen.writeObject(value.storyArc)

        gen.writeFieldName("volume")
        gen.writeObject(value.volume)

        gen.writeEndObject()
      }
    }
  }
}