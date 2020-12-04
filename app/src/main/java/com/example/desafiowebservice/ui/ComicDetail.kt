package com.example.desafiowebservice.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafiowebservice.R
import com.example.desafiowebservice.entities.Comic
import kotlinx.android.synthetic.main.activity_comic_detail.*
import kotlin.to

class ComicDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_detail)
        setSupportActionBar(toolbarComic)

        val comic = intent.getSerializableExtra("comic") as Comic

        tvComicsDetailName.text=comic.title

        when {
            comic.description.isNullOrEmpty() && comic.text.isNullOrEmpty() -> {
                tvComicsDetailDesc.text = "DESCRIPTION NOT FOUND"
            }
            comic.description.isNullOrEmpty() -> {
                tvComicsDetailDesc.text = comic.text.first().text
            }
            else -> {
                tvComicsDetailDesc.text = comic.description
            }
        }

        val publishDate = comic.dates.first().getComicDate()
        tvComicsDetailPublish.text = "Publish: $publishDate "
        tvComicsDetailPrice.text = "Price: $${comic.prices.first().price}"
        tvComicsDetailPages.text = "Pages: ${comic.pageCount.toString()}"
        if (comic.images.isNullOrEmpty()){
            ivComicsDetailBg.setImageResource(R.drawable.not_found)
        } else {
            Glide.with(this).asBitmap()
                .load(comic.images.first().toString())
                .into(ivComicsDetailBg)
        }
        if (comic.images.isNullOrEmpty()){
            ivComicsDetail.setImageResource(R.drawable.not_found)
        } else {
            Glide.with(this).asBitmap()
                .load(comic.images.first().toString())
                .into(ivComicsDetail)
        }

        ivComicsDetail.setOnClickListener {
            var intent = Intent(it.context,CoverDetail::class.java)
            intent.putExtra("comic",comic)
            it.context.startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}