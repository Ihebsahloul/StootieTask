package com.stootie.task.countries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stootie.domain.countries.model.Country
import com.stootie.domain.countries.model.linkUri
import com.stootie.task.R
import com.stootie.task.countrydetail.CountryDetailActivity
import kotlinx.android.synthetic.main.list_item_country.view.*
import org.w3c.dom.Text


class CountriesListAdapter(private val context: Context, private val countries: List<Country>) :
  RecyclerView.Adapter<ViewHolder>() {

  // Gets the number of animals in the list
  override fun getItemCount(): Int {
    return countries.size
  }

  // Inflates the item views
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_country, parent, false))
  }

  // Binds each animal in the ArrayList to a view
  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder?.countryNameTv?.text = countries.get(position).name
    holder.countryNameTv.setOnClickListener {
      navigateToCountryDetail(position)
    }
  }

  private fun navigateToCountryDetail(position: Int) {
    countries[position].linkUri()?.let {
      val value: String? = countries.get(position).name
      val intent = Intent(context, CountryDetailActivity::class.java)
      intent.putExtra("email", value)
      context.startActivity( intent)
    }
  }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
  // Holds the TextView that will add each animal to
  val countryNameTv = view.country_name_tv
  val countryNumericTv = view.country_numeric_tv
  val countryFlagIv = view.country_flag_iv
}