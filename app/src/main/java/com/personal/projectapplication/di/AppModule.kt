package com.personal.projectapplication.di

import android.app.Application
import android.content.Context
import com.personal.projectapplication.ProjectApplication
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
}
