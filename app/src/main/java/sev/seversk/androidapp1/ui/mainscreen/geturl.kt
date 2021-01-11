package sev.seversk.androidapp1.ui.mainscreen

import android.annotation.SuppressLint
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class geturl {

    val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
    val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"


    val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()


    fun getUrl() {

        val okHttpClient: OkHttpClient = OkHttpClient()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {


                val tex1: String = JSONArray(request).getJSONObject(0).getString("url")


            }
        })
    }
}
