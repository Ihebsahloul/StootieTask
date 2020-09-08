package com.stootie.task.countries.di.component

import com.stootie.task.countries.CountriesActivity
import com.stootie.task.countries.di.module.CountriesModule
import com.stootie.task.dagger.component.AppComponent
import com.stootie.task.mvp.PerActivity
import dagger.Component
@PerActivity
@Component(dependencies = [AppComponent::class], modules = [CountriesModule::class])
interface CountriesComponent {
  fun inject(countriesActivity: CountriesActivity)
}