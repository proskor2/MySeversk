package sev.seversk.androidapp1.events_items

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_news_web.*
import okhttp3.*
import org.json.JSONObject
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.comment.comments1
import java.io.IOException

class event_web : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eventid)

        val myweb: WebView = findViewById(R.id.web_eventid)

        val intent2 = intent?.extras
        val eventid = intent2?.get("idevent").toString()
        val comm = intent2?.get("comm").toString().toInt()

        val getstring = KVault(context = applicationContext!!)
        val newtoken = getstring.string("TOKEN")

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/afisha/$eventid"

        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", "Bearer " + newtoken).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {

                val json = response.body()?.string()
                val parentObject = JSONObject(json)

                val jtitle = parentObject.getString("title")
                val jdate = parentObject.getString("dateTime")
                val jplace = parentObject.getString("place")
                val jdesc = parentObject.getString("description")
                val jphoto = parentObject.getString("photo")



                runOnUiThread {
                    findViewById<TextView>(R.id.text_title_eventid).text = jtitle
                    findViewById<TextView>(R.id.text_date_eventid).text = jdate
                    findViewById<TextView>(R.id.text_place_eventid).text = ("Место проведения: " + jplace)
                    findViewById<TextView>(R.id.text_eventidcomm).text = ("Комментарии: " + comm)

                    myweb.loadDataWithBaseURL("", jdesc, "text/html", "utf-8", "")

                    val imview = findViewById<ImageView>(R.id.image_eventid)

                    Glide.with(this@event_web)
                        .load(jphoto)
                        .into(imview!!)
                }
            }
        })

        //////////////////////////////////////////////////////////////////////////////////////////////////
//        val upl = "/uploads/ckfinder/userfiles/"
//        val newsdesc123 = if (newsdesc.contains(upl)) {
//            newsdesc.replace("/uploads/ckfinder/userfiles/", "https://xn----7sbhlbh0a1awgee.xn--p1ai/uploads/ckfinder/userfiles/")
//        } else {
//            newsdesc
//        }

//        myweb.loadDataWithBaseURL("", newsdesc123, "text/html", "utf-8", "")
        //////////////////////////////////////////////////////////////////////////////////////////////////

        findViewById<TextView>(R.id.text_eventidcomm).setOnClickListener {
            val intent = Intent(this, Comment1Event::class.java)
            intent.putExtra("idevent", eventid)
            startActivity(intent)
        }

    }
    }
