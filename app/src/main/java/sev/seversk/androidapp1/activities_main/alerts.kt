package sev.seversk.androidapp1.activities_main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_alerts.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class alerts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)


        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/alerts?page=1&per-page=5"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {
                val json = response?.body()?.string()

//                val title1_al = JSONArray(json).getJSONObject(0).getString("title")
                val desc1_al: String = JSONArray(json).getJSONObject(0).getString("title")
                val upd_al: String = JSONArray(json).getJSONObject(0).getString("updated")



                runOnUiThread() {
//                    text_al1.text = Html.fromHtml(title1_al)
                    text_al2.text = Html.fromHtml(desc1_al)
                    text_al3.text = Html.fromHtml("Последнее обновление: "+upd_al)
                }
                }


        })
    }
}