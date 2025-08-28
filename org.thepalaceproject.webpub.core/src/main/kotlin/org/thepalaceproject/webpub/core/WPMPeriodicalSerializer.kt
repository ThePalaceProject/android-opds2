package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMPeriodicalSerializer :
  StdSerializer<WPMPeriodical>(WPMPeriodical::class.java) {
  override fun serialize(
    value : WPMPeriodical,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMPeriodical.WPMPeriodicalString  -> {
        gen.writeString(value.value)
      }

      is WPMPeriodical.WPMPeriodicals -> {
        WPMArrays.writeArray(gen, value.value)
      }

      is WPMPeriodical.WPMPeriodicalObject  -> {
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

        gen.writeFieldName("issue")
        gen.writeObject(value.issue)

        gen.writeFieldName("volume")
        gen.writeObject(value.volume)

        gen.writeEndObject()
      }
    }
  }
}