package com.personal.project.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.personal.project.ProjectApplication
import com.personal.project.domain.database.AstronomyDAO
import com.personal.project.domain.database.AstronomyDatabase
import com.personal.project.domain.repository.AstronomyRepository
import com.personal.project.domain.repository.AstronomyRepositoryImpl
import com.personal.project.network.AstronomyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProjectApplication(@ApplicationContext application: Context): ProjectApplication =
        application as ProjectApplication

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideAstronomyDB(context: Context) =
        Room.databaseBuilder(context, AstronomyDatabase::class.java, "astronomy-database").build()

    @Provides
    fun provideAstronomyDAO(astronomyDB: AstronomyDatabase) = astronomyDB.astronomyDAO()

    @Provides
    fun provideAstronomyRepository(
        astronomyDAO: AstronomyDAO,
        astronomyDB: AstronomyDatabase,
        service: AstronomyService,
    ): AstronomyRepository =
        AstronomyRepositoryImpl(astronomyDAO, astronomyDB, service)
}
