package sev.seversk.androidapp1.opros_items

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.liftric.kvault.KVault
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.yandex_maps
import java.io.IOException

class opros_start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opros_start)

        findViewById<ImageButton>(R.id.button_backopros).setOnClickListener {
            finish()
        }

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        val webv = findViewById<WebView>(R.id.web_startopros)
        val title = findViewById<TextView>(R.id.text_startopros_title)
        val num = findViewById<TextView>(R.id.text_startopros_numberq)
        val buttonstart = findViewById<Button>(R.id.button_startopros)

        val intent2= intent.extras
        val gettitle = intent2?.get("title").toString()
        val getnum = intent2?.get("num").toString()
        val descr = intent2?.get("desc").toString()
        val getstatus = intent2?.get("status").toString()
        val getid = intent2?.get("id").toString().toInt()
        val strid = getid.toString().trimMargin()


        title.text = gettitle
        num.text = ("Количество вопросов: "+getnum)

        val upl = "/uploads/ckfinder/userfiles/"
        val descr2 = if (descr.contains(upl)) {
            descr.replace("/uploads/ckfinder/userfiles/", "https://xn----7sbhlbh0a1awgee.xn--p1ai/uploads/ckfinder/userfiles/")
        } else {
            descr
        }
        webv.loadDataWithBaseURL("", descr2, "text/html", "utf-8", "")


////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        buttonstart.setOnClickListener {
            val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/questionnaires/$getid/start"
            var okHttpClient: OkHttpClient = OkHttpClient()

            val formBody = FormBody.Builder()
                .add("id", strid)
                .build()

            val request: Request = Request.Builder().url(URL).addHeader("Authorization", token2).post(formBody).build()

            okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
                override fun onFailure(call: okhttp3.Call, e: IOException) {
                }

                @SuppressLint("WrongConstant")
                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                    val json1 = response.body()?.string()
                    val one = JSONObject(json1).get("status")

                    runOnUiThread {

                        if (one == "noactual") {
                            Toast.makeText(applicationContext,
                                "Выбранный опрос не актуален",
                                Toast.LENGTH_LONG).show()

                        } else if (one == "close") {
                            Toast.makeText(applicationContext,
                                "Выбранный опрос завершен",
                                Toast.LENGTH_LONG).show()

                        } else if (one == "start") {
                            val intent1 = Intent(this@opros_start, opros_details::class.java)
                            intent1.putExtra("idquestionnaire", getid)
                            startActivity(intent1)
                        } else if (one == "continue") {
                            Toast.makeText(applicationContext,
                                "Продолжение прохождения опроса",
                                Toast.LENGTH_LONG).show()
                            val intent1 = Intent(this@opros_start, opros_details::class.java)
                            intent1.putExtra("idquestionnaire", getid)
                            startActivity(intent1)
                        } else {
                            Toast.makeText(applicationContext, "Ошибка", Toast.LENGTH_LONG).show()
                        }
                    }
                    }
        })


    }
}
}