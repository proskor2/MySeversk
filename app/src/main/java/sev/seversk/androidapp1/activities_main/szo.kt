package sev.seversk.androidapp1.activities_main

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import kotlinx.android.synthetic.main.activity_szo.*
import kotlinx.serialization.ImplicitReflectionSerializer
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.emergency.ApiSzo
import sev.seversk.androidapp1.emergency.Szo
import sev.seversk.androidapp1.emergency.SzoAdapter
import java.io.IOException


class szo : AppCompatActivity() {
    @ImplicitReflectionSerializer
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


        findViewById<ImageButton>(R.id.button_closeactivity).setOnClickListener(){
            finish()
        }

            val apiinterface = ApiSzo.create().getSzo(token2)

            apiinterface.enqueue(object : Callback<List<Szo>> {
                override fun onResponse(call: Call<List<Szo>>, response: Response<List<Szo>>?) {

                    val res = response?.body()

                    val jsonArray2 = res?.get(0)?.employees
                    val obj = jsonArray2

                    if (response?.body() != null)
                        recyclerAdapter.setSzoListItems(response.body()!!)

                }

                override fun onFailure(call: Call<List<Szo>>, t: Throwable) {
                    Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
                }
            })

        }
    }
