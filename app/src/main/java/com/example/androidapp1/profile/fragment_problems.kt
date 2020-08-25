package com.example.androidapp1.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.androidapp1.R
import kotlinx.android.synthetic.main.fragment_appeals.view.*
import kotlinx.android.synthetic.main.fragment_appeals.view.button_profile_appeal
import kotlinx.android.synthetic.main.fragment_appeals.view.button_profile_iniciate
import kotlinx.android.synthetic.main.fragment_appeals.view.button_profile_opros
import kotlinx.android.synthetic.main.fragment_opros.*
import kotlinx.android.synthetic.main.fragment_problems.*
import kotlinx.android.synthetic.main.fragment_problems.view.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_problems.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_problems : Fragment() {
    val json1 = """
    [{
    "title": "Неубранный мусор",
    "surname": "Прошенкин",
    "name": "Станислав",
    "status": "В работе",
    "descr": "От 2 гимназии, вдоль забора до пеше..."
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
        val fragmentLayout = inflater.inflate(R.layout.fragment_problems, container, false)
        val navController = NavHostFragment.findNavController(this)
        fragmentLayout.button_profile_appeal.setOnClickListener {navController.navigate(R.id.fragment_appeals)}
        fragmentLayout.button_profile_opros.setOnClickListener{navController.navigate(R.id.fragment_opros)}
        fragmentLayout.button_profile_iniciate.setOnClickListener{navController.navigate(R.id.fragment_iniciativa)}
        fragmentLayout.linear2.setOnClickListener{navController.navigate(R.id.problem_detail1)}

        return fragmentLayout
    }

    override fun onStart() {
        super.onStart()


        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {


                val tex1: String = JSONArray(json1).getJSONObject(0).getString("title")
                val tex2: String = JSONArray(json1).getJSONObject(0).getString("status")
                val tex3: String = JSONArray(json1).getJSONObject(0).getString("surname")
                val tex4: String = JSONArray(json1).getJSONObject(0).getString("name")
                val tex5: String = JSONArray(json1).getJSONObject(0).getString("descr")

                activity?.runOnUiThread() {
                    text_profile_problem_title?.text = tex1
                    text_profile_problem_autor?.text = ("Автор: " + tex3 + " " + tex4)
                    text_profile_problem_status?.text = tex2
                    text_profile_problem_descr?.text = tex5
                }
            }


        })


    }
}