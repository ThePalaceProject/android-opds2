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
      .allowClass(MIMEType::class.java)
      .allowClass(O2Author::class.java)
      .allowClass(O2Availability::class.java)
      .allowClass(O2Catalog::class.java)
      .allowClass(O2Feed::class.java)
      .allowClass(O2IndirectAcquisitionTree::class.java)
      .allowClass(O2Link::class.java)
      .allowClass(O2LinkDeserializer.O2LinkRaw::class.java)
      .allowClass(O2LinkProperties::class.java)
      .allowClass(O2Metadata::class.java)
      .allowClass(O2Narrator::class.java)
      .allowClass(O2Navigation::class.java)
      .allowClass(O2NavigationLink::class.java)
      .allowClass(O2Publication::class.java)
      .allowClass(O2Subject::class.java)
      .allowClass(O2Title::class.java)
      .allowClass(OffsetDateTime::class.java)
      .allowClass(String::class.java)
      .allowClass(URI::class.java)
      .allowClassName("java.util.List<java.lang.String>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Catalog>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2IndirectAcquisitionTree>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Link>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2NavigationLink>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Publication>")
      .allowClassName("java.util.List<org.thepalaceproject.opds2.core.O2Subject>")
      .allowClassName("java.util.Map<java.lang.String,java.lang.String>")
      .build()
  }

  fun create() : Module {
    val module = SimpleModule()
    module.setDeserializers(this.createDeserializers())
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
    module.addDeserializer(
      MIMEType::class.java,
      O2MIMETypeDeserializer()
    )
    return module
  }
}
