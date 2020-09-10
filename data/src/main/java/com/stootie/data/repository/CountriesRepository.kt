package com.stootie.data.repository

import CountryEntity
import com.stootie.data.ApiInterface
import io.reactivex.Single
import javax.inject.Inject

class CountriesRepository @Inject constructor(private val endpoint: ApiInterface) {
    fun countries(): Single<List<CountryEntity>> = endpoint.getCountries()
        .map { it }
}