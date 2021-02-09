package sev.seversk.androidapp1.emergency

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_szo.*
import kotlinx.android.synthetic.main.activity_szo_details.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.w3c.dom.Text
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.szo
import sev.seversk.androidapp1.yandex_maps
import java.io.IOException

class szo_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_szo_details)

        val intent2 = intent.extras
        findViewById<TextView>(R.id.text_szodet_address).text = intent2?.get("address").toString()
        findViewById<TextView>(R.id.text_szodet_site).text = intent2?.get("site").toString()
        findViewById<TextView>(R.id.text_szodet_mail).text = intent2?.get("email").toString()
        val imagev = findViewById<ImageView>(R.id.image_szodetail_employer)


        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"


        val position = intent2?.get("position").toString().toInt()

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/szo"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token2).build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val json1 = response.body()?.string()
                val employeers: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("employees")
                val phonenumbers: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("phones")
                val coords: JSONArray = JSONArray(json1).getJSONObject(position).getJSONArray("coords")

                val phones = phonenumbers.toString().replace("[","").replace("]", "").replace("\"", "")
                val name = employeers.getJSONObject(0).getString("name")
                val emplpos = employeers.getJSONObject(0).getString("position")
                val photoempl = employeers.getJSONObject(0).getString("photo")
                val latitude = coords.getJSONObject(0).getString("latitude")
                val longitude = coords.getJSONObject(0).getString("longitude")


                findViewById<Button>(R.id.button_szodetail_tomap).setOnClickListener {
                    val intent = Intent(this@szo_details, yandex_maps::class.java)
                    intent.putExtra("lat", latitude)
                    intent.putExtra("long", longitude)
                    startActivity(intent)
                }

                runOnUiThread {
                    findViewById<TextView>(R.id.text_szodet_phones).text = phones
                    findViewById<TextView>(R.id.text_szodet_name_employer).text = name
                    findViewById<TextView>(R.id.text_szodet_state_employer).text = emplpos

                    Glide.with(applicationContext).load(photoempl).centerCrop().into(imagev)

                }
            }


        })






        findViewById<ImageButton>(R.id.button_szo_details_back).setOnClickListener {
            val intent = Intent (this, szo::class.java)
            startActivity(intent)
        }
    }
}