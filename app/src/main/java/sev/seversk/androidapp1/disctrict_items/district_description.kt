package sev.seversk.androidapp1.disctrict_items

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_district_description.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.yandex_maps
import java.io.IOException

class district_description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district_description)


        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        val intent2 = intent.extras
        val position = intent2?.get("position").toString().toInt()
        val area = intent2?.get("area").toString()
        val address = intent2?.get("addresses").toString()
        val number = intent2?.get("number").toString()

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/areas"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token2).build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val json1 = response.body()?.string()
                val areas: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("area")
                val deputies: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("deputies")
                val addresses: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("addresses")
                val coords: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("coords")

                if (deputies.length() > 0) {
                    val photo = deputies.getJSONObject(0)?.getString("photo")
                    val name = deputies.getJSONObject(0)?.getString("name")
                    val position = deputies.getJSONObject(0)?.getString("position")
                    val timetable = deputies.getJSONObject(0)?.getString("timetable")
                    val info = deputies.getJSONObject(0)?.getString("info")


//                findViewById<Button>(R.id.button_emergdetail_tomap).setOnClickListener {
//                    val intent = Intent(this@district_description, yandex_maps::class.java)
//                    intent.putExtra("lat", latitude)
//                    intent.putExtra("long", longitude)
//                    startActivity(intent)
//                }

                    runOnUiThread {
                        val imagev = findViewById<ImageView>(R.id.image_disrtictdescrpition)
                        findViewById<TextView>(R.id.text_disrtictdescrpition_number).text = number
                        findViewById<TextView>(R.id.text_disrtictdescrpition_streets).text = address
                        findViewById<TextView>(R.id.text_disrtictdescrpition_areas).text = area
                        findViewById<TextView>(R.id.text_disrtictdescrpition_name).text = name
                        findViewById<TextView>(R.id.text_disrtictdescrpition_position).text =
                            position
                        findViewById<TextView>(R.id.text_disrtictdescrpition_timetable).text =
                            timetable
                        findViewById<TextView>(R.id.text_disrtictdescrpition_about).text = info


                        Glide.with(applicationContext).load(photo).centerCrop().into(imagev)

                    }
                }
            }


        })

    }
}