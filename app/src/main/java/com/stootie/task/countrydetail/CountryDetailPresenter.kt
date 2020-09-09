package com.stootie.task.countrydetail
import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.domain.countries.model.Country
import com.stootie.domain.countrydetail.GetCountryDetailUseCase
import com.stootie.task.mvp.CleanPresenter
import javax.inject.Inject

class CountryDetailPresenter @Inject constructor(private val getCountryDetailUseCase: GetCountryDetailUseCase) : CleanPresenter<CountryDetailView>() {

  override fun initialise() {
    getView()?.initialiseView()
    getCountryDetailUseCase.execute(CountryDetailObserver(this))
  }

  override fun disposeSubscriptions() {
    getCountryDetailUseCase.dispose()
  }

  fun showCountryDetail(country: Country) {
    getView()?.showCountryDetail(country)
  }
}
