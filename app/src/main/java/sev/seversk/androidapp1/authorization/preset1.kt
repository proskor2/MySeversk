package sev.seversk.androidapp1.authorization

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import sev.seversk.androidapp1.R

class preset1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset1)




        val getNameField = findViewById<EditText>(R.id.preset_name).text.toString()


        findViewById<Button>(R.id.button_preset1_next).setOnClickListener(){

            val intent = Intent(this, preset2::class.java)
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.linear_name).setOnClickListener(){
            hideKeyboard()
        }

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
