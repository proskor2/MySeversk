package sev.seversk.androidapp1.transport_items

import android.annotation.SuppressLint
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

        }
// Button bus stops
        val butstops = findViewById<TextView>(R.id.busdetail_stops)
        butstops.setOnClickListener(){
            butstops.setTextColor(R.color.otherColor)

        }
// Button bus carriers
        val butcarriers = findViewById<TextView>(R.id.busdetail_owners)
        butcarriers.setOnClickListener(){
            butcarriers.setTextColor(R.color.otherColor)

        }
// Button vehicles
        val butvehicles = findViewById<TextView>(R.id.busdetail_vehicles)
        butvehicles.setOnClickListener(){
            butvehicles.setTextColor(R.color.otherColor)

        }
    }
}