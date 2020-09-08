package com.stootie.task.dagger.module

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.stootie.data.Endpoint
import com.stootie.data.global.Constants
import com.stootie.task.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class IOModule {
  private val endpoint: Endpoint

  init {
    val okHttpBuilder = OkHttpClient.Builder()

    if (BuildConfig.BUILD_TYPE == "debug") {
      okHttpBuilder.addInterceptor { chain ->
        println(chain.request())
        chain.proceed(chain.request())
      }
    }

    val okHttpClient = okHttpBuilder.build()

    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .baseUrl(Constants.BASE_URL)
      .client(okHttpClient)
      .build()

    endpoint = retrofit.create(Endpoint::class.java)
  }

  @Provides
  @Singleton
  internal fun provideEndpoint(): Endpoint = endpoint
}