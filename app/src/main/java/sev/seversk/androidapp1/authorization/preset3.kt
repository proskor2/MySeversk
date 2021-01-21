package sev.seversk.androidapp1.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import sev.seversk.androidapp1.R

class preset3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset3)

        val intent = intent.extras
        val getName = intent?.getString("names")
        val getDate = intent?.getString("date")


        findViewById<Button>(R.id.button_preset3_next).setOnClickListener(){

            val gender = findViewById<RadioGroup>(R.id.gender)
            val genderid = gender.checkedRadioButtonId

            if (genderid != -1) {
                val radio: RadioButton = findViewById(genderid)
                val string: String = radio.text.toString()
                Toast.makeText(this, "$string", Toast.LENGTH_LONG).show()

                val intent = Intent(this, seversk::class.java)
                intent.putExtra("gender", string)
                intent.putExtra("name", getName)
                intent.putExtra("date", getDate)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Не выбран", Toast.LENGTH_LONG).show()
            }


        }

        findViewById<Button>(R.id.button_preset3_back).setOnClickListener(){
            val intent = Intent(this, preset2::class.java)
            startActivity(intent)
        }
    }
}