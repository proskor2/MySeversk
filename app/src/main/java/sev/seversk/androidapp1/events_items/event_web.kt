package sev.seversk.androidapp1.events_items

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_news_web.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.comment.comments1

class event_web : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_web)

        val myweb: WebView = findViewById(R.id.event_webview)

        val intent2 = intent?.extras
        val eventid = intent2?.get("eventid").toString().toInt()
        val newsdesc = intent2?.get("detail").toString()

        //////////////////////////////////////////////////////////////////////////////////////////////////
        val upl = "/uploads/ckfinder/userfiles/"
        val newsdesc123 = if (newsdesc.contains(upl)) {
            newsdesc.replace("/uploads/ckfinder/userfiles/", "https://xn----7sbhlbh0a1awgee.xn--p1ai/uploads/ckfinder/userfiles/")
        } else {
            newsdesc
        }

        myweb.loadDataWithBaseURL("", newsdesc123, "text/html", "utf-8", "")
        //////////////////////////////////////////////////////////////////////////////////////////////////

        val comm = intent2?.get("comm").toString()
        news_comm?.text = ("Комментарии: "+comm)

        news_comm.setOnClickListener {
            val intent = Intent(this, comments1::class.java)
            intent.putExtra("idnews", eventid)
            startActivity(intent)
        }

    }
    }
