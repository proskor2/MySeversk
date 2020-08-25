package sev.seversk.androidapp1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_bus_detail.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class bus_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_detail)

        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/traffic/detail"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {
                val json = response?.body()?.string()

                val txt = (JSONArray(json).get(0)).toString()
                val txt2 = JSONArray(json).getJSONObject(0).getString("title")
                val txt3: String = JSONArray(json).getJSONObject(0).getString("number")
                txt3.toInt()
                val txt4: String = JSONArray(json).getJSONObject(0).getString("length")
                val txt6: String = JSONArray(json).getJSONObject(0).getString("type")
                val txt7: String = JSONArray(json).getJSONObject(0).getString("regNumber")
                val txt8: String = JSONArray(json).getJSONObject(0).getString("dateBegin")
                val txt9: String = JSONArray(json).getJSONObject(0).getString("stopRules")
                val txt10: String = JSONArray(json).getJSONObject(0).getString("payRules")


                runOnUiThread(){
                    busdetail_number.text = Html.fromHtml("Маршрут №"+txt3)
                    busdetail_length.text = Html.fromHtml(txt4)
                    busdetail_dateBegin.text = Html.fromHtml(txt8)
                    busdetail_regNum.text = Html.fromHtml(txt7)
                    busdetail_dateBegin.text = Html.fromHtml(txt8)
                    busdetail_stoprules.text = Html.fromHtml(txt9)
                    busdetail_title.text = Html.fromHtml(txt2)
                    busdetail_payrules.text = Html.fromHtml(txt10)



                }
            }

        })


    }
}