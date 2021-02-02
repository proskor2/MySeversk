package sev.seversk.androidapp1.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import sev.seversk.androidapp1.R

class privacy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        val intent = intent.extras
        val getString = intent?.get("string")

        findViewById<TextView>(R.id.privacy_text).setText(getString.toString())

        findViewById<Button>(R.id.button_privacy_back).setOnClickListener(){
            val intent = Intent(this, preset2::class.java)
            startActivity(intent)
            finish()
        }
    }
}