package io.github.patrickyin.cleanarchitecture.app.articles

import com.stootie.domain.countries.GetCountriesListUseCase
import com.stootie.domain.countries.model.Country
import com.stootie.task.countries.CountriesListObserver
import com.stootie.task.countries.CountriesPresenter
import com.stootie.task.countries.CountriesView
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)
@PrepareForTest(GetCountriesListUseCase::class)
class CountriesPresenterTest {
  private lateinit var presenter: CountriesPresenter

  @Suppress("UNCHECKED_CAST")
  private fun <T> any(type: Class<T>): T {
    Mockito.any<T>(type)
    return null as T
  }

  @Mock
  lateinit var getCountriesListUseCase: GetCountriesListUseCase

  @Mock
  lateinit var view: CountriesView

  @Before
  fun setUp() {
    presenter = CountriesPresenter(getCountriesListUseCase)
    presenter.attachView(view)
  }

  @Test
  fun `should init view`() {
    presenter.initialise()
    verify(view).initialiseView()
  }

  @Test
  fun `should dispose subscription`() {
    presenter.disposeSubscriptions()
    verify(getCountriesListUseCase).dispose()
  }

  @Test
  fun `should execute usecase when initialise is invoked`() {
    presenter.initialise()
    verify(getCountriesListUseCase).execute(any(CountriesListObserver::class.java), ArgumentMatchers.isNull())
  }

  @Test
  fun `should set articles list to view`() {
    val list = emptyList<Country>()
    presenter.showCountriesList(list)
    verify(view).showCountriesList(list)
  }
}