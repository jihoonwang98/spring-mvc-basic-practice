package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class MappingController(
    private val log: Logger = LoggerFactory.getLogger(MappingController::class.java),
) {

    @RequestMapping("/hello-basic")
    fun helloBasic(): String {
        log.info("helloBasic")
        return "ok"
    }

    @RequestMapping("/mapping-get-v1", method = [RequestMethod.GET])
    fun mappingGetV1(): String {
        log.info("mappingGetV1")
        return "ok"
    }

    @GetMapping("/mapping-get-v2")
    fun mappingGetV2(): String {
        log.info("mappingGetV2")
        return "ok"
    }

    @GetMapping("/mapping/{userId}")
    fun mappingPath(@PathVariable("userId") id: Long): String {
        log.info("mappingPath userId={}", id)
        return "ok"
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    fun mappingPath2(@PathVariable userId: String, @PathVariable orderId: String): String {
        log.info("mappingPath userId={}, orderId={}", userId, orderId)
        return "ok"
    }

    @GetMapping("/mapping-header", headers = ["mojo=true"])
    fun mappingHeader(): String {
        log.info("mappingHeader")
        return "ok"
    }

    @PostMapping("/mapping-consume", consumes = ["application/json"])
    fun mappingConsumes(): String {
        log.info("mappingConsumes")
        return "ok"
    }

    @PostMapping("/mapping-produce", produces = ["text/html"])
    fun mappingProduces(): String {
        log.info("mappingProduces")
        return "<h1>ok</h1>"
    }
}
