package com.cyb.youtubeplayer.contoller;

import com.cyb.youtubeplayer.contoller.dto.SearchDto
import com.cyb.youtubeplayer.model.SearchResultVO
import com.cyb.youtubeplayer.service.YoutubeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class YoutubeController(private val youtubeService: YoutubeService) {

    @PostMapping("/youtube/search")
    fun youtubeSearch(@RequestBody searchDto: SearchDto): ResponseEntity<ArrayList<SearchResultVO>> {
        return ResponseEntity.ok(youtubeService.youtubeSearch(searchDto))
    }


}
