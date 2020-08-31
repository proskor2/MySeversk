package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.data.Data1
import sev.seversk.androidapp1.seversk
import kotlinx.android.synthetic.main.activitiy_appeal_request.*

class activitiy_request : AppCompatActivity() {
    fun AppCompatActivity.hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        else {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_appeal_request)

        button_appeal_next.setOnClickListener(){
            val appeal2 = Intent(this@activitiy_request, activity_request2::class.java )
            startActivity(appeal2)
            finish()
        }

        button_appeal_cancel.setOnClickListener(){
            val appeal3 = Intent(this@activitiy_request, seversk::class.java )
            startActivity(appeal3)
            finish()
        }
        layout3.setOnClickListener(){
            hideKeyboard()
        }
//        newPersonData(data1 = firstPerson)
    }


    var firstPerson:Data1 = Data1(1, "7812-3265-7078", "10.08.2020", "20.08.2020", "В работе", "Иванов", "Иван", "Петрович", "9137778555", "Добрый день", " ")

//    fun newPersonData(data1: Data1) {
//        var personFirst = data1
//        personFirst.name = text_appeal_name.text.toString()
//        personFirst.surname = text_appeal_surname.text.toString()
//        personFirst.patronymic = text_appeal_secondname.text.toString()
//    }








}