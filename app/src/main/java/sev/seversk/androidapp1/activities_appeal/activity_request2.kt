package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activitiy_appeal_request2.*

class activity_request2 : AppCompatActivity() {

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
        setContentView(R.layout.activitiy_appeal_request2)

        val Pick_image = 1
        button_appeal_ready.setOnClickListener(){
            val appeal4 = Intent(this@activity_request2, activity_request3::class.java )
            startActivity(appeal4)
            finish()
        }
        button_appeal_back.setOnClickListener(){
            val appeal4 = Intent(this@activity_request2, activitiy_request::class.java )
            startActivity(appeal4)
            finish()
        }
        fun addPhoto(){
            val addpick = Intent(Intent.ACTION_PICK)
            addpick.setType("image/*")
            startActivityForResult(addpick,Pick_image)
            val one = addpick.data
            imageView_add.setImageURI(one)
        }

        button_appeal_addfile.setOnClickListener(){
//            val addpick = Intent(Intent.ACTION_PICK)
//            addpick.setType("image/*")
//            startActivityForResult(addpick,Pick_image)
//            val one = addpick.data
//            val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, one)
//            imageView_add.setImageBitmap(bitmap)

            addPhoto()
        }
        linear4.setOnClickListener(){
            hideKeyboard()
        }


    }
}