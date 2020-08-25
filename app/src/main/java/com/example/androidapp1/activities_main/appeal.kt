package com.example.androidapp1.activities_main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp1.R
import kotlinx.android.synthetic.main.activity_appeal.*
import kotlinx.android.synthetic.main.fragment_problems.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class appeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appeal)
    }
        override fun onStart() {
            super.onStart()

            val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
            val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"
            var okHttpClient: OkHttpClient = OkHttpClient()

            val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()

            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                @SuppressLint("WrongConstant")
                override fun onResponse(call: Call, response: Response) {
//                    val json = response?.body()?.string()

                    val json = """
    [{
"id": 130,
"code": "35805-88258-68181",
"dateBegin": "22.01.2018",
"dateEnd": "22.12.2018",
"status": "Обработана",
"surname": "Прошенкин",
"name": "Станислав",
"patronymic": "Александрович",
"social_status": "Другое",
"title": "Обустроить цветочные клумбы во дворе дома № 15",
"text": "От 2 гимназии, вдоль забора до пешеходной тропы, заросшие кусты, ...",
"comments_count": "",
"followers_count": "",
"files": [""]
}]
""".trimIndent()
                    val tex1: String = JSONArray(json).getJSONObject(0).getString("title")
                    val tex2: String = JSONArray(json).getJSONObject(0).getString("status")
                    val tex3: String = JSONArray(json).getJSONObject(0).getString("text")

                    runOnUiThread() {
                        text_appeal_title?.text = tex1
                        text_appeal_status?.text = tex2
                        text_appeal_descr?.text = tex3
                    }
                }

            })
        }
    }
