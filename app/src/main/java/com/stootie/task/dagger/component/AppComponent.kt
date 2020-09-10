package com.stootie.task.dagger.component

import android.app.Application
import android.content.Context
import com.stootie.data.ApiInterface
import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.domain.countrydetail.GetCountryDetailUseCase
import com.stootie.task.StootieApp
import com.stootie.task.dagger.module.AppModule
import com.stootie.task.dagger.module.NetworkModule
import com.stootie.task.dagger.module.RepositoryModule
import com.stootie.task.dagger.module.UseCaseModule
import dagger.Binds
import dagger.Component
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: StootieApp)
  fun getApplicationContext(): Context
  fun getEndpoint(): ApiInterface
  fun getCountriesListUseCase(): GetCountriesListUseCase
  fun getCountryDetailUseCase(): GetCountryDetailUseCase
}
