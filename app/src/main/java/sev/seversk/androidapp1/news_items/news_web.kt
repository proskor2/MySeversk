package sev.seversk.androidapp1.news_items

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.core.text.htmlEncode
import kotlinx.android.synthetic.main.activity_news_web.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.comment.comments1

class news_web : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_web)

        val intent2 = intent.extras
        val newsnews = intent2?.get("newsid").toString()
        val newsdesc = intent2?.get("detail").toString()

        val comm = intent2?.get("comm").toString()

        news_comm?.text = ("Комментарии: "+comm)

        news_comm.setOnClickListener(){
            val intent = Intent(this, comments1::class.java)
            intent.putExtra("idnews", newsnews)
            startActivity(intent)
        }

        news_webview.settings.javaScriptEnabled

        val myweb: WebView = findViewById(R.id.news_webview)


        val map1: Map<String, String> = mapOf("Authorization" to "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")

//        myweb.loadUrl("https://xn----7sbhlbh0a1awgee.xn--p1ai/news/front/view/id/"+"$newsnews")
//        myweb.loadUrl("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news/"+"$newsnews", map1)

        myweb.loadDataWithBaseURL("file:///android_asset/", newsdesc, "text/html", "utf-8", null)


//        myweb.loadData( newsdesc, "text/html", "utf-8")



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    }
}