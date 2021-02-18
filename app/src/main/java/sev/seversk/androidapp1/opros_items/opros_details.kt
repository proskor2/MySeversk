package sev.seversk.androidapp1.opros_items

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_opros_details.*
import kotlinx.android.synthetic.main.activity_seversk_opros.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.seversk

class opros_details : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: questionAdapter


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opros_details)

  findViewById<ImageButton>(R.id.button_backopros).setOnClickListener {
      finish()
  }

        val intent2 = intent.extras
        val idquestionnaires = intent2?.get("idquestionnaire").toString().toInt()

        val kVault = KVault(context = applicationContext)
        val token = kVault.string("TOKEN")
        val token2: String = "Bearer $token"

        recyclerView = findViewById(R.id.recycler_variants)
        recyclerAdapter = questionAdapter(this)
        recycler_variants.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiinterface = questionApi.create().getQuestions(idquestionnaires, token2)

//        apiinterface.enqueue(object : Callback <questions> {
//            override fun onResponse(call: Call<questions>, response: Response<questions>?) {
//                    if (response?.body() != null)
////                        recyclerAdapter.setqListItems(response.body()!!)
//                }
//                override fun onFailure(call: Call<questions>, t: Throwable) {
//                }
//            })
        }

    }
