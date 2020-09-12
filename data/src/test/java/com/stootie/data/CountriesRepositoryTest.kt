package io.github.patrickyin.cleanarchitecture.data.articles.repository


import CountryEntity
import com.stootie.data.ApiInterface
import com.stootie.data.model.Countries
import com.stootie.data.repository.CountriesRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(CountryEntity::class, Countries::class)
class CountriesRepositoryTest {

  lateinit var countriesRepository: CountriesRepository

  @Mock
  lateinit var endpoint: ApiInterface

  @Mock
  lateinit var countries: List<CountryEntity>

  @Mock
  lateinit var country: CountryEntity

  lateinit var countriesList: List<CountryEntity>

  @Before
  fun setUp() {
    countriesList = listOf(country)

    `when`(countries)
      .thenReturn(countriesList)
    `when`(endpoint.getCountries())
      .thenReturn(Single.just(countries))

    countriesRepository = CountriesRepository(endpoint)
  }

  @Test
  fun `should map countries field to the root level`() {
    val observer = TestObserver<List<CountryEntity>>()
    countriesRepository.countries()
      .subscribe(observer)
    observer.assertNoErrors()
    observer.assertComplete()
    observer.assertValueAt(0, countriesList)
  }
}