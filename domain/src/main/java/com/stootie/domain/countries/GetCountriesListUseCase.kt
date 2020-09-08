package com.stootie.domain.countries

import CountryEnity
import com.stootie.data.repository.CountriesRepository
import com.stootie.domain.countries.model.Country
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(private val countriesRepository: CountriesRepository,
                                                  subscribeScheduler: Scheduler,
                                                  postExecutionScheduler: Scheduler) : UseCase<List<Country>, Unit>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Unit?): Single<List<Country>> = countriesRepository.countries()
        .map {
            it.map { Country(it.name, it.numericCode, it.flag) }
        }
}