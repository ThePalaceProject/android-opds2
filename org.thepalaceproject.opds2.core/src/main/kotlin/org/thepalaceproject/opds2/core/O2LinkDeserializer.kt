package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import one.irradia.mime.api.MIMEType
import java.net.URI
import java.net.URISyntaxException


class O2LinkDeserializer : StdDeserializer<O2Link>(O2Link::class.java) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class O2LinkRaw(
    @JsonProperty(value = "href")
    val href : String,
    @JsonProperty(value = "type")
    val type : MIMEType? = null,
    @JsonProperty(value = "templated")
    val templated : Boolean = false,
    @JsonProperty(value = "rel")
    val relation : String = "",
    @JsonProperty(value = "title")
    val title : String = "",
    @JsonProperty(value = "properties")
    val properties: O2LinkProperties?
  )

  override fun deserialize(
    parser : JsonParser,
    context : DeserializationContext
  ) : O2Link {
    val raw = context.readValue(parser, O2LinkRaw::class.java)
    return if (raw.templated) {
      O2LinkTemplated(
        href = raw.href,
        type = raw.type,
        relation = raw.relation,
        properties = raw.properties
      )
    } else {
      val input = raw.href

      try {
        return O2LinkBasic(
          href = URI(raw.href),
          type = raw.type,
          relation = raw.relation,
          properties = raw.properties
        )
      } catch (_ : URISyntaxException) {
        val colon : Int =
          input.indexOf(':')
        if (colon <= 0) {
          throw URISyntaxException(input, "Missing scheme")
        }

        val scheme =
          input.take(colon)
        val sspAndFrag =
          input.substring(colon + 1)
        val hash =
          sspAndFrag.indexOf('#')

        val schemeSpecific =
          if (hash >= 0) {
            sspAndFrag.take(hash)
          } else {
            sspAndFrag
          }

        val frag =
          if (hash >= 0) {
            sspAndFrag.substring(hash + 1)
          } else {
            null
          }

        return O2LinkBasic(
          href = URI(scheme, schemeSpecific, frag),
          type = raw.type,
          relation = raw.relation,
          properties = raw.properties
        )
      }
    }
  }
}
