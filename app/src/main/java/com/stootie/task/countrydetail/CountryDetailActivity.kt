package com.stootie.task.countrydetail

import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.StootieApp
import com.stootie.task.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_countries.*


class CountryDetailActivity : CleanActivity <CountryDetailPresenter>(), CountryDetailView {
    override fun getLayout(): Int = R.layout.activity_countries

    override fun initInjector() {
       DaggerCountryDetailComponent.builder()
            .appComponent((application as StootieApp).applicationComponent)
            .build()
            .inject(this)
    }

    override fun initialiseView() {

        }

    override fun showCountryDetail(country: Country) {
        TODO("Not yet implemented")
    }
}




