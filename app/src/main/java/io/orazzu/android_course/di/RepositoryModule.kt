package io.orazzu.android_course.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.orazzu.android_course.data.edu_catalog.app.AppEduCatalogRepo
import io.orazzu.android_course.data.edu_catalog.app_details.AppDetailsEduCatalogRepo
import io.orazzu.android_course.domain.app.AppRepo
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAppDetailsRepo(impl: AppDetailsEduCatalogRepo): AppDetailsRepo

    @Binds
    @Singleton
    abstract fun bindAppRepo(impl: AppEduCatalogRepo): AppRepo
}
