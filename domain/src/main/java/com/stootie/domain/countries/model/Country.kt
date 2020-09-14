package com.stootie.domain.countries.model

import CurrenciesEntity
import LanguagesEntity
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Country(var name: String? = null,
                   var capital: String? ,
                   var population: Long? ,
                   //var currencies: List<CurrenciesEntity>? ,
                   var currency:String?,
                   var language :String?,
                  // var languages: List<LanguagesEntity>? ,
                   var callingCodes : List<String>?,
                   val area : Double? ,
                   var numericCode: Long? ,
                   var region: String? ,
                   var flag: String? = null): Parcelable {
    constructor(parcel: Parcel) : this(

        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        /*arrayListOf<CurrenciesEntity>().apply {
            parcel.readArrayList(CurrenciesEntity::class.java.classLoader)
        },
                arrayListOf<LanguagesEntity>().apply {
            parcel.readArrayList(LanguagesEntity::class.java.classLoader)
        },*/
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readValue(Long::class.java.classLoader) as? Double,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(capital)
        parcel.writeValue(population)
        //parcel.writeList(currencies)
        //parcel.writeList(languages)
        parcel.writeString(currency)
        parcel.writeString(language)
        parcel.writeStringList(callingCodes)
        parcel.writeValue(area)
        parcel.writeValue(numericCode)
        parcel.writeString(region)
        parcel.writeString(flag)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }
}