package com.stootie.task.countrydetail

import android.app.Application
import android.content.Context
import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.StootieApp
import com.stootie.task.countrydetail.di.component.DaggerCountryDetailComponent
import com.stootie.task.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_countries.*
import kotlinx.android.synthetic.main.activity_countrydetail.*


class CountryDetailActivity : CleanActivity <CountryDetailPresenter>(), CountryDetailView {
    override fun getLayout(): Int = R.layout.activity_countrydetail
    val stootieApp = StootieApp()

    override fun initInjector() {
      DaggerCountryDetailComponent.builder()
          .appComponent(stootieApp.applicationComponent)
            .build()
            .inject(this)
    }

    override fun initialiseView() {
        val country: Country = intent.getParcelableExtra<Country>("country")!!
        presenter.showCountryDetail(country)
        }

    override fun getCountryDetail() {
       val country: Country = intent.getParcelableExtra<Country>("country")!!
        presenter.showCountryDetail(country)
    }

    override fun showCountryDetail(country: Country) {

        country_area_tv.text=country.name
        country_name_tv.text=country.numericCode.toString()
    }
}




