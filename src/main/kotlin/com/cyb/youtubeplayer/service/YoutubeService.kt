package com.cyb.youtubeplayer.service;

import com.cyb.youtubeplayer.common.util.DateUtil
import com.cyb.youtubeplayer.contoller.dto.SearchDto
import com.cyb.youtubeplayer.model.SearchResultVO
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class YoutubeService(
    @Value("\${youtube.api-key}")
    private val apiKey: String
) {

    /**
     * 유튜브 동영상 검색
     */
    fun youtubeSearch(searchDto: SearchDto): ArrayList<SearchResultVO> {
        var result = ""

        val jsonFactory = JacksonFactory()

        val youtube = YouTube.Builder(
            NetHttpTransport(),
            jsonFactory,
            HttpRequestInitializer { }
        ).build()

        val search = youtube.search().list(Collections.singletonList("id,snippet"))

        search.setKey(apiKey)

        search.setQ(searchDto.keyword)

        val searchResponse = search.execute()

        val searchResultList = searchResponse.items

        var searchResultVO: ArrayList<SearchResultVO> = ArrayList()

        if(searchResultList != null && searchResultList.size > 0){
            for(i in searchResultList.indices){
                val searchResult = searchResultList[i]
                var title = searchResult.snippet.title
                var thumbnails = searchResult.snippet.thumbnails.medium.url
                var publishTime = searchResult.snippet.publishedAt
                var videoId = searchResult.id.videoId

                var searchData : SearchResultVO = SearchResultVO()
                searchData.title = title
                searchData.thumbnail = thumbnails
                searchData.publishTime = DateUtil.formatDateTime(publishTime)
                searchData.videoUrl = "https://www.youtube.com/watch?v=" + videoId

                searchResultVO.add(searchData)
            }
        }

        return searchResultVO
    }
}
