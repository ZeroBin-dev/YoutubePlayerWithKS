package com.cyb.youtubeplayer.model

import lombok.Getter
import lombok.Setter

@Getter
@Setter
class SearchResultVO {
    var title: String = ""
    var thumbnail: String = ""
    var publishTime: String = ""
    var videoUrl: String = ""
}