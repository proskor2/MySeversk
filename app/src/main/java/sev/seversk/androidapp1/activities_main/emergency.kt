package sev.seversk.androidapp1.activities_main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_district.*
import kotlinx.android.synthetic.main.activity_emergency.*
import kotlinx.android.synthetic.main.activity_szo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.disctrict_items.district_description
import sev.seversk.androidapp1.emergency.*

class emergency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"


        lateinit var recyclerView2: RecyclerView
        lateinit var recyclerAdapter2: EmergAdapter


        recyclerView2 = findViewById(R.id.recycler_emerg)
        recyclerAdapter2 = EmergAdapter(this)
        recycler_emerg.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = recyclerAdapter2


//        findViewById<ImageButton>(R.id.button_closeactivity).setOnClickListener(){
//            finish()
//        }

        val apiinterface2 = ApiEmerg.create().getEmerg(token2)

        apiinterface2.enqueue(object : Callback<List<Emergency>> {
            override fun onResponse(call: Call<List<Emergency>>, response: Response<List<Emergency>>?) {

                val res = response?.body()

                if (response?.body() != null)
                    recyclerAdapter2.setEmergListItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<Emergency>>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })

    }




    }
