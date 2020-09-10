package com.stootie.task.countries

import android.app.Application
import android.content.Context
import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.StootieApp
import com.stootie.task.countries.di.component.DaggerCountriesComponent
import com.stootie.task.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_countries.*


class CountriesActivity : CleanActivity <CountriesPresenter>(), CountriesView {
    override fun getLayout(): Int = R.layout.activity_countries
    val stootieApp = StootieApp()

    override fun initInjector() {
       DaggerCountriesComponent.builder()
           .appComponent(stootieApp.applicationComponent)
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
