package com.stootie.task.dagger.module

import com.stootie.data.repository.CountriesRepository
import com.stootie.data.repository.CountryDetailRepository
import com.stootie.domain.countries.GetCountriesListUseCase
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
  internal fun provideGetCountriesListUseCase(countriesRepository: CountriesRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetCountriesListUseCase =
    GetCountriesListUseCase(countriesRepository, ioScheduler, mainThreadScheduler)

  @Provides
  @Singleton
  internal fun provideGetCountryDetailtUseCase(countryDetailRepository: CountryDetailRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetCountryDetailUseCase =
    GetCountriesListUseCase(countriesRepository, ioScheduler, mainThreadScheduler)
}
