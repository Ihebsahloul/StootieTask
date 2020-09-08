package com.stootie.task

import android.app.Application
import com.stootie.task.dagger.component.AppComponent
import com.stootie.task.dagger.module.AppModule

class StootieApp : Application() {
  val applicationComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
      .appModule(AppModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    initInjector()
  }

  private fun initInjector() {
    applicationComponent.inject(this)
  }
}
