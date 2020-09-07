package com.stootie.data.model

import CountryEnity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Countries(
  @SerializedName("countries")
  var countries: List<CountryEnity>? = null)
