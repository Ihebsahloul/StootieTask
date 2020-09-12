import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable



@Suppress("UNREACHABLE_CODE")
data class CountryEntity (

	@SerializedName("name") val name : String,
	@SerializedName("topLevelDomain") val topLevelDomain : List<String>,
	@SerializedName("alpha2Code") val alpha2Code : String,
	@SerializedName("alpha3Code") val alpha3Code : String,
	@SerializedName("callingCodes") val callingCodes : List<String>,
	@SerializedName("capital") val capital : String,
	@SerializedName("altSpellings") val altSpellings : List<String>,
	@SerializedName("region") val region : String,
	@SerializedName("subregion") val subregion : String,
	@SerializedName("population") val population : Long,
	@SerializedName("latlng") val latlng : List<Float>,
	@SerializedName("demonym") val demonym : String,
	@SerializedName("area") val area : Double,
	@SerializedName("timezones") val timezones : List<String>,
	@SerializedName("borders") val borders : List<String>,
	@SerializedName("nativeName") val nativeName : String,
	@SerializedName("numericCode") val numericCode : Long,
	@SerializedName("currencies") val currencies : List<CurrenciesEntity>,
	@SerializedName("languages") val languages : List<LanguagesEntity>,
	@SerializedName("translations") val translations : TranslationsEntity,
	@SerializedName("flag") val flag : String,
	@SerializedName("regionalBlocs") val regionalBlocs : List<RegionalBlocsEntity>,
	@SerializedName("cioc") val cioc : String
) :Serializable