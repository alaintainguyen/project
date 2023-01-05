package com.personal.project.network

import com.personal.project.model.Astronomy
import retrofit2.http.GET

interface AstronomyService {
    @GET("apod?api_key=QBWd8omyNFXPFDpOoZxL0CuXWO8eMjzzKsmgM7Lx")
    suspend fun getNasaApi(): Astronomy
}
