import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


@Suppress("UNREACHABLE_CODE")
data class CountryEntity (

	@SerializedName("name") val name : String,
	@SerializedName("topLevelDomain") val topLevelDomain : List<String>,
	@SerializedName("alpha2Code") val alpha2Code : String,
	@SerializedName("alpha3Code") val alpha3Code : String,
	@SerializedName("callingCodes") val callingCodes : List<Int>,
	@SerializedName("capital") val capital : String,
	@SerializedName("altSpellings") val altSpellings : List<String>,
	@SerializedName("region") val region : String,
	@SerializedName("subregion") val subregion : String,
	@SerializedName("population") val population : Int,
	@SerializedName("latlng") val latlng : List<Double>,
	@SerializedName("demonym") val demonym : String,
	@SerializedName("area") val area : Int,
	@SerializedName("gini") val gini : String,
	@SerializedName("timezones") val timezones : List<String>,
	@SerializedName("borders") val borders : List<String>,
	@SerializedName("nativeName") val nativeName : String,
	@SerializedName("numericCode") val numericCode : Int,
	@SerializedName("currencies") val currencies : List<CurrenciesEntity>,
	@SerializedName("languages") val languages : List<LanguagesEntity>,
	@SerializedName("translations") val translations : TranslationsEntity,
	@SerializedName("flag") val flag : String,
	@SerializedName("regionalBlocs") val regionalBlocs : List<RegionalBlocsEntity>,
	@SerializedName("cioc") val cioc : String
) :Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString()!!,
		parcel.createStringArrayList()!!,
		parcel.readString()!!,
		parcel.readString()!!,
		TODO("callingCodes"),
		parcel.readString()!!,
		parcel.createStringArrayList()!!,
		parcel.readString()!!,
		parcel.readString()!!,
		parcel.readInt(),
		TODO("latlng"),
		parcel.readString()!!,
		parcel.readInt(),
		parcel.readString()!!,
		parcel.createStringArrayList()!!,
		parcel.createStringArrayList()!!,
		parcel.readString()!!,
		parcel.readInt(),
		TODO("currencies"),
		TODO("languages"),
		TODO("translations"),
		parcel.readString()!!,
		TODO("regionalBlocs"),
		parcel.readString()!!
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(name)
		parcel.writeStringList(topLevelDomain)
		parcel.writeString(alpha2Code)
		parcel.writeString(alpha3Code)
		parcel.writeString(capital)
		parcel.writeStringList(altSpellings)
		parcel.writeString(region)
		parcel.writeString(subregion)
		parcel.writeInt(population)
		parcel.writeString(demonym)
		parcel.writeInt(area)
		parcel.writeString(gini)
		parcel.writeStringList(timezones)
		parcel.writeStringList(borders)
		parcel.writeString(nativeName)
		parcel.writeInt(numericCode)
		parcel.writeString(flag)
		parcel.writeString(cioc)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<CountryEntity> {
		override fun createFromParcel(parcel: Parcel): CountryEntity {
			return CountryEntity(parcel)
		}

		override fun newArray(size: Int): Array<CountryEntity?> {
			return arrayOfNulls(size)
		}
	}
}