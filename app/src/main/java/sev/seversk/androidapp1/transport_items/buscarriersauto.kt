package sev.seversk.androidapp1.transport_items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.TextView
import sev.seversk.androidapp1.R

class buscarriersauto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscarriersauto)

        findViewById<ImageButton>(R.id.button_left2).setOnClickListener {
            finish()
        }

        val intent2 = intent?.extras
        val title = intent2?.get("title")
        val info = intent2?.get("info").toString()

        findViewById<TextView>(R.id.buscarriersa_title).text = title.toString()
        findViewById<TextView>(R.id.text_buscarriresa).text = info

    }
}