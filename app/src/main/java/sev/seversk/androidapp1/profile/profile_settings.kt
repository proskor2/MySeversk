package sev.seversk.androidapp1.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.liftric.kvault.KVault
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.seversk
import kotlinx.android.synthetic.main.activity_profile_settings.*
import kotlinx.android.synthetic.main.activity_seversk.*

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
            val back = Intent(this@profile_settings, seversk::class.java)
            startActivity(back)
            finish()
        }
// button change screen settings to detals settings screen
        button_profile1_change.setOnClickListener {
            val intent = Intent(this, newprofileset3::class.java)
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        val cardname = sharedPreferences?.getString("name", " ")
        val cardsurname = sharedPreferences?.getString("surname", " ")
        val cardphone = sharedPreferences?.getString("phone", " ")

// get data from settings2 activity

        profile_name_settings.text = ("Имя: "+cardname)
        profile_surname_settings.text = ("Фамилия: "+cardsurname)
        profile_phone_settings.text = ("Телефон: "+cardphone)

    }


}