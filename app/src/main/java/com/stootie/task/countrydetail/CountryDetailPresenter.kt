package com.stootie.task.countrydetail
import com.stootie.domain.countries.model.Country
import com.stootie.domain.countrydetail.GetCountryDetailUseCase
import com.stootie.task.mvp.CleanPresenter
import io.reactivex.SingleObserver
import javax.inject.Inject

class CountryDetailPresenter @Inject constructor(private val getCountryDetailUseCase: GetCountryDetailUseCase) : CleanPresenter<CountryDetailView>() {

  override fun initialise() {
    getView()?.initialiseView()
  }

  override fun disposeSubscriptions() {

  }

  fun showCountryDetail(country: Country) {
    getView()?.showCountryDetail(country)
  }
}
