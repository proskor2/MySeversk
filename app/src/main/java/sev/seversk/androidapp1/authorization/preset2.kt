package sev.seversk.androidapp1.authorization

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import sev.seversk.androidapp1.R
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class preset2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset2)

        val intent = intent.extras
        val getName2 = intent?.get("names")

        val datePicker = findViewById<DatePicker>(R.id.datePicker)


        findViewById<Button>(R.id.button_preset2_next).setOnClickListener(){
            val date = getDate(datePicker)

            Toast.makeText(this, date.toString(), Toast.LENGTH_LONG).show()

            val intent = Intent(this, preset3::class.java)
            intent.putExtra("date", date.toString())
            intent.putExtra("names", getName2.toString())
            startActivity(intent)
        }

        findViewById<Button>(R.id.butt_preset2_back).setOnClickListener(){
            val intent = Intent(this, preset1::class.java)
            startActivity(intent)
        }



    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getDate(datePicker: DatePicker): Date? {
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        val calend = Calendar.getInstance()
        calend.set(year, month, day)

        return calend.time
    }
}