package com.stootie.domain.countrydetail

import CountryEnity
import com.stootie.data.repository.CountriesRepository
import com.stootie.data.repository.CountryDetailRepository
import com.stootie.domain.UseCase
import com.stootie.domain.countries.model.Country
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetCountryDetailUseCase @Inject constructor(private val countriesRepository: CountryDetailRepository,
                                                  subscribeScheduler: Scheduler,
                                                  postExecutionScheduler: Scheduler) : UseCase<Country, Unit>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseEntity(params: Unit?): CountryEnity = countriesRepository.countryDetail()

    override fun buildUseCaseSingle(params: Unit?): Single<Country> {
        TODO("Not yet implemented")
    }
}