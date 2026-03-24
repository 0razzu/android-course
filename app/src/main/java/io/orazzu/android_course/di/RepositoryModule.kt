package io.orazzu.android_course.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.orazzu.android_course.data.caching.app_details.AppDetailsCachingRepo
import io.orazzu.android_course.data.edu_catalog.app.AppEduCatalogRepo
import io.orazzu.android_course.domain.app.AppRepo
import io.orazzu.android_course.domain.app_details.AppDetailsRepo

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAppDetailsRepo(impl: AppDetailsCachingRepo): AppDetailsRepo

    @Binds
    abstract fun bindAppRepo(impl: AppEduCatalogRepo): AppRepo
}
