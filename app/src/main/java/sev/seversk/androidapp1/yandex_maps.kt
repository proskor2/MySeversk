package sev.seversk.androidapp1

import android.content.Context
import android.icu.text.Transliterator
import android.location.Geocoder
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.Animation
import com.yandex.mapkit.GeoObject
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.MapKitFactory.getInstance
import com.yandex.mapkit.geometry.Geo
import com.yandex.mapkit.geometry.Geometry
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.GeoObjectTapEvent
import com.yandex.mapkit.map.*
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.ui_view.ViewProvider
import kotlinx.android.synthetic.main.map.*
import java.util.*

class yandex_maps : AppCompatActivity() {

    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("3ad79f77-ac08-49b0-af8d-3a39283cd78a")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_yandex_maps)

        mapView = findViewById<MapView>(R.id.mapView)
        
       val intent2 = intent.extras
        val lat = intent2?.get("lat").toString().toDouble()
        val long = intent2?.get("long").toString().toDouble()

        addMark(lat, long)

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