package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import kotlinx.android.synthetic.main.activity_remont.*
import kotlinx.android.synthetic.main.activity_szo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.emergency.ApiSzo
import sev.seversk.androidapp1.emergency.Szo
import sev.seversk.androidapp1.emergency.SzoAdapter
import sev.seversk.androidapp1.remont.*

class remont : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remont)

        findViewById<ImageButton>(R.id.button_back).setOnClickListener(){
            finish()
        }
// Roads
        lateinit var recyclerView1: RecyclerView
        lateinit var recyclerAdapter1: AdapterRoads

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView1 = findViewById(R.id.recycler_roads)
        recyclerAdapter1 = AdapterRoads(this)
        recycler_roads.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = recyclerAdapter1


        val apiinterface1 = ApiRoads.create().getRoads(token2)

        apiinterface1.enqueue(object : Callback<List<roads>> {
            override fun onResponse(call: Call<List<roads>>, response: Response<List<roads>>?) {

                val res = response?.body()

                if (response?.body() != null)
                    recyclerAdapter1.setRoadsListItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<roads>>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })



// Excvavtions
        lateinit var recyclerView2: RecyclerView
        lateinit var recyclerAdapter2: AdapterExcavations

        recyclerView2 = findViewById(R.id.recycler_excavations)
        recyclerAdapter2 = AdapterExcavations(this)
        recycler_excavations.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = recyclerAdapter2


        val apiinterface2 = ApiExcavations.create().getExc(token2)

        apiinterface2.enqueue(object : Callback<List<excavations>> {
            override fun onResponse(call: Call<List<excavations>>, response: Response<List<excavations>>?) {

                val res = response?.body()

                if (response?.body() != null)
                    recyclerAdapter2.setExcListItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<excavations>>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })



// Utilities

        lateinit var recyclerView3: RecyclerView
        lateinit var recyclerAdapter3: AdapterUtilities

        recyclerView3 = findViewById(R.id.recycler_utilities)
        recyclerAdapter3 = AdapterUtilities(this)
        recycler_utilities.layoutManager = LinearLayoutManager(this)
        recyclerView3.adapter = recyclerAdapter3


        val apiinterface3 = ApiUtilities.create().getUtil(token2)

        apiinterface3.enqueue(object : Callback<List<utilities>> {
            override fun onResponse(call: Call<List<utilities>>, response: Response<List<utilities>>?) {

                val res = response?.body()

                if (response?.body() != null)
                    recyclerAdapter3.setUtilListItemsutil(response.body()!!)

            }

            override fun onFailure(call: Call<List<utilities>>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })

    }
}