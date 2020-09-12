package com.stootie.task.countries

import com.stootie.domain.countries.model.Country
import io.reactivex.observers.DisposableSingleObserver

class CountriesListObserver(private val presenter: CountriesPresenter): DisposableSingleObserver<List<Country>>() {
  override fun onSuccess(articlesList: List<Country>) {
    presenter.showCountriesList(articlesList)
  }

  override fun onError(e: Throwable) {
    presenter.showError(e)
    e.printStackTrace()
  }
}
