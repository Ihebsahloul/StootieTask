package com.stootie.task.dagger.module

import android.app.Application
import android.content.Context
import com.stootie.task.StootieApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: StootieApp) {
  @Provides
  @Singleton
  internal fun provideAppContext(): Context = app
}
