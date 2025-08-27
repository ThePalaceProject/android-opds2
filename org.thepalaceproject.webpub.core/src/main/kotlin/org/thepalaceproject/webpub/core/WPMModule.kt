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
      .allowClass(OffsetDateTime::class.java)
      .allowClass(String::class.java)
      .allowClass(URI::class.java)
      .allowClass(WPMAccessibility.AccessMode::class.java)
      .allowClass(WPMAccessibility.AccessModeSufficient::class.java)
      .allowClass(WPMAccessibility.Certification::class.java)
      .allowClass(WPMAccessibility.Exemption::class.java)
      .allowClass(WPMAccessibility.Feature::class.java)
      .allowClass(WPMAccessibility.Hazard::class.java)
      .allowClass(WPMAccessibility::class.java)
      .allowClass(WPMAvailability::class.java)
      .allowClass(WPMBelongsTo::class.java)
      .allowClass(WPMCatalog::class.java)
      .allowClass(WPMContributor::class.java)
      .allowClass(WPMContributorOrString::class.java)
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
      .allowClass(WPMSubjectOrString::class.java)
      .allowClassName("java.util.List<java.lang.String>")
      .allowClassName("java.util.List<java.net.URI>")
      .allowClassName("java.util.List<java.util.List<org.thepalaceproject.webpub.core.WPMAccessibility\$AccessModeSufficient>>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMAccessibility\$AccessMode>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMAccessibility\$AccessModeSufficient>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMAccessibility\$Feature>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMAccessibility\$Hazard>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMCatalog>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMContributorOrString>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMIndirectAcquisitionTree>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMLink>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMLinkDeserializer\$WPMLinkRaw>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMNavigationLink>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMPublication>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMSubject>")
      .allowClassName("java.util.List<org.thepalaceproject.webpub.core.WPMSubjectOrString>")
      .allowClassName("java.util.Map<java.lang.String,java.lang.String>")
      .allowClassName("java.util.Set<java.lang.String>")
      .build()
  }

  fun create() : Module {
    val module = SimpleModule()
    module.setDeserializers(this.createDeserializers())

    module.addDeserializer(MIMEType::class.java, WPMMIMETypeDeserializer())
    module.addDeserializer(WPMLanguageMap::class.java, WPMLanguageMapDeserializer())
    module.addDeserializer(WPMLink::class.java, WPMLinkDeserializer())
    module.addDeserializer(OffsetDateTime::class.java, WPMOffsetDateTimeDeserializer())
    module.addDeserializer(WPMContributorOrString::class.java, WPMContributorOrStringDeserializer())
    module.addDeserializer(WPMSubjectOrString::class.java, WPMSubjectOrStringDeserializer())

    module.addSerializer(WPMLanguageMap::class.java, WPMLanguageMapSerializer())
    module.addSerializer(WPMLink::class.java, WPMLinkSerializer())
    module.addSerializer(OffsetDateTime::class.java, WPMOffsetDateTimeSerializer())
    module.addSerializer(WPMContributorOrString::class.java, WPMContributorOrStringSerializer())
    module.addSerializer(WPMSubjectOrString::class.java, WPMSubjectOrStringSerializer())
    return module
  }
}
