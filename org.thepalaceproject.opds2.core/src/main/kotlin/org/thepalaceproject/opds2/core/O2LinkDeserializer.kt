package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.node.BooleanNode
import com.fasterxml.jackson.databind.node.NullNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import one.irradia.mime.api.MIMEType
import one.irradia.mime.vanilla.MIMEParser
import java.net.URI

class O2LinkDeserializer : StdDeserializer<O2Link>(O2Link::class.java) {
  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : O2Link {
    return when (val obj = context.readTree(parser)) {
      is ObjectNode -> {
        when (val templatedNode = obj.get("templated")) {
          is NullNode, null -> {
            this.parseBasic(context, obj)
          }

          is BooleanNode    -> {
            if (templatedNode.booleanValue()) {
              this.parseTemplated(context, obj)
            } else {
              this.parseBasic(context, obj)
            }
          }

          else              -> {
            TODO()
          }
        }
      }

      else          -> {
        TODO()
      }
    }
  }

  private fun parseTemplated(
    context : DeserializationContext,
    obj : ObjectNode
  ) : O2LinkTemplated {
    return O2LinkTemplated(
      href = obj.get("href").textValue(),
      type = this.parseType(context, obj.get("type"))
    )
  }

  private fun parseBasic(
    context : DeserializationContext,
    obj : ObjectNode
  ) : O2LinkBasic {
    return O2LinkBasic(
      href = URI.create(obj.get("href").textValue()),
      type = this.parseType(context, obj.get("type"))
    )
  }

  private fun parseType(
    context : DeserializationContext,
    node : JsonNode?
  ) : MIMEType? {
    return when (node) {
      null        -> null
      is TextNode -> MIMEParser.create(node.textValue()).parseOrException()
      else        -> {
        context.handleUnexpectedToken(
          O2Link::class.java,
          context.parser
        )
        TODO()
      }
    }
  }
}