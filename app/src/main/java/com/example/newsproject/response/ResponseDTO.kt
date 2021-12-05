package com.example.newsproject.response

data class ResponseDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)