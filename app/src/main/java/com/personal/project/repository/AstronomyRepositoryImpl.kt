package com.personal.project.repository

import com.personal.project.database.AstronomyDAO
import com.personal.project.model.Astronomy
import com.personal.project.network.AstronomyService

class AstronomyRepositoryImpl(astronomyDAO: AstronomyDAO): AstronomyRepository {

    override suspend fun getNasaApi(service: AstronomyService): Astronomy = service.getNasaApi()

}
