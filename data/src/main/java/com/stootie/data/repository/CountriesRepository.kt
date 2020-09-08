package com.stootie.data.repository

import CountryEnity
import com.stootie.data.Endpoint
import javax.inject.Inject

class CountriesRepository @Inject constructor(private val endpoint: Endpoint) {
    fun countries(): List<CountryEnity> = endpoint.geCountriesList()
        .map { it }
}