package io.orazzu.android_course.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.orazzu.android_course.data.caching.AppDatabase
import io.orazzu.android_course.data.caching.app_details.AppDetailsDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao = database.appDetailsDao()
}
