package com.example.lab1

import com.example.lab1.article.ArticleRaw
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sqldelight.articles.db.ArticlesDatabase

class ArticleLocalDataSource(database: ArticlesDatabase) {
    private val queries = database.articlesDatabaseQueries

    suspend fun insertAll(articles: List<ArticleRaw>) {
        withContext(Dispatchers.Default) {
            queries.transaction {
                queries.removeAllArticles()
                articles.forEach {
                    queries.insertArticle(
                        title = it.title ?: "",
                        desc = it.description ?: "",
                        date = it.pubDate ?: "",
                        imgUrl = it.image_url
                    )
                }
            }
        }
    }

    suspend fun getAll(): List<ArticleRaw> {
        return withContext(Dispatchers.Default) {
            queries.selectAllArticles()
                .executeAsList()
                .map {
                    ArticleRaw(
                        title = it.title ,
                        description = it.desc,
                        pubDate = it.date,
                        image_url = it.imgUrl

                    )
                }
        }
    }
}
