package com.stootie.data

import CountryEntity
import retrofit2.http.POST

interface Endpoint {
  @POST("https://restcountries.eu/rest/v2/all")
  fun geCountriesList(): List<CountryEntity>
}
