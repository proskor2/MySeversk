package com.example.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.example.androidapp1.R
import com.example.androidapp1.seversk
import kotlinx.android.synthetic.main.activitiy_appeal_request3.*
import kotlinx.android.synthetic.main.activitiy_appeal_request2.*
import kotlinx.android.synthetic.main.activity_appeal_iniciate.*

class appeal_iniciate : AppCompatActivity() {

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
        setContentView(R.layout.activity_appeal_iniciate)

        button_iniciate_close.setOnClickListener(){
            val close1 = Intent(this@appeal_iniciate, seversk::class.java)
            startActivity(close1)
        }

        button_iniciate_ready.setOnClickListener(){
            val close2 = Intent(this@appeal_iniciate, seversk::class.java)
            startActivity(close2)
        }
        button_iniciate_addfile.setOnClickListener(){
            val addpick = Intent(Intent.ACTION_PICK)
            addpick.setType("image/*")
            startActivityForResult(addpick,1 )
//            val one = addpick.data
//            imageView_add.setImageURI(one)
        }
        linear6.setOnClickListener(){
            hideKeyboard()
        }
    }
}