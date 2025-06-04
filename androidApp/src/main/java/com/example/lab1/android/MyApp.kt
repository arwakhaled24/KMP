package com.example.lab1.android

import android.app.Application
import com.example.lab1.android.di.modules.databaseModule
import com.example.lab1.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ArticleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArticleApplication)
            modules(sharedKoinModule + viewModelModule + databaseModule)
        }
    }
}
