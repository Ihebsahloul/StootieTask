package com.stootie.data.repository

import CountryEntity
import android.content.Intent
import javax.inject.Inject

class CountryDetailRepository @Inject constructor( ) {
   val intent : Intent
      get() {
         TODO()
      }

   fun countryDetail(): CountryEntity = intent.getSerializableExtra("country")as CountryEntity

}