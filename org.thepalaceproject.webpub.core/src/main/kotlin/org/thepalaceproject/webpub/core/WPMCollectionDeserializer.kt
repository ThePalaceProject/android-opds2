package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.OffsetDateTime

class WPMCollectionDeserializer :
  StdDeserializer<WPMCollection>(WPMCollection::class.java) {

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : WPMCollection {
    return when (val currentToken = parser.currentToken()) {
      JsonToken.VALUE_STRING -> {
        WPMCollection.WPMCollectionString(parser.text)
      }

      JsonToken.START_ARRAY  -> {
        return this.consumeArray(parser, context)
      }

      JsonToken.START_OBJECT        -> {
        context.readValue(parser, WPMCollection.WPMCollectionObject::class.java)
      }

      else                   -> {
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
  ) : WPMCollection.WPMCollections {
    val results =
      mutableListOf<WPMCollection>()

    while (true) {
      when (val currentToken = parser.nextToken()) {
        JsonToken.START_OBJECT -> {
          results.add(
            context.readValue(
              parser,
              WPMCollection.WPMCollectionObject::class.java
            )
          )
        }

        JsonToken.VALUE_STRING -> {
          WPMCollection.WPMCollectionString(parser.text)
        }

        JsonToken.START_ARRAY  -> {
          results.add(this.consumeArray(parser, context))
        }

        JsonToken.END_ARRAY    -> {
          return WPMCollection.WPMCollections(results.toList())
        }

        else                   -> {
          this.errorUnexpectedToken(context, currentToken, parser)
        }
      }
    }
  }
}