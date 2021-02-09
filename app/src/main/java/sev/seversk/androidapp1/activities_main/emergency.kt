package sev.seversk.androidapp1.activities_main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_district.*
import kotlinx.android.synthetic.main.activity_emergency.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.disctrict_items.district_description

class emergency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)





        emergency_cityproblems.setOnClickListener {
                val intent = Intent(this@emergency, emergency_detail::class.java)
                startActivity(intent)
        }

        emergency_extrservice.setOnClickListener {
            val intent = Intent(this@emergency, emergency_detail::class.java)
            startActivity(intent)
        }
    }
}