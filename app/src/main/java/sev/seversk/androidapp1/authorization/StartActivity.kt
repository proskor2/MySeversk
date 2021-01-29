package sev.seversk.androidapp1.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.viewpager.widget.ViewPager
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import sev.seversk.androidapp1.R

class startActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(applicationContext)


        var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser == null) {

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_main)
            val viewPager: ViewPager = findViewById(R.id.viewPagerMS);
            val adapter: ImageAdapter =
                ImageAdapter(this)
            viewPager.adapter = adapter

            login1.setOnClickListener() {
                var autor2 = Intent(this@startActivity, Autor::class.java)
                startActivity(autor2)
                finish()
            }

        } else {
            val intent = Intent (this, seversk::class.java)
            startActivity(intent)

        }
    }
}

