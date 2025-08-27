package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.OffsetDateTime

class WPMSubjectOrStringDeserializer :
  StdDeserializer<WPMSubjectOrString>(WPMSubjectOrString::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMSubjectOrString {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        WPMSubjectOrString.WPMSubjectString(parser.text)
      }

      JsonToken.START_OBJECT -> {
        context.readValue(parser, WPMSubject::class.java)
      }

      else                   -> {
        context.handleUnexpectedToken(
          OffsetDateTime::class.java,
          currentToken,
          parser,
          "Expected an object or a string (Received ${currentToken})."
        )
        TODO("Unreachable code.")
      }
    }
  }
}