package com.personal.project.network

import com.personal.project.domain.model.AstronomyBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AstronomyService {
    @GET("apod?api_key=QBWd8omyNFXPFDpOoZxL0CuXWO8eMjzzKsmgM7Lx")
    suspend fun getNasaApi(): AstronomyBean

    @GET("apod?api_key=QBWd8omyNFXPFDpOoZxL0CuXWO8eMjzzKsmgM7Lx")
    suspend fun getAstronomyList(@Query("start_date") startDate: String, @Query("end_date") endDate: String): List<AstronomyBean>
}
