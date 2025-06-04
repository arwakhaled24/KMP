package com.example.lab1.android.di.modules

import app.cash.sqldelight.db.SqlDriver
import com.example.lab1.ArticleLocalDataSource
import com.example.lab1.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import sqldelight.articles.db.ArticlesDatabase

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single { ArticlesDatabase(get()) }
    single { ArticleLocalDataSource(get()) }
}
