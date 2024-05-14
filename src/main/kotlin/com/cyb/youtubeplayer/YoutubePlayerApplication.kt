package com.cyb.youtubeplayer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YoutubePlayerApplication

fun main(args: Array<String>) {
    runApplication<YoutubePlayerApplication>(*args)
}
