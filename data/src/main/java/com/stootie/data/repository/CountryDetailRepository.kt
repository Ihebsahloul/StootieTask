package com.stootie.data.repository

import CountryEnity
import com.stootie.data.Endpoint
import io.reactivex.Single
import javax.inject.Inject

class CountryDetailRepository @Inject constructor(private val endpoint: Endpoint) {
    fun countries(): Single<CountryEnity> = endpoint.geCountriesList()
        .map { it }
}