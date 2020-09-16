package com.ac.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ac.roomdatabase.model.Book

@Dao
interface BookDao {
    @Query(value = "Select * from product ORDER BY product_id ASC")
    fun getALLProduct(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(book: Book)

    @Query(value = "DELETE FROM product WHERE product_id=:id")
    fun deleteProduct(id : String)
}