package com.personal.project.domain.repository

import com.personal.project.domain.model.AstronomyBean

interface AstronomyRepository {
    suspend fun getAstronomyList(startDate: String, endDate: String): List<AstronomyBean>
    fun setDatabase(astronomyList: List<AstronomyBean>)
}
