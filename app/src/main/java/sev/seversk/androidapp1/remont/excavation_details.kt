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

class excavation_details : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excavation_details)


        val butmap = findViewById<Button>(R.id.button5)
        findViewById<ImageButton>(R.id.button_closeact3).setOnClickListener(){
            finish()
        }

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        val intent2 = intent?.extras
        val position = intent2?.get("position").toString().toInt()
        val dateorder = intent2?.get("dateorder").toString()
        val numberorder = intent2?.get("numberorder").toString()
        val renewal = intent2?.get("renewal").toString()
        val customer = intent2?.get("customer").toString()
        val contact = intent2?.get("contact").toString()
        val contactposition = intent2?.get("contactposition").toString()
        val contactphone = intent2?.get("contactphone").toString()
        val location = intent2?.get("location").toString()
        val start = intent2?.get("start").toString()
        val finish = intent2?.get("finish").toString()
        val comm = intent2?.get("comment").toString()
        val type = intent2?.get("type").toString()
        val nature = intent2?.get("nature").toString()

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

                  butmap.setOnClickListener {
                        val intent = Intent(this@excavation_details, yandex_maps::class.java)
                        intent.putExtra("lat", latitude)
                        intent.putExtra("long", longitude)
                        startActivity(intent)
                    }
                } else {

                }


                runOnUiThread {
                    findViewById<TextView>(R.id.text_excdet_title).text = ("$nature"+" "+"$type")
                    findViewById<TextView>(R.id.text_excdet_dateorder).text = dateorder
                    findViewById<TextView>(R.id.text_excdet_numberorder).text = numberorder
                    findViewById<TextView>(R.id.text_excdet_renewal).text = renewal
                    findViewById<TextView>(R.id.text_excdet_customer).text = customer
                    findViewById<TextView>(R.id.text_excdet_contact).text = contact
                    findViewById<TextView>(R.id.text_excdet_contactposition).text = contactposition
                    findViewById<TextView>(R.id.text_excdet_contactphone).text = contactphone
                    findViewById<TextView>(R.id.text_excdet_location).text = location
                    findViewById<TextView>(R.id.text_excdet_start).text = start
                    findViewById<TextView>(R.id.text_excdet_finish).text = finish
                    findViewById<TextView>(R.id.text_excdet_comment).text = comm

                }
            }


        })



    }
    }
