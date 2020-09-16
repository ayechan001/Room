package com.ac.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.ac.roomdatabase.dao.BookDao
import com.ac.roomdatabase.model.Book

class BookRepository(private val bookDao: BookDao) {
    val allproduct: LiveData<List<Book>> = bookDao.getALLProduct()
    suspend fun productInsert(book: Book){
        bookDao.insertProduct(book)
    }
    suspend fun deleteItem(name: String){
        bookDao.deleteProduct(name)
    }
}