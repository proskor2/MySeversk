package com.example.androidapp1.activities_main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.androidapp1.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_problem.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class problem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem)

        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/treatments?page=1&per-page=5"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {
                val json = response?.body()?.string()

                val title1_pr = JSONArray(json).getJSONObject(1).getString("title")
                val desc1_pr: String = JSONArray(json).getJSONObject(1).getString("description")
                val upd_pr: String = JSONArray(json).getJSONObject(1).getString("updated")
                val user_pr: String = JSONArray(json).getJSONObject(1).getString("user")
                val status_pr: String = JSONArray(json).getJSONObject(1).getString("status")
                val photo_pr: String = JSONArray(json).getJSONObject(1).getString("photo")



                runOnUiThread() {
                   textpr_title.text = Html.fromHtml(title1_pr)
                   textpr_descr.text = Html.fromHtml(desc1_pr)
                    textpr_status.text = Html.fromHtml(status_pr)
                    textpr_user.text = Html.fromHtml(user_pr)

                    val image = Picasso.get().load("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai"+(photo_pr)).into(imageView_pr)
                }
            }


        })
    }
}