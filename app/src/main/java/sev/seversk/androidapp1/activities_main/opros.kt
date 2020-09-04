package sev.seversk.androidapp1.activities_main

import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_seversk_events.*
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import okhttp3.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.events_items.AfishaAdapter
import sev.seversk.androidapp1.events_items.ApiAfisha
import sev.seversk.androidapp1.opros_items.*

class opros : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: OprosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_opros)

        recyclerView = findViewById(R.id.recycler_opros)
        recyclerAdapter = OprosAdapter(this)
        recycler_opros.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiOpros.create().getOpros()

        apiinterface.enqueue(object : Callback<List<Opros>> {
            override fun onResponse(call: Call<List<Opros>>, response: Response<List<Opros>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setOprosListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Opros>>, t: Throwable) {

            }
        })
    }

}






