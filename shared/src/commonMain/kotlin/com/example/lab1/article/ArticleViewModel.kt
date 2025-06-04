package com.example.lab1.article

import com.example.lab1.ArticleRepository
import com.example.lab1.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    private var repo: ArticleRepository
) : BaseViewModel(){

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {

        getArticles()
    }

    private fun getArticles() {
        scope.launch {

            _articlesState.emit(ArticlesState(loading = true))

            delay(1000)

            _articlesState.emit(ArticlesState(error = "Something went wrong please try again later"))

            delay(1000)

            try {
                val fetchedArticles =repo.getArticles()
                _articlesState.emit(ArticlesState(articles = fetchedArticles))
            } catch (e: Exception) {
                _articlesState.emit(ArticlesState(error = "Error: ${e.message}"))
            }
        }
    }
}
