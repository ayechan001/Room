package com.ac.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ac.roomdatabase.dao.BookDao
import com.ac.roomdatabase.model.Book

@Database(entities = [(Book::class)],version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDao

    companion object{
        private var INSTANCCE: BookDatabase? = null
        fun getDatabase(context: Context): BookDatabase {
            val temInstance = INSTANCCE
            if (temInstance != null){
                return temInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context,BookDatabase::class.java,"ProductDB").build()
                INSTANCCE=instance
                return instance
            }
        }
    }

}