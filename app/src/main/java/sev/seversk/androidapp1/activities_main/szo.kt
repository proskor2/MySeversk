package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import kotlinx.android.synthetic.main.activity_szo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.emergency.ApiSzo
import sev.seversk.androidapp1.emergency.Szo
import sev.seversk.androidapp1.emergency.SzoAdapter
import sev.seversk.androidapp1.emergency.employees
import sev.seversk.androidapp1.opros_items.ApiOpros
import sev.seversk.androidapp1.opros_items.Opros
import sev.seversk.androidapp1.opros_items.OprosAdapter

class szo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var recyclerView: RecyclerView
        lateinit var recyclerAdapter: SzoAdapter

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_szo)

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

            recyclerView = findViewById(R.id.recycler_szo)
            recyclerAdapter = SzoAdapter(this)
            recycler_szo.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recyclerAdapter

            val apiinterface = ApiSzo.create().getSzo(token2)

            apiinterface.enqueue(object : Callback<List<Szo>> {
                override fun onResponse(call: Call<List<Szo>>, response: Response<List<Szo>>?) {
                    if (response?.body() != null)
                        recyclerAdapter.setSzoListItems(response.body()!!)
                }

                override fun onFailure(call: Call<List<Szo>>, t: Throwable) {
                    Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
                }
            })


        }
    }
