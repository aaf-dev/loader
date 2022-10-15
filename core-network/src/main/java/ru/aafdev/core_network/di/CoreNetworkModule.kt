package ru.aafdev.core_network.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.aafdev.core_network.NetworkService

val coreNetworkModule = module {
    factory { provideRetrofit() }
    single { provideNetworkService(retrofit = get()) }
}

private fun provideRetrofit(): Retrofit {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY

    val httpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    return Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}

private fun provideNetworkService(retrofit: Retrofit): NetworkService {
    return retrofit.create(NetworkService::class.java)
}
