package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RequestParamController(
    private val log: Logger = LoggerFactory.getLogger(RequestParamController::class.java),
) {

    @RequestMapping("/request-param")
    fun requestParam(
        @RequestParam("username") username: String,
        @RequestParam("age") age: Int,
    ): String {
        log.info("username={}, age={}", username, age)
        return "ok"
    }

    @RequestMapping("/request-param-v2")
    fun requestParamV2(dto: Dto1): String {
        log.info("dto={}", dto)
        return "ok"
    }

    data class Dto1(
        val username: String,
        val age: Int,
    )


}
