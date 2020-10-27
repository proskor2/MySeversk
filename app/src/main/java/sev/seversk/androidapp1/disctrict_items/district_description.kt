package sev.seversk.androidapp1.disctrict_items

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_district_description.*
import sev.seversk.androidapp1.R

class district_description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district_description)

        text_disrtictdescrpition_name.text = intent.getStringExtra("name1")
        text_disrtictdescrpition_number.text = intent.getStringExtra("num1")
        text_disrtictdescrpition_streets.text = intent.getStringExtra("streets1")
        val bundle = intent.extras
        val resId = bundle?.getInt("resId")
        if (resId != null) {
            image_disrtictdescrpition.setImageResource(resId)
        }


    }
}