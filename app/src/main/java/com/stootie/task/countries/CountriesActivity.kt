package com.stootie.task.countries

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mtp.laboproject.view.adapter.CountriesListAdapter
import com.myhexaville.simplerecyclerview.SimpleRecyclerView
import com.stootie.domain.countries.model.Country
import com.stootie.task.R
import com.stootie.task.StootieApp
import com.stootie.task.countries.di.component.DaggerCountriesComponent
import com.stootie.task.mvp.CleanActivity
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_countries.*


class CountriesActivity : CleanActivity <CountriesPresenter>(), CountriesView {
    private lateinit var countriesAdapter: CountriesListAdapter
    private lateinit var tvNoRecords: TextView
    private lateinit var countriesRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var searchView: SearchView
    private lateinit var toolbar: Toolbar
    private lateinit var countriesDisposable: Disposable
    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false
    private var currentPage: Int = 1
    private val totalPages: Int = 3
    override fun getLayout(): Int = R.layout.activity_countries
    val stootieApp = StootieApp()

  //  val swipeRefreshLayout  : SwipeRefreshLayout = findViewById(R.id.swipeCountries)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        tvNoRecords = findViewById(R.id.no_records_tv)
        countriesRecyclerView = findViewById(R.id.countries_list_recycler_view)




    }
    override fun initInjector() {
       DaggerCountriesComponent.builder()
           .appComponent(stootieApp.applicationComponent)
            .build()
            .inject(this)

    }

    private fun searchCountry(countriesListAdapter: CountriesListAdapter) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                countriesListAdapter.filter.filter(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                countriesListAdapter.filter.filter(query)
                return false
            }
        })
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        searchView = menu.findItem(R.id.search_view).actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)
        menu.findItem(R.id.search_view).isVisible = true
        searchCountry(countriesAdapter)
        return true
    }


    override fun initialiseView() {
        countries_list_recycler_view.apply {
            setHasFixedSize(true)
          //  layoutManager = LinearLayoutManager(this@CountriesActivity)



    }
    }
    private fun setRecyclerView() {

    }

    override fun showCountriesList(countries: List<Country>) {
       //countries_list_recycler_view.adapter = CountriesListAdapter(this, countries)

        val llm = LinearLayoutManager(this)
        countriesAdapter = CountriesListAdapter(this,countries)
        countriesRecyclerView.setLayoutManager(LinearLayoutManager(this))
        countriesRecyclerView.setAdapter(CountriesListAdapter(this, countries))
        //searchCountry(countriesAdapter)
        setSwipeRefresh(countries)
    }

    private fun setSwipeRefresh(countries: List<Country>) {

        swipeCountries.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                this!!,
                R.color.orange
            )
        )
        swipeCountries.setColorSchemeColors(Color.WHITE)
        swipeCountries.setOnRefreshListener {
            countriesRecyclerView.setAdapter(CountriesListAdapter(this, countries))
            swipeCountries.isRefreshing = false
        }
    }




    override fun onDestroy() {
        super.onDestroy()

    }

}
