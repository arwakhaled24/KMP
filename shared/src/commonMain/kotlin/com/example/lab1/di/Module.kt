package com.example.lab1.di

import com.example.lab1.ArticleRepository
import com.example.lab1.article.ArticleViewModel
import com.example.lab1.network.ArticlesService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}

val articleModule = module {
    single { ArticlesService(get()) }
    single { ArticleRepository(get(), get()) }
    single { ArticleViewModel(get()) }
}

val sharedKoinModule = listOf(networkModule, articleModule)
