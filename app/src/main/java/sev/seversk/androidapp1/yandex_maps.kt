package sev.seversk.androidapp1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.*
import com.yandex.mapkit.mapview.MapView
import android.Manifest
import androidx.core.app.ActivityCompat

class yandex_maps : AppCompatActivity() {

    private final val MAPKIT_API_KEY = "3ad79f77-ac08-49b0-af8d-3a39283cd78a";
    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        MapKitFactory.initialize(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yandex_maps)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)

        mapView = findViewById<MapView>(R.id.mapView)
        
       val intent2 = intent?.extras
        if (intent2 != null) {
            val lat = intent2?.get("lat").toString().toDouble()
            val long = intent2?.get("long").toString().toDouble()
            addMark(lat, long)
        } else {
            mapView.map.move(CameraPosition(Point(56.602780, 84.880626), 15.0f, 0.0f, 0.0f), Animation(Animation.Type.SMOOTH, 0F), null)

        }
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
    }

    fun addMark (lat: Double, long: Double){
        mapView.map.mapObjects.addPlacemark(Point(lat, long))
        mapView.map.move(CameraPosition(Point(lat, long), 15.0f, 0.0f, 0.0f), Animation(Animation.Type.SMOOTH, 0F), null)
    }
}