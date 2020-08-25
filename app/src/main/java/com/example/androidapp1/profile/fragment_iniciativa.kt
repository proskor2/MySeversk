package com.example.androidapp1.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.androidapp1.R
import kotlinx.android.synthetic.main.fragment_appeals.*
import kotlinx.android.synthetic.main.fragment_appeals.view.*
import kotlinx.android.synthetic.main.fragment_appeals.view.button_profile_appeal
import kotlinx.android.synthetic.main.fragment_appeals.view.button_profile_opros
import kotlinx.android.synthetic.main.fragment_appeals.view.button_profile_problem
import kotlinx.android.synthetic.main.fragment_iniciativa.*
import kotlinx.android.synthetic.main.fragment_iniciativa.view.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_iniciativa.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_iniciativa : Fragment() {
    val json1 = """
    [{
"id": 130,
"code": "35805-88258-68181",
"dateBegin": "22.01.2018",
"dateEnd": "22.12.2018",
"status": "Обработана",
"surname": "Прошенкин",
"name": "Станислав",
"patronymic": "Александрович",
"social_status": "Другое",
"title": "Обустроить цветочные клумбы во дворе дома № 15",
"text": "От 2 гимназии, вдоль забора до пешеходной тропы, заросшие кусты, ...",
"comments_count": "",
"followers_count": "",
"files": [""]
}]
""".trimIndent()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentLayout = inflater.inflate(R.layout.fragment_iniciativa, container, false)
        val navController = NavHostFragment.findNavController(this)
        fragmentLayout.button_profile_problem.setOnClickListener {navController.navigate(R.id.fragment_problems)}
        fragmentLayout.button_profile_opros.setOnClickListener{navController.navigate(R.id.fragment_opros)}
        fragmentLayout.button_profile_appeal.setOnClickListener{navController.navigate(R.id.fragment_appeals)}
        fragmentLayout.linear_detail.setOnClickListener{navController.navigate(R.id.iniciate_detail2)}
        return fragmentLayout
    }
    override fun onStart() {
        super.onStart()




        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()


        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
            }


            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {


                val tex1: String = JSONArray(json1).getJSONObject(0).getString("title")
                val tex2: String = JSONArray(json1).getJSONObject(0).getString("status")
                val tex3: String = JSONArray(json1).getJSONObject(0).getString("surname")
                val tex4: String = JSONArray(json1).getJSONObject(0).getString("name")
                val tex5: String = JSONArray(json1).getJSONObject(0).getString("text")

                activity?.runOnUiThread(){
                    text_profile_iniciate_title?.text = (tex1)
                    text_profile_iniciate_status?.text = tex2
                    text_profile_iniciate_autor?.text = ("Автор: "+tex3+" "+tex4)
                    text_profile_iniciate_descr?.text = (tex5)
                }
            }


        })


    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_iniciativa.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_iniciativa().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}