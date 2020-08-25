package ru.seversknet.MySeversk.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import ru.seversknet.MySeversk.R
import kotlinx.android.synthetic.main.fragment_appeals.*
import kotlinx.android.synthetic.main.fragment_appeals.view.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_appeals.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_appeals : Fragment() {

    val json1 = """
    [{
    "code": "35805-88258-68181",
    "dateEnd": "22.12.2019",
    "status": "В работе",
    "responsible": "УЖКХ ТиС Администрации ЗАТО Северск",
    "answer_kind": "Электронной почтой"
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
       val fragmentLayout = inflater.inflate(R.layout.fragment_appeals, container, false)
        val navController = NavHostFragment.findNavController(this)
        fragmentLayout.button_profile_problem.setOnClickListener {navController.navigate(R.id.fragment_problems)}
        fragmentLayout.button_profile_opros.setOnClickListener{navController.navigate(R.id.fragment_opros)}
        fragmentLayout.button_profile_iniciate.setOnClickListener{navController.navigate(R.id.fragment_iniciativa)}

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


                val tex1: String = JSONArray(json1).getJSONObject(0).getString("code")
                val tex2: String = JSONArray(json1).getJSONObject(0).getString("status")
                val tex3: String = JSONArray(json1).getJSONObject(0).getString("answer_kind")
                val tex4: String = JSONArray(json1).getJSONObject(0).getString("dateEnd")
                val tex5: String = JSONArray(json1).getJSONObject(0).getString("responsible")

                activity?.runOnUiThread(){
                    text_profile_appeal_appealnumber?.text = ("Обращение № "+tex1)
                    text_profile_appeal_status_incard?.text = tex2
                    text_profile_appeal_answer?.text = ("Ответ: "+tex3)
                    text_profile_appeal_answer_date?.text = ("до "+tex4)
                    text_profile_apeal_responsible?.text = ("Ответственный: "+tex5)
                }
            }



//            companion object {
//                @JvmStatic
//                fun newInstance(param1: String, param2: String) =
//                    fragment_appeals().apply {
//                        arguments = Bundle().apply {
//                            putString(ARG_PARAM1, param1)
//                            putString(ARG_PARAM2, param2)
//                        }
//                    }
//            }
        })


    }
}