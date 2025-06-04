package com.example.lab1.article

data class ArticlesState(
    val articles: List<ArticleRaw> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)