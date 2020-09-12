package com.stootie.domain.countries

import android.os.Parcelable
import com.stootie.data.repository.CountriesRepository
import com.stootie.domain.UseCase
import com.stootie.domain.countries.model.Country
import io.reactivex.Scheduler
import io.reactivex.Single
import java.io.Serializable
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(private val countriesRepository: CountriesRepository,
                                                  subscribeScheduler: Scheduler,
                                                  postExecutionScheduler: Scheduler) : UseCase<List<Country>, Unit>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Unit?): Single<List<Country>> = countriesRepository.countries()
        .map {
            it.map { Country(it.name, it.capital, it.population,it.currencies.get(0).name, it.languages.get(0).name,it.callingCodes,it.area,it.numericCode,it.region,it.flag) }
        }

    override fun buildUseCaseEntity(params: Unit?): Parcelable {
        TODO("Not yet implemented")
    }
}