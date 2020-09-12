package com.stootie.task.dagger.module

import com.stootie.data.ApiInterface
import com.stootie.data.repository.CountriesRepository
import com.stootie.data.repository.CountryDetailRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
 @Provides
  @Singleton
  internal fun provideCountriesRepository( endpoint: ApiInterface): CountriesRepository = CountriesRepository(endpoint)

  @Provides
  @Singleton
  internal fun provideCountryDetailRepository(): CountryDetailRepository = CountryDetailRepository()
}