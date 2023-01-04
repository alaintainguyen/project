package com.personal.projectapplication.model

import com.google.gson.annotations.SerializedName

data class Astronomy(
    @SerializedName("title")
    var title: String = "",

    @SerializedName("url")
    var url: String = "",

    @SerializedName("hdurl")
    var hdUrl: String = "",

    @SerializedName("explanation")
    var explanation: String = "",

    @SerializedName("date")
    var date: String = "",

    @SerializedName("media_type")
    var mediaType: String = ""

)
