package ru.aafdev.loader

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.aafdev.loader.di.appModule

class LoaderApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@LoaderApplication)
            modules(appModule)
        }
    }
}