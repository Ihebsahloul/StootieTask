package com.stootie.data

import CountryEnity
import com.stootie.data.model.Countries
import io.reactivex.Single
import retrofit2.http.POST

interface Endpoint {
  @POST("https://restcountries.eu/rest/v2/all")
  fun geCountriesList(): List<CountryEnity>
}
