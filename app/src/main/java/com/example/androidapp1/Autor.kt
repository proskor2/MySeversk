package com.example.androidapp1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_autor.*


class Autor : AppCompatActivity() {

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
        setContentView(R.layout.activity_autor)



//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
//        editTextPhone3.showSoftInputOnFocus
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)



// Google button
        card_google.setOnClickListener() {
            val ref_ggl = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.ru"))
            startActivity(ref_ggl)
        }

// Esia button
        card_esia.setOnClickListener() {
            val ref_esia = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gosuslugi.ru"))
            startActivity(ref_esia)
        }
// Later autorization
        autor_later.setOnClickListener() {
            val autor_later = Intent(Intent(this@Autor, seversk::class.java))
            startActivity(autor_later)

        }
//Move to SMS
        but_autor.setOnClickListener() {
            val autor_sms = Intent(this@Autor, sms::class.java)
            startActivity(autor_sms)
finish()
        }

        linearLayout3.setOnClickListener(){
            hideKeyboard()
        }



    }


}








