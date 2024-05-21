package com.cyb.youtubeplayer.contoller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/", "/index", "")
    fun index(): String {
        return "index"
    }

}