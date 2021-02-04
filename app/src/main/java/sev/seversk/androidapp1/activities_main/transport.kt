package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.activity_seversk_transport.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.transport_items.ApiTransport
import sev.seversk.androidapp1.transport_items.Transport
import sev.seversk.androidapp1.transport_items.TransportAdapter

class transport : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: TransportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk_transport)


        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView = findViewById(R.id.recycler_transport)
        recyclerAdapter = TransportAdapter(this)
        recycler_transport.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiTransport.create().getTransport(token2)

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

