package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMCollectionSerializer :
  StdSerializer<WPMCollection>(WPMCollection::class.java) {
  override fun serialize(
    value : WPMCollection,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMCollection.WPMCollectionString  -> {
        gen.writeString(value.value)
      }

      is WPMCollection.WPMCollections -> {
        WPMArrays.writeArray(gen, value.value)
      }

      is WPMCollection.WPMCollectionObject  -> {
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