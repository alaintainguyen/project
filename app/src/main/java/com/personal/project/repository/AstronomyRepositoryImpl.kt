package com.personal.project.repository

import com.personal.project.database.AstronomyDAO
import com.personal.project.model.Astronomy
import com.personal.project.network.AstronomyService

class AstronomyRepositoryImpl(astronomyDAO: AstronomyDAO, private val service: AstronomyService): AstronomyRepository {

    override suspend fun getNasaApi(): Astronomy = service.getNasaApi()

}
