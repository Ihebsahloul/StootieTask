package com.stootie.task.dagger.module

import com.stootie.data.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCaseModule {
  @Provides
  @Singleton
  @Named("ioScheduler")
  internal fun provideIoScheduler() = Schedulers.io()

  @Provides
  @Singleton
  @Named("mainThreadScheduler")
  internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()

  @Provides
  @Singleton
  internal fun provideGetArticlesListUseCase(articlesRepository: CountriesRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetArticlesListUseCase =
    GetCountriesListUseCase(articlesRepository, ioScheduler, mainThreadScheduler)
}
