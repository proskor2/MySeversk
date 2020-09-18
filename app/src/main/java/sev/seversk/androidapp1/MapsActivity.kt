package sev.seversk.androidapp1

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Transformations.map
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView


class MapsActivity : AppCompatActivity() {


lateinit var mapview: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        MapKitFactory.setApiKey("3ad79f77-ac08-49b0-af8d-3a39283cd78a")
//        MapKitFactory.initialize(this)
//        setContentView(R.layout.map)
//
//        mapview = findViewById<View>(R.id.mapview) as MapView
//        mapview.getMap().move(
//            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
//            Animation(Animation.Type.SMOOTH, 0F),
//            null
//        )
    }
}