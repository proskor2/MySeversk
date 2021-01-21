package sev.seversk.androidapp1.authorization

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import sev.seversk.androidapp1.R
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class preset2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset2)

        fun hideKeyboard() {
            val view = this.currentFocus
            if (view != null) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
            else {
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
            }
        }

        findViewById<LinearLayout>(R.id.linear_date).setOnClickListener(){
            hideKeyboard()
        }

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val date = getDate(datePicker)


        fun saveData(){
            var insertdate = date
            val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.putString("date", insertdate.toString())
            editor?.apply()
        }

        findViewById<Button>(R.id.button_preset2_next).setOnClickListener(){
            saveData()
            val intent = Intent(this, preset3::class.java)
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