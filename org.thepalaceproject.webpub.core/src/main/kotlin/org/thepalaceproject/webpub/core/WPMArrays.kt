package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator

object WPMArrays {

  fun <T> writeArrayField(
    generator : JsonGenerator,
    fieldName: String,
    array: List<T>
  ) {
    if (array.isEmpty()) {
      return
    }
    generator.writeFieldName(fieldName)
    writeArray(generator, array)
  }

  fun <T> writeArray(
    generator : JsonGenerator,
    array : List<T>
  ) {
    generator.writeStartArray()
    for (k in array) {
      generator.writeObject(k)
    }
    generator.writeEndArray()
  }
}