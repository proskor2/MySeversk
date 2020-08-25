package ru.seversknet.MySeversk.pzdc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import ru.seversknet.MySeversk.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_newsid4.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class newsid4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newsid4)


        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {


                val response = okHttpClient.newCall(request).execute()
                val json = response.body()?.string()

                val textnews_date1: String = JSONArray(json).getJSONObject(3).getString("date")
                val textnews_descr1: String = JSONArray(json).getJSONObject(3).getString("description")
                val photonews: String = JSONArray(json).getJSONObject(3).getString("photo")


                runOnUiThread() {
                    newsid4_date?.text = Html.fromHtml(textnews_date1)
                    newsid4_cont?.text = Html.fromHtml(textnews_descr1)
                    val photo1 = Picasso.get().load("https://" + photonews).into(newsid4_image)
                }

            }})
    }
}