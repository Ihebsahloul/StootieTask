package com.stootie.task.countrydetail.di.component

import com.stootie.task.countries.CountriesActivity
import com.stootie.task.countries.di.module.CountriesModule
import com.stootie.task.countrydetail.CountryDetailActivity
import com.stootie.task.countrydetail.di.module.CountryDetailModule
import com.stootie.task.dagger.component.AppComponent
import com.stootie.task.mvp.PerActivity
import dagger.Component
@PerActivity
@Component(dependencies = [AppComponent::class], modules = [CountryDetailModule::class])
interface CountryDetailComponent {
  fun inject(countryDetailActivity: CountryDetailActivity)
}