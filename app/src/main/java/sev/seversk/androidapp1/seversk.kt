package sev.seversk.androidapp1

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import sev.seversk.androidapp1.activities_appeal.activitiy_request
import sev.seversk.androidapp1.activities_appeal.appeal_problem
import sev.seversk.androidapp1.activities_appeal.appeal_iniciate


import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_seversk.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class seversk() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seversk)

//        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
//        StrictMode.setThreadPolicy(policy)
// Navigation (bottom bar)

//        val exampleList = ArrayList<News_data>()
//        val adapter = News_adapter(exampleList, this)
//        recylcer_news.adapter = adapter
//        recylcer_news.layoutManager = LinearLayoutManager(this)
//        recylcer_news.setHasFixedSize(true)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notification)
        )

        navView.setupWithNavController(navController)


        test_button.setOnClickListener(){
            val view = layoutInflater.inflate(R.layout.fragment_dashboard, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
            view.button_request.setOnClickListener(){
                val appeal1 = Intent(this@seversk, activitiy_request::class.java)
                startActivity(appeal1)
            }
            view.button_problems123.setOnClickListener(){
                val appeal2 = Intent(this@seversk, appeal_problem::class.java)
                startActivity(appeal2)
            }
            view.button_iniciate.setOnClickListener(){
                val appeal3 = Intent(this@seversk, appeal_iniciate::class.java)
                startActivity(appeal3)
            }
        }
        test_button2.setOnClickListener(){
            val view = layoutInflater.inflate(R.layout.fragment_dashboard, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
            view.button_request.setOnClickListener(){
                val appeal1 = Intent(this@seversk, activitiy_request::class.java)
                startActivity(appeal1)
            }
           view.button_problems123.setOnClickListener(){
               val appeal2 = Intent(this@seversk, appeal_problem::class.java)
               startActivity(appeal2)
           }
            view.button_iniciate.setOnClickListener(){
                val appeal3 = Intent(this@seversk, appeal_iniciate::class.java)
                startActivity(appeal3)
            }


}

}



}