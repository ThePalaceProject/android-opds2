package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.StreamReadFeature
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule

object WPMMappers {

  fun createMapper() : JsonMapper {
    val mapper =
      JsonMapper.builder()
        .addModule(kotlinModule())
        .addModule(WPMModule.create())
        .enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        .build()

    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    return mapper
  }
}