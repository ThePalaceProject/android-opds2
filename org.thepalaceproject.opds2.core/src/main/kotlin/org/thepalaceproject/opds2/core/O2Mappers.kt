package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule

object O2Mappers {

  fun createMapper() : JsonMapper {
    val mapper =
      JsonMapper.builder()
        .addModule(kotlinModule())
        .addModule(O2Module.create())
        .build()

    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    return mapper
  }
}