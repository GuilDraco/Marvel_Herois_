package com.updeveloped.marvelheroes.views

import android.app.Application
import com.updeveloped.marvelheroes.modules.DataModule
import com.updeveloped.marvelheroes.modules.repositoryModule
import com.updeveloped.marvelheroes.modules.uiModule
import com.updeveloped.marvelheroes.modules.viewModelModule


import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinConfig()
    }

    private fun startKoinConfig(){
        startKoin {
            androidContext(this@AppApplication)
            DataModule.load()
            modules(
                listOf(
                    viewModelModule,
                    repositoryModule,
                    uiModule
                )
            )
        }
    }
}