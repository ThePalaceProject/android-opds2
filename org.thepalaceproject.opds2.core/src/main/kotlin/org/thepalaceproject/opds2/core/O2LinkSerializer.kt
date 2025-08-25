package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class O2LinkSerializer : StdSerializer<O2Link>(O2Link::class.java) {
  override fun serialize(
    value : O2Link,
    generator : JsonGenerator,
    serializers : SerializerProvider
  ) {
    TODO("Not yet implemented")
  }
}