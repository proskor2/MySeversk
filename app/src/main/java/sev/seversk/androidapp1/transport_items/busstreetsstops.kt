package sev.seversk.androidapp1.transport_items

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import sev.seversk.androidapp1.R

class busstreetsstops : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busstreetsstops)

        val buttonforward = findViewById<Button>(R.id.button_busstreets_forward)
        val buttonback = findViewById<Button>(R.id.button_busstreets_back)
        val buttonleft = findViewById<ImageButton>(R.id.button_left)


        val intent2 = intent?.extras
        val ssF = intent2?.get("streetF")
        val ssB = intent2?.get("streetB")
        val title = intent2?.get("title")
        val ssf2 = listOf("ул.Трудовая", "ул.Лесная", "ул.Первомайская", "пр.Коммунистический", "пр.Коммунистический (кольцо на въезде в город)", "ул.Победы", "пр.Коммунистический (кольцо на въезде в город)", "ул.Восточная", "ул.Калинина", "ул.Солнечная", "Северная автомагистраль", "ул.Сосновая")
            buttonforward.setOnClickListener {

        }

            buttonback.setOnClickListener {

        }

        buttonleft.setOnClickListener {
            finish()
        }


         val title2 = findViewById<TextView>(R.id.text_busstreetsstops_title)
        val textv =  findViewById<TextView>(R.id.text_busstreetsstops)

        title2.text = title.toString()
        textv.text = ssF.toString()

        findViewById<ListView>(R.id.liststreets)
    }
}