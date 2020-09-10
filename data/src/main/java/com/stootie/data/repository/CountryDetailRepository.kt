package com.stootie.data.repository

import CountryEnity
import android.content.Intent
import com.stootie.data.ApiInterface
import com.stootie.data.Endpoint
import io.reactivex.Single
import javax.inject.Inject

class CountryDetailRepository @Inject constructor( ) {
   val intent : Intent
      get() {
         TODO()
      }

   fun countryDetail(): CountryEnity = intent.getParcelableExtra<CountryEnity?>("country")!!

}