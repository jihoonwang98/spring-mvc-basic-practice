package com.example.demo

import com.example.demo.RequestBodyJsonController.HelloData
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ModelAttributeController(
    private val log: Logger = LoggerFactory.getLogger(ModelAttributeController::class.java),
) {

    @RequestMapping("/model-attribute-v1")
    fun modelAttributeV1(@ModelAttribute helloData: HelloData, model: Model): String {
        log.info("username={}, age={}", helloData.username, helloData.age)

        val attribute = model.getAttribute("helloData")
        log.info("attribute={}", attribute)

        return "ok"
    }

    @RequestMapping("/model-attribute-v2")
    fun modelAttributeV2(helloData: HelloData, model: Model): String {
        log.info("username={}, age={}", helloData.username, helloData.age)

        val attribute = model.getAttribute("helloData")
        log.info("attribute={}", attribute)

        return "ok"
    }
}
