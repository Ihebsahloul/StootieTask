package com.stootie.task.dagger.component

import android.content.Context
import com.stootie.data.Endpoint
import com.stootie.task.StootieApp
import com.stootie.task.dagger.module.AppModule
import com.stootie.task.dagger.module.IOModule
import com.stootie.task.dagger.module.RepositoryModule
import com.stootie.task.dagger.module.UseCaseModule
import dagger.Component
import io.github.patrickyin.cleanarchitecture.app.App
import io.github.patrickyin.cleanarchitecture.app.di.module.AppModule
import io.github.patrickyin.cleanarchitecture.app.di.module.IOModule
import io.github.patrickyin.cleanarchitecture.app.di.module.RepositoryModule
import io.github.patrickyin.cleanarchitecture.app.di.module.UseCaseModule
import io.github.patrickyin.cleanarchitecture.data.Endpoint
import io.github.patrickyin.cleanarchitecture.domain.articles.GetArticlesListUseCase
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: StootieApp)
  fun getApplicationContext(): Context
  fun getEndpoint(): Endpoint

  fun getArticlesListUseCase(): GetArticlesListUseCase
}
