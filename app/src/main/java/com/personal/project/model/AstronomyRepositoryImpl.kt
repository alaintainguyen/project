package com.personal.project.model

import com.personal.project.network.AstronomyService

class AstronomyRepositoryImpl(astronomyDAO: AstronomyDAO): AstronomyRepository {

    override suspend fun getNasaApi(service: AstronomyService): Astronomy = service.getNasaApi()

}
