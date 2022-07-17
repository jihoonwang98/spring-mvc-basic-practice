package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class RequestHeaderController(
    private val log: Logger = LoggerFactory.getLogger(RequestHeaderController::class.java),
) {

    @RequestMapping("/headers")
    fun headers(
        request: HttpServletRequest,
        response: HttpServletResponse,
        httpMethod: HttpMethod,
        locale: Locale,
        @RequestHeader headerMap: MultiValueMap<String, String>,
        @RequestHeader("host") host: String,
        @CookieValue("myCookie", required = false) cookie: String?,
    ): String {
        log.info("request={}", request)
        log.info("response={}", response)
        log.info("httpMethod={}", httpMethod)
        log.info("locale={}", locale)
        log.info("headerMap={}", headerMap)
        log.info("host={}", host)
        log.info("myCookie={}", cookie)


        return "ok"
    }
}
