package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.liftric.kvault.KVault
import okhttp3.*
import org.json.JSONObject
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_appeal.activitiy_request
import java.io.IOException

class newprofileset: Fragment() {

    private var auth: FirebaseAuth? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLayoutInflater = inflater.inflate(R.layout.fragment_profile1, container, false)
        return fragmentLayoutInflater
    }

    override fun onStart() {
        super.onStart()

//        val sharedPreferences = activity?.getSharedPreferences("profiles", Context.MODE_PRIVATE)
//        val editor = sharedPreferences?.edit()
//        val cardname = sharedPreferences?.getString("name", " ")
//        val cardsurname = sharedPreferences?.getString("surname", " ")
//        val newname = "$cardname $cardsurname"
        val cardnamesurname = activity?.findViewById<TextView>(R.id.profile_setcard_name)
//        cardnamesurname?.text = newname

        activity?.findViewById<CardView>(R.id.card_profile_set)?.setOnClickListener {
            val intent = Intent(context, profile_settings::class.java)
            startActivity(intent)
        }

        val imview = activity?.findViewById<ImageView>(R.id.image_profile2)

        val getstring = KVault(context = activity?.applicationContext!!)
        val newtoken = getstring.string("TOKEN")

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/profile/get"

        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", "Bearer " + newtoken).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {

                val json = response.body()?.string()
                val parentObject = JSONObject(json)

                val javatar = parentObject.getString("avatar")
                val jname = parentObject.getString("firstName")
                val jsurname = parentObject.getString("lastName")

                activity?.runOnUiThread {

                  if (jname != "null") {
                      cardnamesurname?.text = jname
                      if (jsurname != "null"){
                          cardnamesurname?.text = "$jname $jsurname"
                      }
                  }
                    
                    if (javatar != null) {
                        Glide.with(this@newprofileset)
                            .load(javatar)
                            .into(imview!!)
                    }
                }
            }
        })
    }
}