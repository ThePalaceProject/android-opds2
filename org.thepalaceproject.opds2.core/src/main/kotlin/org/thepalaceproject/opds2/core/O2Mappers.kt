package org.thepalaceproject.opds2.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule


object O2Mappers {

  fun createMapper() : JsonMapper {
    return JsonMapper.builder()
      .addModule(kotlinModule())
      .addModule(O2Module.create())
      .build()
  }
}