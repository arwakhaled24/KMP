package com.example.lab1.article

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val title: String?,
    val description: String?,
    val pubDate: String?,
    val image_url: String?
)

@Serializable
data class ArticlesResponse(
    val status: String,
    val totalResults: Int?=0,
    val results: List<ArticleRaw>?= emptyList()
)