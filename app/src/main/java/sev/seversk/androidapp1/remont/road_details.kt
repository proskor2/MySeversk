package sev.seversk.androidapp1.remont

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.liftric.kvault.KVault
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.yandex_maps
import java.io.IOException

class road_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remont_details)

        findViewById<ImageButton>(R.id.button_closeact2).setOnClickListener(){
            finish()
        }

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        val intent2 = intent?.extras
        val position = intent2?.get("position").toString().toInt()
        val title = intent2?.get("title").toString()
        val area = intent2?.get("area").toString()
        val cost = intent2?.get("cost").toString()
        val dateb = intent2?.get("datebegin").toString()
        val datee = intent2?.get("dateend").toString()
        val length = intent2?.get("length").toString()
        val start = intent2?.get("start").toString()
        val finish = intent2?.get("finish").toString()

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/roads"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token2).build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val json1 = response.body()?.string()
                val coords: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("coords")
                if (coords.length() > 0) {
                    val latitude = coords.getJSONObject(0).getString("latitude")
                    val longitude = coords.getJSONObject(0).getString("longitude")

                    findViewById<Button>(R.id.button4).setOnClickListener {
                        val intent = Intent(this@road_details, yandex_maps::class.java)
                        intent.putExtra("lat", latitude)
                        intent.putExtra("long", longitude)
                        startActivity(intent)
                    }

                } else {

                }


                runOnUiThread {
                    findViewById<TextView>(R.id.text_roaddet_title).text = title
                    findViewById<TextView>(R.id.text_roaddet_area).text = area
                    findViewById<TextView>(R.id.text_roaddet_start).text = start
                    findViewById<TextView>(R.id.text_roaddet_finish).text = finish
                    findViewById<TextView>(R.id.text_roaddet_datebegin).text = dateb
                    findViewById<TextView>(R.id.text_roaddet_dateend).text = datee
                    findViewById<TextView>(R.id.text_roaddet_cost).text = cost
                    findViewById<TextView>(R.id.text_roaddet_length).text = length
                    findViewById<TextView>(R.id.text_roaddet_start).text = start
                    findViewById<TextView>(R.id.text_roaddet_finish).text = finish



                }
            }


        })

    }

    }
