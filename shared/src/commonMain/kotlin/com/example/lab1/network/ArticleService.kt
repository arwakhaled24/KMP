package com.example.lab1.network

import com.example.lab1.article.ArticleRaw
import com.example.lab1.article.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter


class ArticlesService(private val httpClient: HttpClient) {
    companion object {
        private const val API_KEY = "pub_d76700d58e584044827455844021b367"
        private const val BASE_URL = "https://newsdata.io/api/1/latest"
        private const val DEFAULT_QUERY = "apple"
    }

    suspend fun fetchArticles(query: String = DEFAULT_QUERY): List<ArticleRaw> {
        return try {
            val response: ArticlesResponse = httpClient.get(BASE_URL) {
                parameter("apikey", API_KEY)
                parameter("q", query)
            }.body()
            println("ttttttttttttttttttttttttttttttttttttttttttttttttt")
            println("Error fetching articles: ${response}")
            response.results ?: emptyList()
        } catch (e: Exception) {
            println("Error fetching articles: ${e.message}")
            emptyList()
        }
    }
}
