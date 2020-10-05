package sev.seversk.androidapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import sev.seversk.androidapp1.ui.mainscreen.HomeFragment

class startActivity : AppCompatActivity() {

    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var firebaseUser: FirebaseUser? = firebaseAuth.currentUser




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_main)
            val viewPager: ViewPager = findViewById(R.id.viewPagerMS);
            val adapter: ImageAdapter = ImageAdapter(this)
            viewPager.adapter = adapter

// Move to autorization screen
            login1.setOnClickListener() {

                if (firebaseUser == null) {

                var autor = Intent(this@startActivity, Autor::class.java)
                startActivity(autor)
                    finish()
            } else {
                    var autor2 = Intent(this@startActivity, seversk::class.java)
                    startActivity(autor2)
                    finish()

                }
            }






    }
}

