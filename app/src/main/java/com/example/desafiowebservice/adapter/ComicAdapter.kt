package com.example.desafiowebservice.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiowebservice.R
import com.example.desafiowebservice.entities.Comic
import com.example.desafiowebservice.ui.ComicDetail
import kotlinx.android.synthetic.main.card_comics.view.*
import org.w3c.dom.Text
import java.util.concurrent.RecursiveAction

class ComicAdapter () :RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    var listComics = arrayListOf<Comic>()

    class ComicViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ivComics : ImageView = itemView.ivComics
        val tvComics : TextView = itemView.tvComics
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.card_comics, parent, false)
        return ComicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = listComics[position]

        holder.tvComics.text = "#${comic.id}"
        if (comic.images.isNullOrEmpty()){
            holder.ivComics.setImageResource(R.drawable.not_found)
        } else {
            Glide.with(holder.ivComics.context).asBitmap()
                    .load(comic.images.first().toString())
                    .into(holder.ivComics)
        }
        holder.ivComics.setOnClickListener{
            var intent = Intent(it.context,ComicDetail::class.java)
            intent.putExtra("comic",comic)
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount() = listComics.size

    fun addComic(list: ArrayList<Comic>){
        listComics.addAll(list)
        notifyDataSetChanged()
    }
}