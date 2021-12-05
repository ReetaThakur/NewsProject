package com.example.newsproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDataFrom(newsDbTable: NewsDbTable)

    @Query("select * from news_table")
    fun getResponseFromDb(): LiveData<NewsDbTable>

    @Query("delete from news_table")
    fun deleteAllDataFromDb()
}