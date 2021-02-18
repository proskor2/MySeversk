package sev.seversk.androidapp1.activities_main

    import android.media.Image
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.ImageButton
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.liftric.kvault.KVault
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

            findViewById<ImageButton>(R.id.button_back).setOnClickListener {
                finish()
            }

            val kVault = KVault(context = applicationContext)
            val token = kVault.string("TOKEN")
            val token2: String = "Bearer $token"

            recyclerView = findViewById(R.id.recycler_news)
            recyclerAdapter = RecyclerAdapter(this)
            recycler_news.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recyclerAdapter

            val apiinterface = ApiInterface.create().getNews(token2)

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
