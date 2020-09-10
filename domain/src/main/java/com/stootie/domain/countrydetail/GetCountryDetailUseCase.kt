package com.stootie.domain.countrydetail

import CountryEntity
import com.stootie.data.repository.CountryDetailRepository
import com.stootie.domain.UseCase
import com.stootie.domain.countries.model.Country
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetCountryDetailUseCase @Inject constructor(private val countriesRepository: CountryDetailRepository,
                                                  subscribeScheduler: Scheduler,
                                                  postExecutionScheduler: Scheduler)  {

     fun buildUseCaseEntity(params: Unit?): CountryEntity = countriesRepository.countryDetail()



}