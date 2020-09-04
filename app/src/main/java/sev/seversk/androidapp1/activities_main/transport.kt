package sev.seversk.androidapp1.activities_main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.bus_detail
import kotlinx.android.synthetic.main.activity_seversk_transport.*
import okhttp3.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.opros_items.ApiOpros
import sev.seversk.androidapp1.opros_items.Opros
import sev.seversk.androidapp1.opros_items.OprosAdapter
import sev.seversk.androidapp1.transport_items.ApiTransport
import sev.seversk.androidapp1.transport_items.Transport
import sev.seversk.androidapp1.transport_items.TransportAdapter
import java.io.IOException

class transport : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: TransportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_transport)

        recyclerView = findViewById(R.id.recycler_transport)
        recyclerAdapter = TransportAdapter(this)
        recycler_transport.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiTransport.create().getTransport()

        apiinterface.enqueue(object : Callback<List<Transport>> {
            override fun onResponse(call: Call<List<Transport>>, response: Response<List<Transport>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setTransportListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Transport>>, t: Throwable) {

            }
        })
    }

    }

