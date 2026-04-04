package io.orazzu.android_course.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.orazzu.android_course.data.app.AppLocalRepo
import io.orazzu.android_course.data.app_details.AppDetailsLocalRepo
import io.orazzu.android_course.domain.app.AppRepo
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAppDetailsRepo(impl: AppDetailsLocalRepo): AppDetailsRepo

    @Binds
    @Singleton
    abstract fun bindAppRepo(impl: AppLocalRepo): AppRepo
}
