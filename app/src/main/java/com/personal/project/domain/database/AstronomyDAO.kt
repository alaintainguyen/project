package com.personal.project.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.personal.project.domain.model.AstronomyBean

@Dao
interface AstronomyDAO {

    @Query("SELECT * FROM astronomy")
    fun getAllAstronomy(): List<AstronomyBean>

    @Insert
    fun insertAll(astronomyList: List<AstronomyBean>)

    @Query("DELETE FROM astronomy")
    fun deleteAll()

    @Query("SELECT * FROM astronomy WHERE title = :title")
    fun getAstronomyDetailsByTitle(title: String): AstronomyBean

}
