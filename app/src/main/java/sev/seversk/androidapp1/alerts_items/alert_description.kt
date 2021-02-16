package sev.seversk.androidapp1.alerts_items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import sev.seversk.androidapp1.R

class alert_description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_description)

        findViewById<ImageView>(R.id.button_backtoalert).setOnClickListener(){
            finish()
        }

        val intent2 = intent.extras
        val title = intent2?.get("title").toString()
        val desc = intent2?.get("desc").toString()
//        val emerg = intent2?.get("emerg").toString()
        val create = intent2?.get("create").toString()
        val update = intent2?.get("update").toString()

        findViewById<TextView>(R.id.text_alertdet_text).text = title
        findViewById<TextView>(R.id.text_alertdet_descr).text = desc
        findViewById<TextView>(R.id.text_alertdet_emerg).text = "Оповещения"
        findViewById<TextView>(R.id.text_alertdet_create).text = ("Опубликовано: "+create)
        findViewById<TextView>(R.id.text_alerdet_update).text = ("Последнее изменение: "+update)
        findViewById<TextView>(R.id.text_alertdet_author).text = "ЕДДС ЗАТО Северск"

    }
}