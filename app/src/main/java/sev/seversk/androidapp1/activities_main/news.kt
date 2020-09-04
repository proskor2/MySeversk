package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_seversk_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.news_items.ApiInterface
import sev.seversk.androidapp1.news_items.News
import sev.seversk.androidapp1.news_items.RecyclerAdapter

class news : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_news)

        recyclerView = findViewById(R.id.recycler_news)
        recyclerAdapter = RecyclerAdapter(this)
        recycler_news.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiInterface.create().getNews()

        apiinterface.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setNewsListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}