package com.example.newsproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsproject.repository.Repository

class NewsViewModel():ViewModel() {

    val repository=Repository()

   private val mutableLiveData =MutableLiveData<MainUiModel>()
     val liveData:LiveData<MainUiModel> = mutableLiveData

    suspend fun callApi(){
        val responseDTO=repository.getNews()
        if (responseDTO!=null){
            mutableLiveData.postValue(MainUiModel.onSuccess(responseDTO))
        }else{
            mutableLiveData.postValue(MainUiModel.onFailure("Error"))
        }
    }


}