package sev.seversk.androidapp1.activities_main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_seversk_events.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class events : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_events)
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

"date": "01.09.2020",

"title": "1 сентября - День знаний"

}]
""".trimIndent()
                val tex1: String = JSONArray(json).getJSONObject(0).getString("title")
                val tex2: String = JSONArray(json).getJSONObject(0).getString("date")


                runOnUiThread() {
                    text_event1?.text = tex1
                    text_event2?.text = tex2
                    image_events1.setImageResource(R.drawable.city1)
                }
            }

        })
    }
}
