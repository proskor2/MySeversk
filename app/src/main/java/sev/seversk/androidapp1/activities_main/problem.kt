package sev.seversk.androidapp1.activities_main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import sev.seversk.androidapp1.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_problem.*
import kotlinx.android.synthetic.main.activity_seversk_news.*
import okhttp3.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.news_items.ApiInterface
import sev.seversk.androidapp1.news_items.News
import sev.seversk.androidapp1.news_items.RecyclerAdapter
import sev.seversk.androidapp1.problems_items.ApiProblems
import sev.seversk.androidapp1.problems_items.Problem
import sev.seversk.androidapp1.problems_items.ProblemAdapter
import java.io.IOException

class problem : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: ProblemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem)

        findViewById<ImageButton>(R.id.button_back).setOnClickListener(){
            finish()
        }


        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView = findViewById(R.id.recycler_problem)
        recyclerAdapter = ProblemAdapter(this)
        recycler_problem.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiProblems.create().getProblems(token2)

        apiinterface.enqueue(object : Callback<List<Problem>> {
            override fun onResponse(call: Call<List<Problem>>, response: Response<List<Problem>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setProblemListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Problem>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    }
