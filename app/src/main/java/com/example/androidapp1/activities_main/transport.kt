package com.example.androidapp1.activities_main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.androidapp1.R
import com.example.androidapp1.bus_detail
import kotlinx.android.synthetic.main.activity_seversk_transport.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class transport : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_transport)

        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/traffic"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {
                val json = response?.body()?.string()

                val txt = (JSONArray(json).get(0)).toString()
                val txt2 = JSONArray(json).getJSONObject(0).getString("title")
                val txt3: String = JSONArray(json).getJSONObject(0).getString("number")
                txt3.toInt()
                val txt4: String = JSONArray(json).getJSONObject(0).getString("length")
                val txt5: String = JSONArray(json).getJSONObject(0).getString("pitstop")
                val txt6: String = JSONArray(json).getJSONObject(0).getString("type")


                runOnUiThread(){
                    bus_numer.text = Html.fromHtml("Маршрут №"+txt3)
                    bus_lenght.text = Html.fromHtml("Протяженность: "+txt4)
                    bus_name.text = Html.fromHtml(txt2+"("+txt6+")")
                    bus_pitstop.text = Html.fromHtml("Конечные остановки: "+txt5)


                }
            }

        })

        cardbus.setOnClickListener(){
            val bus1 = Intent(this@transport, bus_detail::class.java)
            startActivity(bus1)
        }
    }
}
