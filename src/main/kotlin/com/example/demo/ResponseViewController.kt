package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class ResponseViewController(
    private val log: Logger = LoggerFactory.getLogger(ResponseViewController::class.java),
) {

    @GetMapping("/response-view-v1")
    fun responseViewV1(): ModelAndView {
        return ModelAndView("response/hello").addObject("data", "hello, world!")
    }

    @GetMapping("/response-view-v2")
    fun responseViewV2(model: Model): String {
        model["data"] = "hello, world!"
        return "response/hello"
    }

    @GetMapping("/response/hello")
    fun responseViewV3(model: Model) {
        model["data"] = "hello, world"
    }
}
