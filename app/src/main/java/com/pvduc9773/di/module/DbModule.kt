package com.pvduc9773.di.module

import android.app.Application
import com.pvduc9773.data.local.AppDatabase
import com.pvduc9773.data.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pvduc9773 on 5/14/20.
 */
@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.buildDatabase(application)
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }
}