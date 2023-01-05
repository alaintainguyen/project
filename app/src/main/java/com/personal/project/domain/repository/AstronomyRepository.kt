package com.personal.project.domain.repository

import android.database.Observable
import com.personal.project.domain.model.AstronomyBean

interface AstronomyRepository {
    suspend fun getAstronomyList(startDate: String, endDate: String): List<AstronomyBean>
    fun setCache(astronomyList: List<AstronomyBean>)
}
