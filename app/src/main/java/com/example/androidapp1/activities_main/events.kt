package com.example.androidapp1.activities_main

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.text.Html
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp1.R
import com.example.androidapp1.data.News_adapter
import com.example.androidapp1.data.News_data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_seversk_events.*
import kotlinx.android.synthetic.main.activity_seversk_news.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class events : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_events)
    }
}
//        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
//
//        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/afisha?page=1&per-page=5"
//        var okHttpClient: OkHttpClient = OkHttpClient()
//
//        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()



//    @Override
//    override fun onStart() {
//        super.onStart()
//
//        runOnUiThread() {
//
//            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
//            StrictMode.setThreadPolicy(policy)
//
//            val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
//            val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/afisha?page=1&per-page=5"
//            var okHttpClient: OkHttpClient = OkHttpClient()
//            val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()
//            val response = okHttpClient.newCall(request).execute()
//            val json = response.body()?.string()
//
//            fun generateDummyList(size: Int): ArrayList<News_data> {
//                val list = ArrayList<News_data>()
//
//                for (i in 0..9) {
////                    val text_title1: String = JSONArray(json).getJSONObject(i).getString("title")
////                    val text_preview1: String = JSONArray(json).getJSONObject(i).getString("preview")
////                    val drawable: String = JSONArray(json).getJSONObject(i).getString("photo")
//
////                    list.add(i, News_data("$text_title1", "$text_preview1", Uri.parse("https://"+"$drawable")))
//                }
//                return list
//            }
//            val exampleList = generateDummyList(1)
//            val adapter = News_adapter(exampleList, this)
//            recylcer_news.adapter = adapter
//            recylcer_news.layoutManager = LinearLayoutManager(this)
//            recylcer_news.setHasFixedSize(true)
//        }
//    }
//
//    override fun onItemClick(position: Int) {
//
//        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
//
//
//    }
//}