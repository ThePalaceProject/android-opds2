package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class WPMArticleSerializer :
  StdSerializer<WPMArticle>(WPMArticle::class.java) {
  override fun serialize(
    value : WPMArticle,
    gen : JsonGenerator,
    provider : SerializerProvider
  ) {
    when (value) {
      is WPMArticle.WPMArticleString  -> {
        gen.writeString(value.value)
      }

      is WPMArticle.WPMArticles -> {
        WPMArrays.writeArray(gen, value.value)
      }

      is WPMArticle.WPMArticleObject  -> {
        gen.writeStartObject()

        gen.writeFieldName("name")
        gen.writeObject(value.name)

        gen.writeFieldName("identifier")
        gen.writeObject(value.identifier)

        WPMArrays.writeArrayField(gen, "altIdentifier", value.altIdentifier)

        gen.writeFieldName("sortAs")
        gen.writeObject(value.sortAs)

        WPMArrays.writeArrayField(gen, "author", value.author)
        WPMArrays.writeArrayField(gen, "translator", value.translator)
        WPMArrays.writeArrayField(gen, "editor", value.editor)
        WPMArrays.writeArrayField(gen, "artist", value.artist)
        WPMArrays.writeArrayField(gen, "illustrator", value.illustrator)
        WPMArrays.writeArrayField(gen, "contributor", value.contributor)

        gen.writeFieldName("description")
        gen.writeObject(value.description)

        gen.writeFieldName("numberOfPages")
        gen.writeObject(value.numberOfPages)

        gen.writeFieldName("position")
        gen.writeObject(value.position)

        WPMArrays.writeArrayField(gen, "links", value.links)

        gen.writeEndObject()
      }
    }
  }
}