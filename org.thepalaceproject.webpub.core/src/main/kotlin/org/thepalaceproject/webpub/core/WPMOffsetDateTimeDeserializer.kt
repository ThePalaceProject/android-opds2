package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeParseException

class WPMOffsetDateTimeDeserializer :
  StdDeserializer<OffsetDateTime>(OffsetDateTime::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : OffsetDateTime? {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {

        /*
         * Some old Feedbooks feeds have this instead of date values.
         */

        if (parser.text == "N/A") {
          return null
        }

        try {
          OffsetDateTime.parse(parser.text)
        } catch (_ : DateTimeParseException) {
          val date = LocalDate.parse(parser.text)
          OffsetDateTime.of(
            date,
            LocalTime.of(0, 0),
            ZoneOffset.UTC
          )
        }
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