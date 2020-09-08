package com.stootie.domain.countries.model

import android.net.Uri

data class Country(var name: String? = null,
                   var numericCode: Int? ,
                   var flag: String? = null)

fun Country.linkUri(): Uri? = Uri.parse(flag)