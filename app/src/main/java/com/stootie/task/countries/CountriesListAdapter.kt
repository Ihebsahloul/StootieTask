package com.stootie.task.countries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.stootie.domain.countries.model.Country
import com.stootie.domain.countries.model.linkUri
import com.stootie.task.R


class CountriesListAdapter(private val context: Context, private val countries: List<Country>) :
  androidx.recyclerview.widget.RecyclerView.Adapter<CountriesListAdapter.ViewHolder>() {

  class ViewHolder(val button: Button) : androidx.recyclerview.widget.RecyclerView.ViewHolder(button)

  override fun onCreateViewHolder(parent: ViewGroup,
                                  viewType: Int): ViewHolder {
    val button = LayoutInflater.from(context)
      .inflate(R.layout.list_item_country, parent, false) as Button
    return ViewHolder(button)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.button.text = countries[position].name
    holder.button.setOnClickListener {
      countries[position].linkUri()?.let {
        val intent = Intent(Intent.ACTION_VIEW, it)
        startActivity(context, intent, null)
      }
    }
  }

  override fun getItemCount() = countries.size
}
