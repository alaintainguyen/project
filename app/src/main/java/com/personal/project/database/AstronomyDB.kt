package com.personal.project.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.personal.project.model.Astronomy

@Database(entities = [Astronomy::class], version = 1)
abstract class AstronomyDB: RoomDatabase() {

    abstract fun astronomyDAO(): AstronomyDAO
}
