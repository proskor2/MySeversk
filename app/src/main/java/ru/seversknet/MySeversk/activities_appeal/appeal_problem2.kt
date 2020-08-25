package ru.seversknet.MySeversk.activities_appeal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import ru.seversknet.MySeversk.R
import ru.seversknet.MySeversk.seversk
import kotlinx.android.synthetic.main.activitiy_newproblem2.button_newproblem_close

class appeal_problem2 : AppCompatActivity() {

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
        setContentView(R.layout.activitiy_newproblem2)
        button_newproblem_close.setOnClickListener(){
            val appeal4 = Intent(this@appeal_problem2, seversk::class.java )
            startActivity(appeal4)
            finish()
        }

    }
}