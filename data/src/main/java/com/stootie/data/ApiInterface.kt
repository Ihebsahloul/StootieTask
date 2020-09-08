package com.stootie.data

import CountryEnity

import com.stootie.domain.global.Constants
import io.reactivex.Single
import retrofit2.http.*

interface ApiInterface {



    @GET(Constants.EndPoints.COUNTRY_DETAIL)
    fun getCountryDetail(name : String): Single<CountryEnity>

    @GET(Constants.EndPoints.ALL_COUNTRIES)
    fun getCountries(): List<CountryEnity>

}