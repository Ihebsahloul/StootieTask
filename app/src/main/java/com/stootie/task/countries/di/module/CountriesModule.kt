package com.stootie.task.countries.di.module

import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.task.countries.CountriesPresenter
import com.stootie.task.mvp.PerActivity
import dagger.Module
import dagger.Provides

@Module
class CountriesModule {
    @PerActivity
    @Provides
    internal fun provideArticlesPresenter(getArticlesListUseCase: GetCountriesListUseCase) = CountriesPresenter(getArticlesListUseCase)


}
