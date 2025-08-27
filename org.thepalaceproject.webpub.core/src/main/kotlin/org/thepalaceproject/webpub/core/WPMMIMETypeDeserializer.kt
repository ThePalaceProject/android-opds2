package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import one.irradia.mime.api.MIMEType
import one.irradia.mime.vanilla.MIMEParser

class WPMMIMETypeDeserializer :
  StdDeserializer<MIMEType>(MIMEType::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : MIMEType {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        MIMEParser.create(parser.text).parseOrException()
      }

      else                   -> {
        context.handleUnexpectedToken(
          MIMEType::class.java,
          currentToken,
          parser,
          "Expected a string."
        )
        TODO("Unreachable code.")
      }
    }
  }
}