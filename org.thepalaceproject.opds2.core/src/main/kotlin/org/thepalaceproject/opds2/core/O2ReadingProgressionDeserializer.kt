package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

class O2ReadingProgressionDeserializer :
  StdDeserializer<O2ReadingProgression>(O2ReadingProgression::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : O2ReadingProgression {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        this.parseText(parser, context, currentToken)
      }

      else                   -> {
        context.handleUnexpectedToken(
          O2ReadingProgression::class.java,
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
  ) : O2ReadingProgression {
    return when (parser.text) {
      "ltr"      -> O2ReadingProgression.LTR
      "rtl" -> O2ReadingProgression.RTL
      else         -> {
        context.handleUnexpectedToken(
          O2ReadingProgression::class.java,
          currentToken,
          parser,
          "Unrecognized reading progression value: ${parser.text}"
        )
        TODO("Unreachable code.")
      }
    }
  }
}