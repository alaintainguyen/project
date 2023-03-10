package com.personal.project.domain.repository

import com.personal.project.BuildConfig
import com.personal.project.domain.database.AstronomyDAO
import com.personal.project.domain.database.AstronomyDatabase
import com.personal.project.domain.model.AstronomyBean
import com.personal.project.network.AstronomyService
import io.reactivex.Observable

class AstronomyRepositoryImpl(
    private var astronomyDAO: AstronomyDAO,
    astronomyDatabase: AstronomyDatabase,
    private val service: AstronomyService,
): AstronomyRepository {

    private val apiKey = BuildConfig.ASTRONOMY_API_KEY

    init {
        astronomyDAO = astronomyDatabase.astronomyDAO()
    }

    override suspend fun getAstronomyList(startDate: String, endDate: String): List<AstronomyBean> {
        return service.getAstronomyList(apiKey, startDate, endDate)
    }

    override fun setDatabase(astronomyList: List<AstronomyBean>) {
        astronomyDAO.deleteAll()
        astronomyDAO.insertAll(astronomyList)
    }
}
