package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneOffset.UTC
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.DateTimeParseException
import java.time.format.SignStyle
import java.time.temporal.ChronoField

class WPMOffsetDateTimeDeserializer :
  StdDeserializer<OffsetDateTime>(OffsetDateTime::class.java) {

  private val laxDateFormat =
    DateTimeFormatterBuilder()
      .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
      .appendLiteral('-')
      .appendValue(ChronoField.MONTH_OF_YEAR, 2)
      .appendLiteral('-')
      .appendValue(ChronoField.DAY_OF_MONTH, 2)
      .toFormatter()

  private val laxDateTimeFormat =
    DateTimeFormatterBuilder()
      .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
      .appendLiteral('-')
      .appendValue(ChronoField.MONTH_OF_YEAR, 2)
      .appendLiteral('-')
      .appendValue(ChronoField.DAY_OF_MONTH, 2)
      .appendLiteral(' ')
      .appendValue(ChronoField.HOUR_OF_DAY, 2)
      .appendLiteral(':')
      .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
      .appendLiteral(':')
      .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
      .toFormatter()

  /**
   * Real feeds and manifests contain all kinds of interesting ideas of what
   * constitutes a date.
   */

  private val dateParsers : List<(String) -> OffsetDateTime> =
    listOf(
      this::parseFullIsoDateTime,
      this::parseLaxDateTime,
      this::parseLaxDate,
      this::parseLaxYear
    )

  private fun parseFullIsoDateTime(
    text: String
  ): OffsetDateTime {
    return OffsetDateTime.parse(text, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
  }

  private fun parseLaxDate(
    text: String
  ): OffsetDateTime {
    val date =
      LocalDate.parse(text, this.laxDateFormat)
    val dateTime =
      LocalDateTime.of(date, LocalTime.of(0, 0))
    return OffsetDateTime.of(dateTime, UTC)
  }

  private fun parseLaxDateTime(
    text: String
  ): OffsetDateTime {
    val time = LocalDateTime.parse(text, this.laxDateTimeFormat)
    return OffsetDateTime.of(time, UTC)
  }

  private fun parseLaxYear(
    text: String
  ): OffsetDateTime {
    val year = Integer.parseInt(text)

    return OffsetDateTime.of(
      year,
      1,1,0,0,0,0,UTC
    )
  }

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

        val exception =
          DateTimeParseException(
            "Unparseable date (${parser.text}).",
            parser.text,
            0
          )

        for (dateParser in this.dateParsers) {
          try {
            return dateParser.invoke(parser.text)
          } catch (e : Exception) {
            exception.addSuppressed(e)
          }
        }

        throw exception
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