package com.stootie.domain.countries.model

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

data class Country(var name: String? = null,
                   var numericCode: Int? ,
                   var region: String? ,
                   var flag: String? = null):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
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