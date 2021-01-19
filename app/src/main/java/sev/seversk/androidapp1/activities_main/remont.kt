package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import sev.seversk.androidapp1.R

class remont : AppCompatActivity() {

    lateinit var mapView_remont: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        MapKitFactory.setApiKey("3ad79f77-ac08-49b0-af8d-3a39283cd78a")
//        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_remont)

        mapView_remont = findViewById<MapView>(R.id.mapView_remont)
        mapView_remont.getMap().move(
            CameraPosition(Point(56.602855, 84.880908), 15.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }

    override fun onStop() {
        super.onStop()
        mapView_remont.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        mapView_remont.onStart()
        MapKitFactory.getInstance().onStart()

    }
}