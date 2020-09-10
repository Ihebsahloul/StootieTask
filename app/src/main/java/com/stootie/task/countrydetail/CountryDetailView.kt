package com.stootie.task.countrydetail

import android.os.Parcelable
import com.stootie.domain.countries.model.Country

interface CountryDetailView {
  fun initialiseView()
  fun getCountryDetail()
  fun showCountryDetail(country : Country)
}
