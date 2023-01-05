package com.personal.project.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Astronomy::class], version = 1)
abstract class AstronomyDB: RoomDatabase() {

    abstract fun astronomyDAO(): AstronomyDAO
}
