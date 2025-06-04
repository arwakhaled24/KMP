package com.example.lab1

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import sqldelight.articles.db.ArticlesDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(ArticlesDatabase.Schema, "ArticlesDatabase.db")
    }
}
