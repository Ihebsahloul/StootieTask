package com.stootie.task.countrydetail.di.module

import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.domain.countrydetail.GetCountryDetailUseCase
import com.stootie.task.countries.CountriesPresenter
import com.stootie.task.countrydetail.CountryDetailPresenter
import com.stootie.task.mvp.PerActivity
import dagger.Module
import dagger.Provides

@Module
class CountryDetailModule {
    @PerActivity
    @Provides
    internal fun provideCountryDetailPresenter(getCountryDetailUseCase: GetCountryDetailUseCase) = CountryDetailPresenter(getCountryDetailUseCase)


}
