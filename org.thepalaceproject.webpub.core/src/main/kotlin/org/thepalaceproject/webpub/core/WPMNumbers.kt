package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonGenerator
import java.math.BigInteger

object WPMNumbers {

  fun writeNumber(
    generator : JsonGenerator,
    value : Number
  ) {
    if (isIntegral(value)) {
      generator.writeNumber(value.toLong())
    } else {
      generator.writeNumber(value.toDouble())
    }
  }

  fun writeNumberArray(
    generator : JsonGenerator,
    value : List<Number>
  ) {
    if (isIntegral(value[0])) {
      val array = LongArray(value.size)
      for (i in 0 until value.size) {
        array[i] = value[i].toLong()
      }
      generator.writeArray(array, 0, array.size)
    } else {
      val array = DoubleArray(value.size)
      for (i in 0 until value.size) {
        array[i] = value[i].toDouble()
      }
      generator.writeArray(array, 0, array.size)
    }
  }

  private fun isIntegral(
    value : Number
  ) : Boolean {
    return when (value) {
      is BigInteger -> true
      is Byte       -> true
      is Int        -> true
      is Short      -> true
      is Long       -> true
      else          -> false
    }
  }
}