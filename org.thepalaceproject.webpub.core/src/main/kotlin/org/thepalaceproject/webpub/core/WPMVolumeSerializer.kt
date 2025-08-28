package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMVolumeSerializer :
  StdSerializer<WPMVolume>(WPMVolume::class.java) {
  override fun serialize(
    value : WPMVolume,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMVolume.WPMVolumeNumber  -> {
        WPMNumbers.writeNumber(gen, value.number)
      }

      is WPMVolume.WPMVolumes -> {
        WPMArrays.writeArray(gen, value.volumes)
      }

      is WPMVolume.WPMVolumeObject  -> {
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

        gen.writeFieldName("chapter")
        gen.writeObject(value.chapter)

        gen.writeFieldName("issue")
        gen.writeObject(value.issue)

        gen.writeFieldName("storyArc")
        gen.writeObject(value.storyArc)

        gen.writeEndObject()
      }
    }
  }
}