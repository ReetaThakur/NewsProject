package com.example.newsproject.ui

import com.example.newsproject.response.Article

interface NewsListner {

    fun newsClick(article: Article)
}