package sev.seversk.androidapp1.activities_main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.newsid.*
import sev.seversk.androidapp1.R

class newsid: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newsid)
        val intent1 = intent.extras
        val text_det_news = intent1?.get("detail").toString()
        val text_date_news = intent1?.get("daten").toString()
        val photo_n = intent1?.get("photon").toString()
        Glide.with(this).load(photo_n)
            .apply(RequestOptions().centerCrop())
            .into(newsid_image)
       newsid_cont?.text = text_det_news
        newsid_date?.text = text_date_news

    }
}