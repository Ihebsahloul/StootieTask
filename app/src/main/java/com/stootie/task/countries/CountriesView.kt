package com.stootie.task.countries

import com.stootie.domain.countries.model.Country

interface CountriesView {
  fun initialiseView()
  fun showCountriesList(countries: List<Country>)
  fun showError (e :Throwable)
}
