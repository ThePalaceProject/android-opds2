package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

class WPMLayoutDeserializer :
  StdDeserializer<WPMLayout>(WPMLayout::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMLayout {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        this.parseText(parser, context, currentToken)
      }

      else                   -> {
        context.handleUnexpectedToken(
          WPMLayout::class.java,
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
  ) : WPMLayout {
    return when (parser.text) {
      "fixed"      -> WPMLayout.FIXED
      "reflowable" -> WPMLayout.REFLOWABLE
      "scrolled"   -> WPMLayout.SCROLLED
      else         -> {
        context.handleUnexpectedToken(
          WPMLayout::class.java,
          currentToken,
          parser,
          "Unrecognized layout value: ${parser.text}"
        )
        TODO("Unreachable code.")
      }
    }
  }
}