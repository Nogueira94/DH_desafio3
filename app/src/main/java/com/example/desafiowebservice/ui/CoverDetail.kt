package com.example.desafiowebservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafiowebservice.R
import com.example.desafiowebservice.entities.Comic
import kotlinx.android.synthetic.main.activity_comic_detail.*
import kotlinx.android.synthetic.main.activity_cover_detail.*
import kotlinx.android.synthetic.main.activity_register.*

class CoverDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover_detail)
        setSupportActionBar(toolbarCoverDetail)

        val comic = intent.getSerializableExtra("comic") as Comic

        if (comic.images.isNullOrEmpty()){
            ivCoverDetail.setImageResource(R.drawable.not_found)
        } else {
            Glide.with(this).asBitmap()
                .load(comic.images.first().toString())
                .into(ivCoverDetail)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}