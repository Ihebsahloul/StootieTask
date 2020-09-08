package com.stootie.task.countries
import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.domain.countries.model.Country
import com.stootie.task.mvp.CleanPresenter
import javax.inject.Inject

class CountriesPresenter @Inject constructor(private val getCountriesListUseCase: GetCountriesListUseCase) : CleanPresenter<CountriesView>() {

  override fun initialise() {
    getView()?.initialiseView()
    getCountriesListUseCase.execute(CountriesListObserver(this))
  }

  override fun disposeSubscriptions() {
    getCountriesListUseCase.dispose()
  }

  fun showCountriesList(countriesList: List<Country>) {
    getView()?.showCountriesList(countriesList)
  }
}
