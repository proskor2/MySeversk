package sev.seversk.androidapp1.ui.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_activid.*
import kotlinx.android.synthetic.main.newsid.*
import sev.seversk.androidapp1.R

class Activid : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activid)

        val intent1 = intent.extras
        val text_date_act = intent1?.get("date").toString()
        val text_desc_act = intent1?.get("desc").toString()
        val photo_act = intent1?.get("photo").toString()
        Glide.with(this).load(photo_act)
            .apply(RequestOptions().centerCrop())
            .into(activid_image)
        activid_cont?.text = text_desc_act
        activid_date?.text = text_date_act
    }
}