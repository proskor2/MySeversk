package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_prodile_settings2.*


class prodile_settings2 : AppCompatActivity() {
// function for hide keyboard
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

    @SuppressLint("WorldReadableFiles")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prodile_settings2)

// Start function for hide keyboard
layout1123.setOnClickListener(){
    hideKeyboard()
}




// Change Activity to back with data
    button_profile2_back.setOnClickListener(){
        val back1 = Intent (this@prodile_settings2, profile_settings::class.java )
        back1.putExtra("name", set_profile_name?.text.toString())
        back1.putExtra("surname", set_profile_surname?.text.toString())
        back1.putExtra("phonenum", set_profile_phone?.text.toString())
        startActivity(back1)
        finish()
    }

// Save data
        button_profile2_save.setOnClickListener(){
            val toast1= Toast.makeText(applicationContext, "Изменения сохранены", Toast.LENGTH_SHORT)
            toast1.show()

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {

        var name1 = set_profile_name.text
        var name2 = set_profile_surname.text
        outState.putString("name", name1.toString())
        super.onSaveInstanceState(outState)



    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        var name2 = savedInstanceState.getString("name")
        set_profile_name.setText(name2)


    }
}

