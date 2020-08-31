@file:Suppress("DEPRECATION")

package sev.seversk.androidapp1.ui.mainscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import sev.seversk.androidapp1.MapsActivity
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.*
import sev.seversk.androidapp1.pzdc.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onStart() {
        super.onStart()

        button_news.setOnClickListener() {
            val news = Intent(context, news::class.java)
            startActivity(news)
        }
        button_events.setOnClickListener() {
            val event = Intent(context, events::class.java)
            startActivity(event)
        }
        button_opros.setOnClickListener() {
            val opros = Intent(context, opros::class.java)
            startActivity(opros)
        }
        button_transport.setOnClickListener() {
            val transport = Intent(context, transport::class.java)
            startActivity(transport)
        }
        button_problems123.setOnClickListener() {
            val problems = Intent(context, problem::class.java)
            startActivity(problems)
        }
        button_offers.setOnClickListener() {
            val offer = Intent(context, appeal::class.java)
            startActivity(offer)
        }
//        card_news1.setOnClickListener(){
//            val newact = Intent(this@HomeFragment.context, newsid::class.java)
//            startActivity(newact)
//        }

        button_map.setOnClickListener() {
            val map1 = Intent(context, MapsActivity::class.java)
            startActivity(map1)
        }

        button_alerts.setOnClickListener() {
            val alert1 = Intent(context, alerts::class.java)
            startActivity(alert1)
        }

        button_emergency.setOnClickListener() {
            val remont1 = Intent(context, emergency::class.java)
            startActivity(remont1)
        }
        button_district.setOnClickListener() {
            val distr1 = Intent(context, district::class.java)
            startActivity(distr1)
        }
        button_service.setOnClickListener() {
            val serv1 = Intent(context, remont::class.java)
            startActivity(serv1)
        }


        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()

        okHttpClient.run {

            newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                @SuppressLint("WrongConstant")
                override fun onResponse(call: Call, response: Response) {


                    val response = newCall(request).execute()
                    val json = response.body()?.string()

                    val textnews_title1: String = JSONArray(json).getJSONObject(0).getString("title")
                    val textnews_preview1: String = JSONArray(json).getJSONObject(0).getString("preview")
                    val photonews: String = JSONArray(json).getJSONObject(0).getString("photo")


                    val textnews_title2: String = JSONArray(json).getJSONObject(1).getString("title")
                    val textnews_preview2: String = JSONArray(json).getJSONObject(1).getString("preview")
                    val photonews2: String = JSONArray(json).getJSONObject(1).getString("photo")

                    val textnews_title3: String = JSONArray(json).getJSONObject(2).getString("title")
                    val textnews_preview3: String = JSONArray(json).getJSONObject(2).getString("preview")
                    val photonews3: String = JSONArray(json).getJSONObject(2).getString("photo")

                    val textnews_title4: String = JSONArray(json).getJSONObject(3).getString("title")
                    val textnews_preview4: String = JSONArray(json).getJSONObject(3).getString("preview")
                    val photonews4: String = JSONArray(json).getJSONObject(3).getString("photo")

                    val textnews_title5: String = JSONArray(json).getJSONObject(4).getString("title")
                    val textnews_preview5: String = JSONArray(json).getJSONObject(4).getString("preview")
                    val photonews5: String = JSONArray(json).getJSONObject(4).getString("photo")

                    val textnews_title6: String = JSONArray(json).getJSONObject(5).getString("title")
                    val textnews_preview6: String = JSONArray(json).getJSONObject(5).getString("preview")
                    val photonews6: String = JSONArray(json).getJSONObject(5).getString("photo")

                    val textnews_title7: String = JSONArray(json).getJSONObject(6).getString("title")
                    val textnews_preview7: String = JSONArray(json).getJSONObject(6).getString("preview")
                    val photonews7: String = JSONArray(json).getJSONObject(6).getString("photo")



                    activity?.runOnUiThread() {
                        textnews11?.text = Html.fromHtml(textnews_title1)
                        textnews12?.text = Html.fromHtml(textnews_preview1)
                        val newurl = "https://"+photonews
                        val im1 = view?.findViewById<ImageView>(R.id.imagenews1)
                        if (imagenews1 != null) Picasso.get().load(newurl).into(im1)





                        textnews21?.text = Html.fromHtml(textnews_title2)
                        textnews22?.text = Html.fromHtml(textnews_preview2)
                        val newurl2 = "https://"+photonews2
                        val im2 = view?.findViewById<ImageView>(R.id.imagenews2)
                        if (imagenews2 != null) Picasso.get().load(newurl2).into(im2)


                        textnews31?.text = Html.fromHtml(textnews_title3)
                        textnews32?.text = Html.fromHtml(textnews_preview3)

                        val newurl3 = "https://"+photonews3
                        val im3 = view?.findViewById<ImageView>(R.id.imagenews3)
                        if (imagenews3 != null) Picasso.get().load(newurl3).into(im3)

                        textnews41?.text = Html.fromHtml(textnews_title4)
                        textnews42?.text = Html.fromHtml(textnews_preview4)
                        val newurl4 = "https://"+photonews4
                        val im4 = view?.findViewById<ImageView>(R.id.imagenews4)
                        if (imagenews4 != null) Picasso.get().load(newurl4).into(im4)



                        textnews51?.text = Html.fromHtml(textnews_title5)
                        textnews52?.text = Html.fromHtml(textnews_preview5)
                        val newurl5 = "https://"+photonews5
                        val im5 = view?.findViewById<ImageView>(R.id.imagenews5)
                        if (imagenews5 != null) Picasso.get().load(newurl5).into(im5)



                        textnews61?.text = Html.fromHtml(textnews_title6)
                        textnews62?.text = Html.fromHtml(textnews_preview6)
                        val newurl6 = "https://"+photonews6
                        val im6 = view?.findViewById<ImageView>(R.id.imagenews6)
                        if (imagenews6 != null) Picasso.get().load(newurl6).into(im6)



                        textnews71?.text = Html.fromHtml(textnews_title7)
                        textnews72?.text = Html.fromHtml(textnews_preview7)
                        val newurl7 = "https://"+photonews
                        val im7 = view?.findViewById<ImageView>(R.id.imagenews7)
                        if (imagenews7 != null) Picasso.get().load(newurl7).into(im7)



                    }


                }

            })
        }

        cardnews1.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid1::class.java)
            startActivity(intent1)
        }

        cardnews2.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid2::class.java)
            startActivity(intent1)
        }
        cardnews3.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid3::class.java)
            startActivity(intent1)
        }
        cardnews4.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid4::class.java)
            startActivity(intent1)
        }
        cardnews5.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid5::class.java)
            startActivity(intent1)
        }
        cardnews6.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid6::class.java)
            startActivity(intent1)
        }
        cardnews7.setOnClickListener(){
            val intent1 = Intent(this@HomeFragment.context, newsid7::class.java)
            startActivity(intent1)
        }
//        cardnews8.setOnClickListener(){
//            val intent1 = Intent(this@HomeFragment.context, newsid8::class.java)
//            startActivity(intent1)
//        }
//        cardnews9.setOnClickListener(){
//            val intent1 = Intent(this@HomeFragment.context, newsid9::class.java)
//            startActivity(intent1)
//        }
//        cardnews10.setOnClickListener(){
//            val intent1 = Intent(this@HomeFragment.context, newsid10::class.java)
//            startActivity(intent1)
//        }
    }
}















