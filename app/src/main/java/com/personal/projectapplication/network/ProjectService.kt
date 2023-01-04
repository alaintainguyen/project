package com.personal.projectapplication.network

import com.personal.projectapplication.model.Astronomy
import retrofit2.http.GET

interface ProjectService {
    @GET("apod?api_key=QBWd8omyNFXPFDpOoZxL0CuXWO8eMjzzKsmgM7Lx")
    suspend fun getNasaApi(): Astronomy
}
