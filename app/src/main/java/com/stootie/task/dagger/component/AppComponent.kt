package com.stootie.task.dagger.component

import android.content.Context
import com.stootie.data.Endpoint
import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.task.StootieApp
import com.stootie.task.dagger.module.AppModule
import com.stootie.task.dagger.module.IOModule
import com.stootie.task.dagger.module.RepositoryModule
import com.stootie.task.dagger.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: StootieApp)
  fun getApplicationContext(): Context
  fun getEndpoint(): Endpoint

  fun getCountriesListUseCase(): GetCountriesListUseCase
}
