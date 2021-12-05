package com.example.newsproject.repository

import com.example.newsproject.response.Network
import com.example.newsproject.response.ResponseDTO
import java.net.NoRouteToHostException

class Repository {

   suspend fun getNews():ResponseDTO{
        return Network.getService().getInstance(Network.country,Network.apiKey)
    }
}