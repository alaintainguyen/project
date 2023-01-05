package com.personal.project.network

import com.personal.project.domain.model.AstronomyBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AstronomyService {

    @GET("apod")
    suspend fun getAstronomyList(
        @Query("api_key") api_key: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): List<AstronomyBean>
}
