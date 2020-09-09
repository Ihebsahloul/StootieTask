package com.stootie.task.countries

import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.StootieApp
import com.stootie.task.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_countries.*


class CountriesActivity : CleanActivity <CountriesPresenter>(), CountriesView {
    override fun getLayout(): Int = R.layout.activity_countries

    override fun initInjector() {
       DaggerCountriesComponent.builder()
            .appComponent((application as StootieApp).applicationComponent)
            .build()
            .inject(this)
    }

    override fun initialiseView() {
        countries_list_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@CountriesActivity)
        }
    }

    override fun showCountriesList(countries: List<Country>) {
        countries_list_recycler_view.adapter = CountriesListAdapter(this, countries)
    }

}
