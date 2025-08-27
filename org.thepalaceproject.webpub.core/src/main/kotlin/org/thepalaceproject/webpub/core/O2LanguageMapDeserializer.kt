package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

class O2LanguageMapDeserializer : StdDeserializer<O2LanguageMap>(O2LanguageMap::class.java) {
  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : O2LanguageMap {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.START_OBJECT -> {
        TODO("Not yet implemented")
      }

      JsonToken.VALUE_STRING -> {
        O2LanguageMap.Scalar(value = parser.text)
      }

      else                   -> {
        context.handleUnexpectedToken(
          O2LanguageMap::class.java,
          currentToken,
          parser,
          "Expected a string or an object."
        )
        TODO("Unreachable code.")
      }
    }
  }
}