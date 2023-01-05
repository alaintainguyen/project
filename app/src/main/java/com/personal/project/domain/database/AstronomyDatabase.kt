package com.personal.project.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.personal.project.domain.model.AstronomyBean

@Database(entities = [AstronomyBean::class], version = 1, exportSchema = false)
abstract class AstronomyDatabase : RoomDatabase() {
    abstract fun astronomyDAO(): AstronomyDAO
}
