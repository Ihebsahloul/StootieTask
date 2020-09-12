package com.stootie.task.countries

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.Configuration
import com.google.android.material.snackbar.Snackbar
import com.mtp.laboproject.view.adapter.CountriesListAdapter
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
    private lateinit var searchView: SearchView

    private lateinit var toolbar: Toolbar
    private lateinit var countriesDisposable: Disposable
    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false
    private lateinit var progressBar: ProgressBar
    private var currentPage: Int = 1
    private val totalPages: Int = 3
    override fun getLayout(): Int = R.layout.activity_countries
    val stootieApp = StootieApp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        setViews()


    }

    private fun setViews() {
        tvNoRecords = findViewById(R.id.no_records_tv)
        countriesRecyclerView = findViewById(R.id.countries_list_recycler_view)
        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
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

                countriesRecyclerView.adapter = CountriesListAdapter(applicationContext, countriesListAdapter.filtredListofCountries)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                countriesListAdapter.filter.filter(query)
                countriesRecyclerView.adapter = CountriesListAdapter(applicationContext, countriesListAdapter.filtredListofCountries)

                return false
            }
        })
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        searchView = menu.findItem(R.id.search_view).actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)
        menu.findItem(R.id.search_view).isVisible = true
        return true
    }


    override fun initialiseView() {
        countries_list_recycler_view.apply {
            setHasFixedSize(true) }
    }

    override fun showCountriesList(countries: List<Country>) {
       //countries_list_recycler_view.adapter = CountriesListAdapter(this, countries)

        val llm = LinearLayoutManager(this)
        countriesAdapter = CountriesListAdapter(this,countries)
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        countriesRecyclerView.adapter = CountriesListAdapter(this, countries)
        searchCountry(countriesAdapter)
        setSwipeRefresh(CountriesListAdapter(this, countries).filtredListofCountries)
    }

    override fun showError(e: Throwable) {
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content), getString(R.string.error_text),
            Snackbar.LENGTH_LONG
        )
        snackBar.setActionTextColor(resources.getColor(R.color.black))
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(resources.getColor(R.color.black))
        val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.BLUE)
        snackBar.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        return if (id == R.id.search_view) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun setSwipeRefresh(countries: List<Country>) {

        swipeCountries.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                this,
                R.color.orange
            )
        )
        swipeCountries.setColorSchemeColors(Color.WHITE)
        swipeCountries.setOnRefreshListener {
            countriesRecyclerView.adapter = CountriesListAdapter(applicationContext, countries)
            swipeCountries.isRefreshing = false
        }
    }

   /* private fun setCountries(countriesList: ArrayList<Country>) {
        if (currentPage == 1) {
            countriesAdapter.setCountries(countriesList)
            countriesListAdapter.addLoadingFooter()
            countriesListAdapter.notifyDataSetChanged()
            if (currentPage == totalPages) {
                countriesListAdapter.removeLoadingFooter()
                isLastPage = true
            }
        } else {
            if (!countriesList.isEmpty()) {
                countriesListAdapter.removeLoadingFooter()
                isLoading = false
                countriesListAdapter.addAll(countriesList)
                countriesListAdapter.addLoadingFooter()
            } else {
                countriesListAdapter.removeLoadingFooter()
                isLoading = false
                isLastPage = true
            }
        }
    }*/
}
