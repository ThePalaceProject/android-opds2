package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.module.SimpleModule
import java.time.OffsetDateTime

object O2Module {
  fun create() : Module {
    val module = SimpleModule()
    module.addDeserializer(
      O2Link::class.java,
      O2LinkDeserializer()
    )
    module.addDeserializer(
      O2Title::class.java,
      O2TitleDeserializer()
    )
    module.addSerializer(
      O2Link::class.java,
      O2LinkSerializer()
    )
    module.addSerializer(
      O2Title::class.java,
      O2TitleSerializer()
    )
    module.addSerializer(
      OffsetDateTime::class.java,
      O2OffsetDateTimeSerializer()
    )
    module.addDeserializer(
      OffsetDateTime::class.java,
      O2OffsetDateTimeDeserializer()
    )
    return module
  }
}
