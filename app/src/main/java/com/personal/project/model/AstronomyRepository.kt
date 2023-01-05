package com.personal.project.model

import com.personal.project.network.AstronomyService

interface AstronomyRepository {
    suspend fun getNasaApi(service: AstronomyService): Astronomy
}
