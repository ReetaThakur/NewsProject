package com.example.newsproject.ui

import com.example.newsproject.response.ResponseDTO

sealed class MainUiModel(){

    data class onSuccess(val responseDTO: ResponseDTO) :MainUiModel()

    data class onFailure(val error:String) :MainUiModel()
}
