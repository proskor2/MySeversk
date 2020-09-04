package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import sev.seversk.androidapp1.R
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








}