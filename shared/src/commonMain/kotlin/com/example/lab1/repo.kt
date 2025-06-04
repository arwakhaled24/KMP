package com.example.lab1

import com.example.lab1.article.ArticleRaw
import com.example.lab1.network.ArticlesService

class ArticleRepository(
    private val service: ArticlesService,
    private val localDataSource: ArticleLocalDataSource
) {
    suspend fun getArticles(): List<ArticleRaw> {
        val cachedArticles = localDataSource.getAll()
        println("data size = ${cachedArticles.size} ")
        return if (cachedArticles.isNotEmpty()) {
            println("data from database")
            cachedArticles
        } else {
            try {
                println("data from Api")

                val articles = service.fetchArticles()
                localDataSource.insertAll(articles)
                articles
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    /*  suspend fun getArticles(): List<ArticleRaw> {
          return try {
              val articles = service.fetchArticles()
              localDataSource.insertAll(articles)
              articles
          } catch (e: Exception) {
              localDataSource.getAll()
          }
      }*/
}
