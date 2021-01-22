package sev.seversk.androidapp1.emergency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.szo

class szo_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_szo_details)

        findViewById<ImageButton>(R.id.button_szo_details_back).setOnClickListener(){
            val intent = Intent (this, szo::class.java)
            startActivity(intent)
        }
    }
}