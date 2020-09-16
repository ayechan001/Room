package com.ac.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ac.roomdatabase.database.BookDatabase
import com.ac.roomdatabase.model.Book
import com.ac.roomdatabase.repository.BookRepository
import kotlinx.coroutines.launch


class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BookRepository
    val allBook : LiveData<List<Book>>

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        repository = BookRepository(bookDao)
        allBook = repository.allproduct
    }
    fun insert(book: Book) = viewModelScope.launch {
        repository.productInsert(book)
    }
    fun deleteItem(id: String) = viewModelScope.launch {
        repository.deleteItem(id)
    }
}