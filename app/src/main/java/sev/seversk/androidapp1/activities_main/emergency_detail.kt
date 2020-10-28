
package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_emergency_detail.*
import sev.seversk.androidapp1.R
import java.net.HttpCookie

class emergency_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_detail)

//        val te1 = intent.getStringExtra("mobile")
//        val te2 = Html.fromHtml(te1)
//        text_emerg_det.text = te2

        text_emerg_det.text = intent.getStringExtra("mobile")
    }
}