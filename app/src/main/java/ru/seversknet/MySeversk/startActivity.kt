package ru.seversknet.MySeversk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class startActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager = findViewById (R.id.viewPagerMS);
        val adapter: ImageAdapter = ImageAdapter(this)
        viewPager.adapter = adapter

// Move to autorization screen
        login1.setOnClickListener(){
            var autor = Intent (this@startActivity, Autor::class.java)
            startActivity(autor)
        }

//        login1.setOnClickListener(){
//            var autor = Intent (this@startActivity, Autor::class.java)
//        var main = Intent((this@startActivity, seversknet::class.java))
//            if(autorization == 1 ) startActivity(main)
//           else startActivity(autor)
//        }
    }
}

