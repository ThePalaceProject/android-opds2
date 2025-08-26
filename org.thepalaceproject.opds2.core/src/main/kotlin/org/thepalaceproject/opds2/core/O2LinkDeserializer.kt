package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import one.irradia.mime.api.MIMEType
import java.net.URI

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
    val title : String = ""
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
        relation = raw.relation
      )
    } else {
      O2LinkBasic(
        href = URI.create(raw.href),
        type = raw.type,
        relation = raw.relation
      )
    }
  }
}
