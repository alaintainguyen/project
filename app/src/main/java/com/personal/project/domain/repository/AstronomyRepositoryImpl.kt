package com.personal.project.domain.repository

import com.personal.project.BuildConfig
import com.personal.project.domain.database.AstronomyDAO
import com.personal.project.domain.database.AstronomyDatabase
import com.personal.project.domain.model.AstronomyBean
import com.personal.project.network.AstronomyService
import io.reactivex.Observable

class AstronomyRepositoryImpl(
    private val astronomyDAO: AstronomyDAO,
    private val astronomyDatabase: AstronomyDatabase,
    private val service: AstronomyService,
): AstronomyRepository {

    val apiKey = BuildConfig.ASTRONOMY_API_KEY

    override suspend fun getAstronomyList(startDate: String, endDate: String): List<AstronomyBean> {
        return service.getAstronomyList(apiKey, startDate, endDate)
    }
    override fun setCache(astronomyList: List<AstronomyBean>) {
        astronomyDAO.deleteAll()
        astronomyDAO.insertAll(astronomyList)
    }
}
