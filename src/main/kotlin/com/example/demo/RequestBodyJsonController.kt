package com.example.demo

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class RequestBodyJsonController(
    private val log: Logger = LoggerFactory.getLogger(RequestBodyJsonController::class.java),
    private val objectMapper: ObjectMapper = ObjectMapper(),
) {


    @PostMapping("/request-body-json-v1")
    fun requestBodyJsonV1(request: HttpServletRequest, response: HttpServletResponse) {
        val messageBody = StreamUtils.copyToString(request.inputStream, StandardCharsets.UTF_8)
        log.info("messageBody={}", messageBody)

        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
        log.info("helloData.username={}, helloData.age={}", helloData.username, helloData.age)

        response.writer.write("ok")
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    fun requestBodyJsonV2(@RequestBody messageBody: String): String {
        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
        log.info("username={}, age={}", helloData.username, helloData.age)
        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    fun requestBodyJsonV3(@RequestBody messageBody: HelloData, model: Model): String {
        log.info("username={}, age={}", messageBody.username, messageBody.age)
        return "ok"
    }

    data class HelloData(
        val username: String,
        val age: Int,
    ){

}
}
