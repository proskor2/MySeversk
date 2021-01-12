package sev.seversk.androidapp1.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.seversk
import kotlinx.android.synthetic.main.activity_profile_settings.*
import sev.seversk.androidapp1.ui.profilescreen.NotificationFragment

class profile_settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)
// button change screen settings to main screen
        button_profilesettings_back.setOnClickListener(){
            val back = Intent(this@profile_settings, NotificationFragment::class.java)
            startActivity(back)
            finish()
        }
// button change screen settings to detals settings screen
        button_profile1_change.setOnClickListener(){
            val change1 = Intent(this@profile_settings, prodile_settings2::class.java)
            startActivity(change1)
        }
// get data from settings2 activity

        profile_name_settings.text = ("Имя: "+intent.getStringExtra("name"))
        profile_surname_settings.text = ("Фамилия: "+intent.getStringExtra("surname"))
        profile_phone_settings.text = ("Телефон: "+intent.getStringExtra("phonenum"))

    }

    override fun onSaveInstanceState(outState: Bundle) {


        super.onSaveInstanceState(outState)
    }
}