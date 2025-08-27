package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

class O2LayoutDeserializer :
  StdDeserializer<O2Layout>(O2Layout::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : O2Layout {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        this.parseText(parser, context, currentToken)
      }

      else                   -> {
        context.handleUnexpectedToken(
          O2Layout::class.java,
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
  ) : O2Layout {
    return when (parser.text) {
      "fixed"      -> O2Layout.FIXED
      "reflowable" -> O2Layout.REFLOWABLE
      "scrolled"   -> O2Layout.SCROLLED
      else         -> {
        context.handleUnexpectedToken(
          O2Layout::class.java,
          currentToken,
          parser,
          "Unrecognized layout value: ${parser.text}"
        )
        TODO("Unreachable code.")
      }
    }
  }
}