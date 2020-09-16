package com.ac.roomdatabase.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ac.roomdatabase.R
import com.ac.roomdatabase.model.Book
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    private var mClickListener: ClickListener?= null
    private var books= emptyList<Book>()
    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener=clickListener
    }
inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
   init {
       itemView.setOnClickListener(this)
   }
    lateinit var book:Book
    fun bind(book: Book){
        this.book=book
        itemView.e1.text= book.id.toString()
        itemView.e2.text=book.name
        itemView.e3.text=book.price.toString()
        itemView.e4.text=book.quantity.toString()
    }

    override fun onClick(p0: View?) {
        mClickListener?.onClick(book)
    }
}

    fun addBookList(bookList: List<Book>){

        this.books=bookList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("/", books.size.toString())
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }
    interface ClickListener{
        fun onClick(book: Book)
    }
}