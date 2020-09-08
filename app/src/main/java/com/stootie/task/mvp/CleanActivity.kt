package com.stootie.task.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class CleanActivity<P : CleanPresenter<Any>> : AppCompatActivity() {

  @Inject
  lateinit var presenter: P

  protected abstract fun getLayout(): Int
  protected abstract fun initInjector()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
    initInjector()
    initPresenter()
  }

  private fun initPresenter() {
    presenter.attachView(this)
    presenter.initialise()
  }

  override fun onDestroy() {
    presenter.disposeSubscriptions()
    presenter.detachView()
    super.onDestroy()
  }
}
