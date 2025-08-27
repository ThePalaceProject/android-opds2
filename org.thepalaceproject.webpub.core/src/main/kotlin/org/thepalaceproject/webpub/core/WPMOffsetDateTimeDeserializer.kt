package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.OffsetDateTime

class WPMOffsetDateTimeDeserializer :
  StdDeserializer<OffsetDateTime>(OffsetDateTime::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : OffsetDateTime {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        OffsetDateTime.parse(parser.text)
      }

      else                   -> {
        context.handleUnexpectedToken(
          OffsetDateTime::class.java,
          currentToken,
          parser,
          "Expected a string."
        )
        TODO("Unreachable code.")
      }
    }
  }
}