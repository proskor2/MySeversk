package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
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
    val CAMERA_REQUEST_CODE = 0

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

        button_addprofilephoto.setOnClickListener(){
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    add_profilephoto.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        var name1 = set_profile_name.text
        var name2 = set_profile_surname.text
        outState.putString("name", name1.toString())
        outState.putString("surname", name2.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)



        var name1 = savedInstanceState.getString("name")
        var name2 = savedInstanceState.getString("surname")
        set_profile_name.setText(name2)
    }




}

