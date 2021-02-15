package sev.seversk.androidapp1.remont

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide
import com.liftric.kvault.KVault
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.yandex_maps
import java.io.IOException

class utilities_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utilities_details)

        findViewById<ImageButton>(R.id.button_closeact).setOnClickListener(){
            finish()
        }

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        val intent2 = intent?.extras
        val position = intent2?.get("position").toString().toInt()
        val title = intent2?.get("title").toString()
        val location = intent2?.get("location").toString()
        val service = intent2?.get("service").toString()
        val dateP = intent2?.get("dateP").toString()
        val dateF = intent2?.get("dateF").toString()
        val comm = intent2?.get("comment").toString()

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/utilities"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token2).build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val json1 = response.body()?.string()
                val coords: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("coords")
                val latitude = coords.getJSONObject(0).getString("latitude")
                val longitude = coords.getJSONObject(0).getString("longitude")


//                findViewById<Button>(R.id.button_szodetail_tomap).setOnClickListener {
//                    val intent = Intent(this@utilities_details, yandex_maps::class.java)
//                    intent.putExtra("lat", latitude)
//                    intent.putExtra("long", longitude)
//                    startActivity(intent)
//                }

                runOnUiThread {
                    findViewById<TextView>(R.id.text_util_locationdet).text = location
                    findViewById<TextView>(R.id.text_util_title).text = title
                    findViewById<TextView>(R.id.text_util_service).text = service
                    findViewById<TextView>(R.id.text_util_dateplandet).text = dateP
                    findViewById<TextView>(R.id.text_util_datefactdet).text = dateF
                    findViewById<TextView>(R.id.text_util_comment).text = comm

                }
            }


        })

    }
}