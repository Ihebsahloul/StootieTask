package com.stootie.task.countrydetail

import com.stootie.domain.countries.model.Country

interface CountryDetailView {
  fun initialiseView()
  fun showCountryDetail(country: Country)
}
