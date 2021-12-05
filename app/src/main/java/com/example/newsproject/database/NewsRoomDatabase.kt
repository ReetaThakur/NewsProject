package com.example.newsproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsDbTable::class], version = 1)
abstract class NewsRoomDatabase():RoomDatabase() {

    abstract fun getDao(): NewsDao

    companion object {
       private var INSTANCE: NewsRoomDatabase? = null

        fun getDatabaseObject(context: Context): NewsRoomDatabase {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, NewsRoomDatabase::class.java, "news_database").build()
                return INSTANCE!!
            }else  return INSTANCE!!

        }
    }
}