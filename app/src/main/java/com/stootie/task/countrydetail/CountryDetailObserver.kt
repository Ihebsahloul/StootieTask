package com.stootie.task.countrydetail

import com.stootie.domain.countries.model.Country
import io.reactivex.observers.DisposableSingleObserver

class CountryDetailObserver(private val presenter: CountryDetailPresenter): DisposableSingleObserver<Country>() {


  override fun onError(e: Throwable) {
    e.printStackTrace()
  }

  override fun onSuccess(t: Country) {
    presenter.showCountryDetail(t)
  }
}
