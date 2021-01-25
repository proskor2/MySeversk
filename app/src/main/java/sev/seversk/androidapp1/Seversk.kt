package sev.seversk.androidapp1.authorization

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import sev.seversk.androidapp1.activities_appeal.activitiy_request
import sev.seversk.androidapp1.activities_appeal.appeal_problem
import sev.seversk.androidapp1.activities_appeal.appeal_iniciate


import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.*
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_seversk.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import sev.seversk.androidapp1.R


class seversk() : AppCompatActivity() {


    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk)




//        FirebaseAuth.getInstance().currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
////            if (!task.isSuccessful) {
////                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
////
////            }
//            // Get new Instance ID token
//            val token: String? = task.result?.getToken()
//            kVault.set("TOKEN", token.toString())
//            // Log and toast
//
//        }



        val intent = intent.extras
        val n1 = intent?.getString("name")
        val n2 = intent?.getString("date")
        val n3 = intent?.getString("gender")


        fun saveData(){
            var insertname = n1
            var insertdate = n2
            var insertgender = n3

            val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.putString("name", insertname.toString())
            editor?.putString("date", insertdate.toString())
            editor?.putString("gender", insertgender.toString())
            editor?.apply()
        }


        val auth = FirebaseAuth.getInstance().currentUser
        val auth2 = FirebaseAuth.getInstance().currentUser?.isAnonymous
        val token = FirebaseAuth.getInstance().currentUser?.uid


        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notification)
//        )




        test_button.setOnClickListener() {

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
        saveData()
}

}


