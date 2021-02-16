package sev.seversk.androidapp1.activities_main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_district.*
import kotlinx.android.synthetic.main.activity_szo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.disctrict_items.ApiDistrict
import sev.seversk.androidapp1.disctrict_items.District
import sev.seversk.androidapp1.disctrict_items.DistrictAdapter
import sev.seversk.androidapp1.disctrict_items.district_description
import sev.seversk.androidapp1.emergency.ApiSzo
import sev.seversk.androidapp1.emergency.Szo
import sev.seversk.androidapp1.emergency.SzoAdapter

class district : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district)

        findViewById<ImageButton>(R.id.button_back).setOnClickListener(){
            finish()
        }

        lateinit var recyclerView: RecyclerView
        lateinit var recyclerAdapter: DistrictAdapter

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView = findViewById(R.id.recycler_districts)
        recyclerAdapter = DistrictAdapter(this)
        recycler_districts.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter


//        findViewById<ImageButton>(R.id.button_closeactivity).setOnClickListener(){
//            finish()
//        }

        val apiinterface = ApiDistrict.create().getDistrict(token2)

        apiinterface.enqueue(object : Callback<List<District>> {
            override fun onResponse(call: Call<List<District>>, response: Response<List<District>>?) {

                val res = response?.body()

                if (response?.body() != null)
                    recyclerAdapter.setDistrictListItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<District>>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })

    }
}