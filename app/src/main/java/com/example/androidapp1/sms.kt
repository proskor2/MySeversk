package com.example.androidapp1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sms.*

class sms : AppCompatActivity() {

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
        setContentView(R.layout.activity_sms)
        // move to My Seversk screen
        but_sms.setOnClickListener(){
            val autor_mysev = Intent (this@sms, seversk::class.java)
            startActivity(autor_mysev)
        finish()}
// Autorization later
        autor_sms2.setOnClickListener(){
            val autor_later = Intent(Intent(this@sms, seversk::class.java))
            startActivity(autor_later)
        finish()}
        // SMS once again
        text_resms.setOnClickListener(){
            val resms = Toast.makeText(applicationContext, "Повторно выслали код", Toast.LENGTH_SHORT)
            resms.show()

        }
        left_button.setOnClickListener(){
            val left1 = Intent(this@sms, Autor::class.java)
            startActivity(left1)
            finish()
        }
        linearlayout4.setOnClickListener(){
            hideKeyboard()
        }
    }
}


