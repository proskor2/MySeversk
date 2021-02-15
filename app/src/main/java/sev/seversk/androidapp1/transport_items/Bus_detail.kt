package sev.seversk.androidapp1.transport_items

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_bus_detail.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import sev.seversk.androidapp1.R
import java.io.IOException

class bus_detail : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_detail)
// get data from transort activity
        val intent2 = intent?.extras
        val busnumber = intent2?.get("busnumber").toString()
        val bustitle = intent2?.get("busntitle").toString()
        val busdatebegin = intent2?.get("busdate").toString()
        val buslength = intent2?.get("buslength").toString()
        val buspayrules = intent2?.get("buspayrules").toString()

        val streetF = intent2?.get("streetF").toString()
        val streetB = intent2?.get("streetB").toString()
        val stopF = intent2?.get("stopF").toString()
        val stopB = intent2?.get("stopB").toString()
        val carriers = intent2?.get("carriers").toString()
        val typebus = intent2?.get("typebus").toString()


            findViewById<TextView>(R.id.busdetail_number).text = ("Маршрут №"+busnumber)
            findViewById<TextView>(R.id.busdetail_title).text = bustitle
            findViewById<TextView>(R.id.busdetail_dateBegin).text = busdatebegin
            findViewById<TextView>(R.id.busdetail_length).text = buslength
            findViewById<TextView>(R.id.busdetail_payrules).text = buspayrules
            findViewById<TextView>(R.id.busdetail_stoprules).text = "Только в установленных остановочных пунктах"

  // Button close activity
        findViewById<ImageButton>(R.id.button_closeactivity).setOnClickListener(){
            finish()
        }
// Button bus streets
        val butstreet = findViewById<TextView>(R.id.busdetail_streets)
            butstreet.setOnClickListener(){
            butstreet.setTextColor(R.color.otherColor)
        val title = "Улицы на пути следования"
        val intent = Intent(this, busstreetsstops::class.java)
                intent.putExtra("title", title)
                intent.putExtra("streetF", streetF)
                intent.putExtra("streetB", streetB)
        startActivity(intent)

        }
// Button bus stops
        val butstops = findViewById<TextView>(R.id.busdetail_stops)
        butstops.setOnClickListener(){
            val title = "Остановочные пункты"
            butstops.setTextColor(R.color.otherColor)
            val intent = Intent(this, busstreetsstops::class.java)
            intent.putExtra("title", title)
            intent.putExtra("streetF", stopF)
            intent.putExtra("streetB", stopB)
            startActivity(intent)
        }
// Button bus carriers
        val butcarriers = findViewById<TextView>(R.id.busdetail_owners)
        butcarriers.setOnClickListener(){
            butcarriers.setTextColor(R.color.otherColor)
            val title = "Перевозчики"
            val intent = Intent(this, buscarriersauto::class.java)
            intent.putExtra("title", title)
            intent.putExtra("info", carriers)
            startActivity(intent)

        }
// Button vehicles
        val butvehicles = findViewById<TextView>(R.id.busdetail_vehicles)
        butvehicles.setOnClickListener(){
            butvehicles.setTextColor(R.color.otherColor)
            val title = "Транспортные средства"
            val intent = Intent(this, buscarriersauto::class.java)
            intent.putExtra("title", title)
            intent.putExtra("info", typebus)
            startActivity(intent)

        }
    }
}