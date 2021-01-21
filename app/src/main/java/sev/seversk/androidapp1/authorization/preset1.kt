package sev.seversk.androidapp1.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import sev.seversk.androidapp1.R

class preset1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset1)

        val getNameField = findViewById<EditText>(R.id.preset_name).text

        findViewById<Button>(R.id.button_preset1_next).setOnClickListener(){
            Toast.makeText(this, "$getNameField", Toast.LENGTH_LONG).show()
            val intent = Intent(this, preset2::class.java)
            intent.putExtra("name", getNameField)
            startActivity(intent)
        }
    }
}