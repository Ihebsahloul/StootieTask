package com.stootie.task.dagger.module

import com.stootie.data.ApiInterface
import com.stootie.data.Endpoint
import com.stootie.data.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  internal fun provideCountriesRepository(endpoint: ApiInterface): CountriesRepository = CountriesRepository(endpoint)
}