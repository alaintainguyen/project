package com.personal.project.repository

import com.personal.project.model.Astronomy
import com.personal.project.network.AstronomyService

interface AstronomyRepository {
    suspend fun getNasaApi(): Astronomy
}
