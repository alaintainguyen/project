package com.personal.project.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "astronomy")
data class AstronomyBean(
    @SerializedName("title")
    var title: String = "",

    @SerializedName("url")
    var url: String = "",

    @SerializedName("hdurl")
    var hdUrl: String = "",

    @SerializedName("explanation")
    var explanation: String = "",

    @PrimaryKey
    @SerializedName("date")
    val date: String = "",

    @SerializedName("media_type")
    var mediaType: String = ""

)
