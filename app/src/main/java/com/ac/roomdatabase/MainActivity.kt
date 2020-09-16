package com.ac.roomdatabase

import android.app.Activity
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ac.roomdatabase.adapter.BookAdapter
import com.ac.roomdatabase.model.Book
import com.ac.roomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BookAdapter.ClickListener {

    private lateinit var bookViewModel: BookViewModel
    //private val addBookActivityRequestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bookAdapter=BookAdapter()
        firstrecycler.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=bookAdapter
        }
        bookViewModel=ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.allBook.observe(this, Observer {
            Log.d("books", it.toString())
            bookAdapter.addBookList(it)
        })
        btnAdd.setOnClickListener {


            if (TextUtils.isEmpty(ed1.text) && TextUtils.isEmpty(ed2.text) && TextUtils.isEmpty(ed3.text) && TextUtils.isEmpty(ed4.text)){
               Log.d("name","error")
            }else{
                var id=ed1.text.toString()
                var name=ed2.text.toString()
                var price=ed3.text.toString()
                var quantity=ed4.text.toString()
                var product = Book(id.toInt(),name.toString(),price.toDouble(),quantity.toInt())
                Log.d("book", product.toString())
                bookViewModel=ViewModelProviders.of(this).get(BookViewModel::class.java)
                bookViewModel.insert(product)
                bookViewModel.allBook.observe(this, Observer {
                   Log.d("books", it.toString())
                    bookAdapter.addBookList(it)
                })


            }
            bookAdapter.setOnClickListener(this)
        }

    }

    override fun onClick(book: Book) {
       val builder = AlertDialog.Builder(this)

    }
}