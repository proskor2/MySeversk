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
import com.example.androidapp1.data.opros_adapter
import com.example.androidapp1.data.opros_data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_seversk_news.*
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class opros : AppCompatActivity(), opros_adapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_opros)
    }


    @Override
    override fun onStart() {
        super.onStart()

        runOnUiThread() {

            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
            val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/questionnaires"
            var okHttpClient: OkHttpClient = OkHttpClient()
            val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()
            val response = okHttpClient.newCall(request).execute()
            val json = response.body()?.string()

            fun generateDummyList(size: Int): ArrayList<opros_data> {
                val list = ArrayList<opros_data>()

                for (i in 0..9) {
                    val text_title1: String = JSONArray(json).getJSONObject(i).getString("name_questionnaire")
                    val text_status1: String = JSONArray(json).getJSONObject(i).getString("status")


                    list.add(i, opros_data("$text_title1", "$text_status1"))
                }
                return list
            }
            val exampleList = generateDummyList(1)
            val adapter = opros_adapter(exampleList, this)
           recycler_opros.adapter = adapter
               recycler_opros.layoutManager = LinearLayoutManager(this)
            recycler_opros.setHasFixedSize(true)
        }
    }

    override fun onItemClick(position: Int) {

        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()


    }
}


