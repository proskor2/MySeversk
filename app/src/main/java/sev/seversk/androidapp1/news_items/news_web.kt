package sev.seversk.androidapp1.news_items

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Base64
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.core.text.HtmlCompat
import androidx.core.text.htmlEncode
import kotlinx.android.synthetic.main.activity_news_web.*
import sev.seversk.androidapp1.R
import java.net.URI
import java.net.URL
import java.util.*

class news_web : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_web)

        val intent2 = intent.extras
        val newsnews = intent2?.get("newsid").toString()
        val newsdesc = intent2?.get("detail").toString()
        val hndsc = newsdesc.htmlEncode()


        news_webview.settings.domStorageEnabled
        news_webview.settings.setAppCacheEnabled(true)
        news_webview.settings.loadsImagesAutomatically
        news_webview.settings.mixedContentMode
        news_webview.settings.javaScriptEnabled

        val myweb: WebView = findViewById(R.id.news_webview)

        val map1: Map<String, String> = mapOf("Authorization" to "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")

//        myweb.loadUrl("https://xn----7sbhlbh0a1awgee.xn--p1ai/news/front/view/id/"+"$newsnews")
//        myweb.loadUrl("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news/"+"$newsnews", map1)


        myweb.loadData( newsdesc, "text/html", "utf-8")



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    }
}