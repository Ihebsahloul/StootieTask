package com.stootie.data

import CountryEntity

import com.stootie.data.global.Constants
import com.stootie.data.model.Countries
import io.reactivex.Single
import retrofit2.http.*

interface ApiInterface {



    @GET(Constants.EndPoints.COUNTRY_DETAIL)
    fun getCountryDetail(name : String): Single<CountryEntity>

    @GET(Constants.EndPoints.ALL_COUNTRIES)
    fun getCountries(): Single<List<CountryEntity>>

}