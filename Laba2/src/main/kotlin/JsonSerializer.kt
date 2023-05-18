package com.example.json

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class JsonSerializer {
    val mapper = jacksonObjectMapper()

    inline fun <reified T>deserialize(json: String): T = mapper.readValue(json)

    fun <T>serialize(value: T): String = mapper.writeValueAsString(value)
}