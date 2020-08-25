package com.example.androidapp1.activities_main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp1.R
import com.example.androidapp1.data.News_adapter
import com.example.androidapp1.data.News_data
import com.example.androidapp1.data.okhttp_data
import com.example.androidapp1.pzdc.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_seversk_news.*
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class news : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_news)


    }



    @Override
    override fun onStart() {
        super.onStart()


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



                    runOnUiThread() {
                        textnews011?.text = textnews_title1
                        textnews012?.text = textnews_preview1
                        val photo1 = Picasso.get().load("https://" + photonews).into(imagenews01)

                        textnews021?.text = textnews_title2
                        textnews022?.text = textnews_preview2
                        val photo2 = Picasso.get().load("https://" + photonews2).into(imagenews021)

                        textnews031?.text = textnews_title3
                        textnews032?.text = textnews_preview3
                        val photo3 = Picasso.get().load("https://" + photonews3).into(imagenews031)

                        textnews041?.text = textnews_title4
                        textnews042?.text = textnews_preview4
                        val photo4 = Picasso.get().load("https://" + photonews4).into(imagenews04)

                        textnews051?.text = textnews_title5
                        textnews052?.text = textnews_preview5
                        val photo5 = Picasso.get().load("https://" + photonews5).into(imagenews05)

                        textnews061?.text = textnews_title6
                        textnews062?.text = textnews_preview6
                        val photo6 = Picasso.get().load("https://" + photonews6).into(imagenews06)

                        textnews071?.text = textnews_title7
                        textnews072?.text = textnews_preview7
                        val photo7 = Picasso.get().load("https://" + photonews7).into(imagenews07)

                    }


                }

            })
        cardnews01.setOnClickListener(){
            val intent1 = Intent(this, newsid1::class.java)
            startActivity(intent1)
        }

        cardnews02.setOnClickListener(){
            val intent1 = Intent(this, newsid2::class.java)
            startActivity(intent1)
        }
        cardnews03.setOnClickListener(){
            val intent1 = Intent(this, newsid3::class.java)
            startActivity(intent1)
        }
        cardnews04.setOnClickListener(){
            val intent1 = Intent(this, newsid4::class.java)
            startActivity(intent1)
        }
        cardnews05.setOnClickListener(){
            val intent1 = Intent(this, newsid5::class.java)
            startActivity(intent1)
        }
        cardnews06.setOnClickListener(){
            val intent1 = Intent(this, newsid6::class.java)
            startActivity(intent1)
        }
        cardnews07.setOnClickListener(){
            val intent1 = Intent(this, newsid7::class.java)
            startActivity(intent1)
        }
//            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
//            StrictMode.setThreadPolicy(policy)

//            val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
//            val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news"
//            var okHttpClient: OkHttpClient = OkHttpClient()
//            val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()
//            val response = okHttpClient.newCall(request).execute()
//            val json = response.body()?.string()

//            val json = okhttp_data().getJsonData("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news")
//
//            fun generateDummyList(size: Int): ArrayList<News_data> {
//                val list = ArrayList<News_data>()
//
//                for (i in 0..9) {
//                    val text_title1: String = JSONArray(json).getJSONObject(i).getString("title")
//                    val text_preview1: String = JSONArray(json).getJSONObject(i).getString("preview")
//                    val drawable: String = JSONArray(json).getJSONObject(i).getString("photo")
//                    val descr = JSONArray(json).getJSONObject(i).getString("description")
//                    list.add(i, News_data("$text_title1", "$text_preview1"))
//
//                }
//                    return list
//                }
//                val exampleList = generateDummyList(1)
//                val adapter = News_adapter(exampleList, this)
//                recylcer_news.adapter = adapter
//                recylcer_news.layoutManager = LinearLayoutManager(this)
//                recylcer_news.setHasFixedSize(true)
//            }
//        }
//
//    override fun onItemClick(position: Int) {
//        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
//    }
//    }


        }}