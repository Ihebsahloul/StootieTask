package com.mtp.laboproject.view.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.countrydetail.CountryDetailActivity
import kotlinx.android.synthetic.main.list_item_country.view.*

class CountriesListAdapter(private val context: Context,
    private val countries: List<Country>

) : RecyclerView.Adapter<CountriesListAdapter.ViewHolder>(), Filterable {
    var filtredListofCountries = countries
    private var resultListOfSearch = arrayListOf<Country>()

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                filtredListofCountries = if (p0.isNullOrEmpty())
                    countries
                else {
                    resultListOfSearch.clear()
                    countries.forEach {
                        if (it.name.toString().toLowerCase().contains(p0.toString()))
                            resultListOfSearch.add(it)
                    }
                    resultListOfSearch
                }
                var filtredResult = FilterResults()
                filtredResult.values = filtredListofCountries
                return filtredResult
            }

            override fun publishResults(p0: CharSequence?, filtredResult: FilterResults?) {
                filtredListofCountries = listOf()
                filtredListofCountries = filtredResult!!.values as List<Country>
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return filtredListofCountries.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_country, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country : Country = filtredListofCountries.get(position)
        val countryNumeric = position +1
        val countryName : String? = country.name
        val countryRegion : String? = country.region
        val countryFlag : String? = country.flag
        val dot   = "."
        val nameText : String? ="$countryNumeric$dot  ${countryName}"
        holder.countryNameTv?.text = nameText
        holder.countryRegionTv?.text = countryRegion
        val flagUri = Uri.parse(countryFlag)
        GlideToVectorYou
            .init()
            .with(context)
            .load(flagUri, holder.countryFlagIv)
        holder.itemLayout?.setOnClickListener {
            navigateToCountryDetail(country)
        }

    }
    private fun navigateToCountryDetail(country: Country) {
        country.let {
            val value: Country? = country
            val intent = Intent(context, CountryDetailActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("country", value)
            context.startActivity( intent)
        }
    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each country
        val countryNameTv = view.country_name_tv
        val itemLayout = view.viewCard_country
        val countryRegionTv = view.country_region_tv
        val countryFlagIv = view.country_flag_iv

    }
}
