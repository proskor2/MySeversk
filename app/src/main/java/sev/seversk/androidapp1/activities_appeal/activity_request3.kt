package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.seversk
import kotlinx.android.synthetic.main.activitiy_appeal_request3.*

class activity_request3 : AppCompatActivity() {

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
        setContentView(R.layout.activitiy_appeal_request3)
        button_newproblem_close.setOnClickListener {
            val appeal4 = Intent(this@activity_request3, seversk::class.java )
            startActivity(appeal4)
            finish()
        }

    }

}