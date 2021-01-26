package sev.seversk.androidapp1.authorization

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import sev.seversk.androidapp1.R
import java.text.DateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class preset2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset2)

        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()


        findViewById<LinearLayout>(R.id.linear_date).setOnClickListener(){
            hideKeyboard()
        }

        findViewById<Button>(R.id.button_preset2_next).setOnClickListener(){
            val date = getDate(datePicker).toString()
            editor?.putString("date", date)
            editor?.apply()
            Toast.makeText(this, "$date", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, preset3::class.java)
            intent.putExtra("date", date)
            startActivity(intent)
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getDate(datePicker: DatePicker): String {
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        val calend = Calendar.getInstance()
        calend.set(year, month, day)
        val dateFormat = DateFormat.getDateInstance(DateFormat.LONG)
        val newformat = SimpleDateFormat("dd.MM.yyyy")

        val date = newformat.format(calend.time)

        return date
    }

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
}