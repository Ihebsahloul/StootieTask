package com.stootie.domain

import android.os.Parcelable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase<T, in Params>(private val subscribeScheduler: Scheduler,
                                     private val postExecutionScheduler: Scheduler
) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseSingle(params: Params?): Single<T>

    abstract fun buildUseCaseEntity(params: Params?): Single<Parcelable>

    fun execute(observer: SingleObserver<T>, params: Params? = null) {
        val observable: Single<T> = this.buildUseCaseSingle(params)
            .subscribeOn(subscribeScheduler)
            .observeOn(postExecutionScheduler)
        (observable.subscribeWith(observer) as? Disposable)?.let {
            disposables.add(it)
        }
    }

    /*fun executeParcelable(observer: SingleObserver<T>, params: Params? = null) {
        val observable: Single<Parcelable> = this.buildUseCaseEntity(params)
            .subscribeOn(subscribeScheduler)
            .observeOn(postExecutionScheduler)
        (observable.subscribeWith(observer) as? Disposable)?.let {
            disposables.add(it)
        }
    }*/

    fun dispose() {
        disposables.clear()
    }
}