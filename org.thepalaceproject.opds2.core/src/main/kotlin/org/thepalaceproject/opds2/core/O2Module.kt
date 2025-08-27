package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.module.SimpleDeserializers
import com.fasterxml.jackson.databind.module.SimpleModule
import com.io7m.dixmont.core.DmJsonRestrictedDeserializers
import one.irradia.mime.api.MIMEType
import java.net.URI
import java.time.OffsetDateTime

object O2Module {

  fun createDeserializers() : SimpleDeserializers {
    return DmJsonRestrictedDeserializers.builder()
      .allowClass(Boolean::class.javaPrimitiveType)
      .allowClass(Double::class.javaPrimitiveType)
      .allowClass(Int::class.javaPrimitiveType)
      .allowClass(Integer::class.java)
      .allowClass(MIMEType::class.java)
      .allowClass(Number::class.java)
      .allowClass(O2Availability::class.java)
      .allowClass(O2BelongsTo::class.java)
      .allowClass(O2Catalog::class.java)
      .allowClass(O2Contributor::class.java)
      .allowClass(O2Encrypted::class.java)
      .allowClass(O2Feed::class.java)
      .allowClass(O2IndirectAcquisitionTree::class.java)
      .allowClass(O2LanguageMap::class.java)
      .allowClass(O2Layout::class.java)
      .allowClass(O2Link::class.java)
      .allowClass(O2LinkDeserializer.O2LinkRaw::class.java)
      .allowClass(O2LinkProperties::class.java)
      .allowClass(O2Metadata::class.java)
      .allowClass(O2Navigation::class.java)
      .allowClass(O2NavigationLink::class.java)
      .allowClass(O2Publication::class.java)
      .allowClass(O2ReadingProgression::class.java)
      .allowClass(O2Subject::class.java)
      .allowClass(OffsetDateTime::class.java)
      .allowClass(String::class.java)
      .allowClass(URI::class.java)
      .allowClassName("java.util.List<java.lang.String>")
      .allowClassName("java.util.List<java.net.URI>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Catalog>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2IndirectAcquisitionTree>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Link>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2LinkDeserializer\$O2LinkRaw>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2NavigationLink>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Publication>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Subject>")
      .allowClassName("java.util.Map<java.lang.String,java.lang.String>")
      .build()
  }

  fun create() : Module {
    val module = SimpleModule()
    module.setDeserializers(this.createDeserializers())

    module.addDeserializer(MIMEType::class.java, O2MIMETypeDeserializer())
    module.addDeserializer(O2LanguageMap::class.java, O2LanguageMapDeserializer())
    module.addDeserializer(O2Layout::class.java, O2LayoutDeserializer())
    module.addDeserializer(O2Link::class.java, O2LinkDeserializer())
    module.addDeserializer(O2ReadingProgression::class.java, O2ReadingProgressionDeserializer())
    module.addDeserializer(OffsetDateTime::class.java, O2OffsetDateTimeDeserializer())

    module.addSerializer(O2LanguageMap::class.java, O2LanguageMapSerializer())
    module.addSerializer(O2Layout::class.java, O2LayoutSerializer())
    module.addSerializer(O2Link::class.java, O2LinkSerializer())
    module.addSerializer(O2ReadingProgression::class.java, O2ReadingProgressionSerializer())
    module.addSerializer(OffsetDateTime::class.java, O2OffsetDateTimeSerializer())
    return module
  }
}
