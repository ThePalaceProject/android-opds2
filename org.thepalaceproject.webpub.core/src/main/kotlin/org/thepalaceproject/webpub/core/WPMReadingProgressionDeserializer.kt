package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

class WPMReadingProgressionDeserializer :
  StdDeserializer<WPMReadingProgression>(WPMReadingProgression::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMReadingProgression {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        this.parseText(parser, context, currentToken)
      }

      else                   -> {
        context.handleUnexpectedToken(
          WPMReadingProgression::class.java,
          currentToken,
          parser,
          "Expected a string."
        )
        TODO("Unreachable code.")
      }
    }
  }

  private fun parseText(
    parser : JsonParser,
    context : DeserializationContext,
    currentToken : JsonToken
  ) : WPMReadingProgression {
    return when (parser.text) {
      "ltr"      -> WPMReadingProgression.LTR
      "rtl" -> WPMReadingProgression.RTL
      else         -> {
        context.handleUnexpectedToken(
          WPMReadingProgression::class.java,
          currentToken,
          parser,
          "Unrecognized reading progression value: ${parser.text}"
        )
        TODO("Unreachable code.")
      }
    }
  }
}