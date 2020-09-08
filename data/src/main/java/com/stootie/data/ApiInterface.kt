package com.stootie.data

import CountryEnity

import com.stootie.data.global.Constants
import com.stootie.data.model.Countries
import io.reactivex.Single
import retrofit2.http.*

interface ApiInterface {



    @GET(Constants.EndPoints.COUNTRY_DETAIL)
    fun getCountryDetail(name : String): Single<CountryEnity>

    @GET(Constants.EndPoints.ALL_COUNTRIES)
    fun getCountries(): Single<Countries>

}