package sev.seversk.androidapp1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import sev.seversk.androidapp1.activities_appeal.activitiy_request
import sev.seversk.androidapp1.activities_appeal.appeal_problem
import sev.seversk.androidapp1.activities_appeal.appeal_iniciate


import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_seversk.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.coroutines.tasks.await
import sev.seversk.androidapp1.profile.fragment_nonauth

class seversk() : AppCompatActivity() {

    private lateinit var editname: EditText
    private lateinit var newtext: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk)

        val auth = FirebaseAuth.getInstance().currentUser
        val auth2 = FirebaseAuth.getInstance().currentUser?.isAnonymous
        val token = FirebaseAuth.getInstance().currentUser?.uid


        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notification)
        )

        navView.setupWithNavController(navController)





        test_button.setOnClickListener(){



            if (auth == null || auth2 == true) {

                val view = layoutInflater.inflate(R.layout.fragment_profile_nonauth2, null)
                val dialog = BottomSheetDialog(this)
                dialog.setContentView(view)
                dialog.show()

            } else {



                val view = layoutInflater.inflate(R.layout.fragment_dashboard, null)
                val dialog = BottomSheetDialog(this)
                dialog.setContentView(view)
                dialog.show()
                view.button_request.setOnClickListener() {
                    val appeal1 = Intent(this@seversk, activitiy_request::class.java)
                    startActivity(appeal1)
                }
                view.button_problems123.setOnClickListener() {
                    val appeal2 = Intent(this@seversk, appeal_problem::class.java)
                    startActivity(appeal2)
                }
                view.button_iniciate.setOnClickListener() {
                    val appeal3 = Intent(this@seversk, appeal_iniciate::class.java)
                    startActivity(appeal3)
                }

            }
        }
        test_button2.setOnClickListener(){



            if (auth == null || auth2 == true) {
                val view = layoutInflater.inflate(R.layout.fragment_profile_nonauth2, null)
                val dialog = BottomSheetDialog(this)
                dialog.setContentView(view)
                dialog.show()

            } else {

                val view = layoutInflater.inflate(R.layout.fragment_dashboard, null)
                val dialog = BottomSheetDialog(this)
                dialog.setContentView(view)
                dialog.show()
                view.button_request.setOnClickListener() {
                    val appeal1 = Intent(this@seversk, activitiy_request::class.java)
                    startActivity(appeal1)
                }
                view.button_problems123.setOnClickListener() {
                    val appeal2 = Intent(this@seversk, appeal_problem::class.java)
                    startActivity(appeal2)
                }
                view.button_iniciate.setOnClickListener() {
                    val appeal3 = Intent(this@seversk, appeal_iniciate::class.java)
                    startActivity(appeal3)
                }

            }

}





}}