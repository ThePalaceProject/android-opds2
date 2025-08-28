package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.OffsetDateTime

class WPMEpisodeDeserializer :
  StdDeserializer<WPMEpisode>(WPMEpisode::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMEpisode {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_NUMBER_INT   -> {
        WPMEpisode.WPMEpisodeNumber(parser.bigIntegerValue)
      }

      JsonToken.VALUE_NUMBER_FLOAT -> {
        WPMEpisode.WPMEpisodeNumber(parser.doubleValue)
      }

      JsonToken.START_ARRAY        -> {
        return this.consumeArray(parser, context)
      }

      JsonToken.START_OBJECT       -> {
        context.readValue(parser, WPMEpisode.WPMEpisodeObject::class.java)
      }

      else                         -> {
        this.errorUnexpectedToken(context, currentToken, parser)
      }
    }
  }

  private fun errorUnexpectedToken(
    context : DeserializationContext,
    currentToken : JsonToken?,
    parser : JsonParser
  ) : Nothing {
    context.handleUnexpectedToken(
      OffsetDateTime::class.java,
      currentToken,
      parser,
      "Expected a string, an object, or an array (Received ${currentToken})."
    )
    throw IllegalStateException("Unreachable code")
  }

  private fun consumeArray(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMEpisode.WPMEpisodes {
    val results =
      mutableListOf<WPMEpisode>()

    while (true) {
      when (val currentToken = parser.nextToken()) {
        JsonToken.START_OBJECT       -> {
          results.add(
            context.readValue(
              parser,
              WPMEpisode.WPMEpisodeObject::class.java
            )
          )
        }

        JsonToken.VALUE_NUMBER_INT   -> {
          WPMEpisode.WPMEpisodeNumber(parser.bigIntegerValue)
        }

        JsonToken.VALUE_NUMBER_FLOAT -> {
          WPMEpisode.WPMEpisodeNumber(parser.doubleValue)
        }

        JsonToken.START_ARRAY        -> {
          results.add(this.consumeArray(parser, context))
        }

        JsonToken.END_ARRAY          -> {
          return WPMEpisode.WPMEpisodes(results.toList())
        }

        else                         -> {
          this.errorUnexpectedToken(context, currentToken, parser)
        }
      }
    }
  }
}