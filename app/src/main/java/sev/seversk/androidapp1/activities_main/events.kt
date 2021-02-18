package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_seversk_events.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.events_items.AfishaAdapter
import sev.seversk.androidapp1.events_items.ApiAfisha


class events : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: AfishaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_events)

        findViewById<ImageButton>(R.id.button_back).setOnClickListener {
            finish()
        }

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView = findViewById(R.id.recycler_afisha)
        recyclerAdapter = AfishaAdapter(this)
        val llm = LinearLayoutManager (this)
        recycler_afisha.layoutManager = llm
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiAfisha.create().getAfisha(token2)

        apiinterface.enqueue(object : Callback<List<Afisha>> {
            override fun onResponse(call: Call<List<Afisha>>, response: Response<List<Afisha>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setAfishaListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Afisha>>, t: Throwable) {

            }
        })
    }

}



