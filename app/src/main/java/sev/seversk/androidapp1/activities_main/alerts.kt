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
import kotlinx.android.synthetic.main.activity_alerts.*
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import okhttp3.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.alerts_items.Alert
import sev.seversk.androidapp1.alerts_items.AlertAdapter
import sev.seversk.androidapp1.alerts_items.ApiAlert
import sev.seversk.androidapp1.opros_items.ApiOpros
import sev.seversk.androidapp1.opros_items.Opros
import sev.seversk.androidapp1.opros_items.OprosAdapter
import java.io.IOException

class alerts : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: AlertAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)

        findViewById<ImageButton>(R.id.button_back).setOnClickListener(){
            finish()
        }


        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView = findViewById(R.id.recycler_alerts)
        recyclerAdapter = AlertAdapter(this)
        recycler_alerts.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = ApiAlert.create().getAlert(token2)

        apiinterface.enqueue(object : Callback<List<Alert>> {
            override fun onResponse(call: Call<List<Alert>>, response: Response<List<Alert>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setAlertListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Alert>>, t: Throwable) {

            }
        })
    }

    }
