package com.example.libreriaarboldefuegodemo.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libreriaarboldefuegodemo.Fragments.CatalogoFragment
import com.example.libreriaarboldefuegodemo.Model.Book
import com.example.libreriaarboldefuegodemo.R
import com.squareup.picasso.Picasso

import android.widget.Toast


class HomeFragmentAdapter(val context: Context, private val books:List<Book>) : RecyclerView.Adapter<HomeFragmentAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookImage:ImageView = view.findViewById(R.id.iv_review_image)
        val bookTitle:TextView = view.findViewById(R.id.tv_review_title)
        val bookComment:TextView = view.findViewById(R.id.tv_review_comment)
        val bookscore:RatingBar = view.findViewById(R.id.rb_review_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeFragmentAdapter.BookViewHolder, position: Int) {
        val libro = books[position]
        holder.bookTitle.text = libro.title
        holder.bookComment.text = libro.description
        holder.bookscore.rating = libro.rating
        Picasso.get().load(libro.coverImageUrl).into(holder.bookImage)

        val titleBook = libro.title
        val descriptionBook = libro.description
        val scoreBook = libro.rating

        holder.itemView.setOnClickListener {
            //VALIDANDO QUE HAY INFORMACION EN LOS CAMPOS
            if (!titleBook.isBlank() && !descriptionBook.isBlank() && scoreBook.toString() != ""){
                val intentComment = Intent(context, CatalogoFragment::class.java)
                intentComment.putExtra("id", libro.id)
                intentComment.putExtra("title", libro.title)
                intentComment.putExtra("description", libro.description)
                intentComment.putExtra("cover", libro.coverImageUrl)
                intentComment.putExtra("rating", libro.rating)
                context.startActivity(intentComment)
                Toast.makeText(context,"Texto de prueba del Libro", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "No hay datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = books.size
}