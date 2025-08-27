package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.module.SimpleDeserializers
import com.fasterxml.jackson.databind.module.SimpleModule
import com.io7m.dixmont.core.DmJsonRestrictedDeserializers
import one.irradia.mime.api.MIMEType
import java.net.URI
import java.time.OffsetDateTime

object WPMModule {

  fun createDeserializers() : SimpleDeserializers {
    return DmJsonRestrictedDeserializers.builder()
      .allowClass(Boolean::class.javaPrimitiveType)
      .allowClass(Double::class.javaPrimitiveType)
      .allowClass(Int::class.javaPrimitiveType)
      .allowClass(Integer::class.java)
      .allowClass(MIMEType::class.java)
      .allowClass(Number::class.java)
      .allowClass(WPMAvailability::class.java)
      .allowClass(WPMBelongsTo::class.java)
      .allowClass(WPMCatalog::class.java)
      .allowClass(WPMContributor::class.java)
      .allowClass(WPMEncrypted::class.java)
      .allowClass(WPMFeed::class.java)
      .allowClass(WPMIndirectAcquisitionTree::class.java)
      .allowClass(WPMLanguageMap::class.java)
      .allowClass(WPMLayout::class.java)
      .allowClass(WPMLink::class.java)
      .allowClass(WPMLinkDeserializer.WPMLinkRaw::class.java)
      .allowClass(WPMLinkProperties::class.java)
      .allowClass(WPMMetadata::class.java)
      .allowClass(WPMNavigation::class.java)
      .allowClass(WPMNavigationLink::class.java)
      .allowClass(WPMPublication::class.java)
      .allowClass(WPMReadingProgression::class.java)
      .allowClass(WPMSubject::class.java)
      .allowClass(OffsetDateTime::class.java)
      .allowClass(String::class.java)
      .allowClass(URI::class.java)
      .allowClassName("java.util.List<java.lang.String>")
      .allowClassName("java.util.List<java.net.URI>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMCatalog>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMIndirectAcquisitionTree>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMLink>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMLinkDeserializer\$WPMLinkRaw>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMNavigationLink>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMPublication>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMSubject>")
      .allowClassName("java.util.Map<java.lang.String,java.lang.String>")
      .build()
  }

  fun create() : Module {
    val module = SimpleModule()
    module.setDeserializers(this.createDeserializers())

    module.addDeserializer(MIMEType::class.java, WPMMIMETypeDeserializer())
    module.addDeserializer(WPMLanguageMap::class.java, WPMLanguageMapDeserializer())
    module.addDeserializer(WPMLayout::class.java, WPMLayoutDeserializer())
    module.addDeserializer(WPMLink::class.java, WPMLinkDeserializer())
    module.addDeserializer(WPMReadingProgression::class.java, WPMReadingProgressionDeserializer())
    module.addDeserializer(OffsetDateTime::class.java, WPMOffsetDateTimeDeserializer())

    module.addSerializer(WPMLanguageMap::class.java, WPMLanguageMapSerializer())
    module.addSerializer(WPMLayout::class.java, WPMLayoutSerializer())
    module.addSerializer(WPMLink::class.java, WPMLinkSerializer())
    module.addSerializer(WPMReadingProgression::class.java, WPMReadingProgressionSerializer())
    module.addSerializer(OffsetDateTime::class.java, WPMOffsetDateTimeSerializer())
    return module
  }
}
