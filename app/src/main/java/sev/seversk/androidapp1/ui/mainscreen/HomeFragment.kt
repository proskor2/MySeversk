@file:Suppress("DEPRECATION")

package sev.seversk.androidapp1.ui.mainscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.emergency.szo_details
import sev.seversk.androidapp1.news_items.ApiInterface
import sev.seversk.androidapp1.news_items.News
import sev.seversk.androidapp1.news_items.RecyclerAdapter
import sev.seversk.androidapp1.profile.profile_settings
import sev.seversk.androidapp1.yandex_maps

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }


    override fun onStart() {
        super.onStart()

        var auth = FirebaseAuth.getInstance().currentUser
        var auth2 = FirebaseAuth.getInstance().currentUser?.isAnonymous

        val sharedPreferences = activity?.getSharedPreferences("profiles", Context.MODE_PRIVATE)
        val token = sharedPreferences?.getString("token", null)
        val token2 = "Bearer $token"

        button_news.setOnClickListener {
            val news = Intent(context, news::class.java)
            startActivity(news)
        }
        button_events.setOnClickListener {
            val event = Intent(context, events::class.java)
            startActivity(event)
        }
        button_opros.setOnClickListener {
            val opros = Intent(context, opros::class.java)
            startActivity(opros)
        }
        button_transport.setOnClickListener {
            val transport = Intent(context, transport::class.java)
            startActivity(transport)
        }
        button_problems123.setOnClickListener {
            val problems = Intent(context, problem::class.java)
            startActivity(problems)
        }
        button_offers.setOnClickListener {
            val offer = Intent(context, appeal::class.java)
            startActivity(offer)
        }
//        card_news1.setOnClickListener(){
//            val newact = Intent(this@HomeFragment.context, newsid::class.java)
//            startActivity(newact)
//        }

        button_map.setOnClickListener {
            val map1 = Intent(context, yandex_maps::class.java)
            startActivity(map1)
        }

        button_alerts.setOnClickListener {
            val alert1 = Intent(context, alerts::class.java)
            startActivity(alert1)
        }

        button_emergency.setOnClickListener {
            val remont1 = Intent(context, szo::class.java)
            startActivity(remont1)
        }
        button_district.setOnClickListener {
            val distr1 = Intent(context, district::class.java)
            startActivity(distr1)
        }
        button_service.setOnClickListener {
            val serv1 = Intent(context, remont::class.java)
            startActivity(serv1)
        }

        activity?.findViewById<ImageButton>(R.id.button_tosettings)?.setOnClickListener {

                    if (auth == null || auth2 == true) {
                        Toast.makeText(context, "Пожалуйста авторизуйтесь", Toast.LENGTH_SHORT).show()
                    } else {
                        val intent = Intent(context, profile_settings::class.java)
                        startActivity(intent)
                    }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////


//        recycler_activ.apply {
//            layoutManager = LinearLayoutManager(activity)
//            recyclerAdapter = ActivAdapter(context)
//            this.adapter = recyclerAdapter
//        }
//
//
//        val apiinterface = ApiActivity.create().getActiv()
//
//        apiinterface.enqueue(object : Callback<List<Activ>> {
//            override fun onResponse(call: Call<List<Activ>>, response: Response<List<Activ>>?) {
//                if (response?.body() != null)
//                    recyclerAdapter.setActivListItems(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<List<Activ>>, t: Throwable) {
////                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       recycler_activ.apply {
           layoutManager = LinearLayoutManager(activity)
            recyclerAdapter = RecyclerAdapter(context)
            adapter = recyclerAdapter
       }
        val apiinterface = ApiInterface.create().getNews(token2)

        apiinterface.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setNewsListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

















