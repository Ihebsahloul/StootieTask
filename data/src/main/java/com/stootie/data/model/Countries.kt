package com.stootie.data.model

import CountryEntity
import com.google.gson.annotations.SerializedName

data class Countries(
  @SerializedName("countries")
  var countries: List<CountryEntity>? = null)
