package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.liftric.kvault.KVault
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.seversk
import kotlinx.android.synthetic.main.activity_profile_settings.*
import kotlinx.android.synthetic.main.activity_seversk.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class profile_settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        val kVault = KVault(context = applicationContext)


        findViewById<CardView>(R.id.card_settings_notification).setOnClickListener {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
        }

        findViewById<CardView>(R.id.card_settings_conf).setOnClickListener {
            Toast.makeText(this, "Confidential", Toast.LENGTH_SHORT).show()
        }

        findViewById<CardView>(R.id.card_settings_memory).setOnClickListener {
            Toast.makeText(this, "Memory", Toast.LENGTH_SHORT).show()
        }

        findViewById<CardView>(R.id.card_settings_logout).setOnClickListener {
            val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.clear()?.apply()

            FirebaseAuth.getInstance().signOut()

            kVault.clear()
            val intent = Intent(this, sev.seversk.androidapp1.authorization.startActivity::class.java)
            startActivity(intent)
        }

// button change screen settings to main screen
        button_profilesettings_back.setOnClickListener {
//            val back = Intent(this@profile_settings, seversk::class.java)
//            startActivity(back)
            finish()
        }
 // set avatar

        val imview = findViewById<ImageView>(R.id.image_avatar)

        val getstring = KVault(context = applicationContext)
        val newtoken = getstring.string("TOKEN")

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/profile/get"

        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",
            "Bearer " + newtoken).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {

                val json = response.body()?.string()
                val parentObject = JSONObject(json)

                val javatar = parentObject.getString("avatar")
                val jname = parentObject.getString("firstName")
                val jsurname = parentObject.getString("lastName")
                val jphone = parentObject.getString("phonenumber")


                runOnUiThread {

                    if (jname != "null")   profile_name_settings.text = ("Имя: "+ jname) else profile_name_settings.text = ("Имя: ")
                    if (jsurname != "null")   profile_surname_settings.text = ("Фамилия: "+ jsurname) else profile_surname_settings.text = ("Фамилия: ")
                    profile_phone_settings.text = ("Телефон: "+ jphone)

                    Glide.with(applicationContext)
                        .load(javatar)
                        .into(imview)
                }
            }
        })


// button change screen settings to detals settings screen
        button_profile1_change.setOnClickListener {
            val intent = Intent(this, newprofileset3::class.java)
            startActivity(intent)
        }

//        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
//        val editor = sharedPreferences?.edit()
//        val cardname = sharedPreferences?.getString("name", " ")
//        val cardsurname = sharedPreferences?.getString("surname", " ")
//        val cardphone = sharedPreferences?.getString("phone", " ")

// get data from settings2 activity

//        profile_name_settings.text = ("Имя: "+cardname)
//        profile_surname_settings.text = ("Фамилия: "+cardsurname)
//        profile_phone_settings.text = ("Телефон: "+cardphone)

    }


}