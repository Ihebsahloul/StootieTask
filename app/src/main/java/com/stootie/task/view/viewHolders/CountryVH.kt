package com.android.kotlinrecyclerviewpagination.ui.adapters.viewHolders

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView


import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.countrydetail.CountryDetailActivity
import org.w3c.dom.Text

class CountryVH(itemView: View,private val countries: List<Country>) : BaseVH(itemView) {


    private lateinit var countryNameTv :TextView
    private lateinit var itemLayout: LinearLayout
    private lateinit var countryRegionTv :TextView
    private lateinit var countryFlagIv : ImageView


    init {
        findViews(itemView)
    }

    private fun findViews(itemView: View) {
        countryNameTv = itemView.findViewById(R.id.country_name_tv)
        itemLayout = itemView.findViewById(R.id.viewCard_country)
        countryRegionTv = itemView.findViewById(R.id.country_region_tv)
        countryFlagIv = itemView.findViewById(R.id.country_flag_iv)
    }

    fun setCountry(country: Country){
        val position : Int = countries.indexOf(country)
        val countryNumeric : String? = position.toString()
        val countryName : String? = country.name
        val countryRegion : String? = country.region
        val countryFlag : String? = country.flag
        val nameText : String? ="$countryNumeric ${countryName}"
        countryNameTv.text = nameText
        countryRegionTv.text = countryRegion
        val flagUri = Uri.parse(countryFlag)
        GlideToVectorYou
            .init()
            .with(getContext())
            .load(flagUri, countryFlagIv)
        itemLayout.setOnClickListener {
            navigateToCountryDetail(position)
        }
    }

    private fun navigateToCountryDetail(position: Int) {

        countries[position].let {
            val value: Country? = countries.get(position)
            val intent = Intent(getContext(), CountryDetailActivity::class.java)
            intent.putExtra("country", value)
            getContext().startActivity( intent)
        }
    }
}