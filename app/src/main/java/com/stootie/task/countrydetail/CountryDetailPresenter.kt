package com.stootie.task.countrydetail
import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.domain.countries.model.Country
import com.stootie.task.mvp.CleanPresenter
import javax.inject.Inject

class CountryDetailPresenter @Inject constructor(private val getCountriesListUseCase: GetCountriesListUseCase) : CleanPresenter<CountryDetailView>() {

  override fun initialise() {
    getView()?.initialiseView()
    getCountriesListUseCase.execute(CountryDetailObserver(this))
  }

  override fun disposeSubscriptions() {
    getCountriesListUseCase.dispose()
  }

  fun showCountriesList(countriesList: List<Country>) {
    getView()?.showCountriesList(countriesList)
  }
}
