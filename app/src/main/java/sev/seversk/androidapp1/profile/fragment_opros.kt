package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.fragment_appeals.view.*
import kotlinx.android.synthetic.main.fragment_opros.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_opros.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_opros : Fragment() {

    val json1 = """
    [{
    "title": "Социологический опрос для определения пользователей транспортной системы Томской агломерации",
    "status": "Активный",
    "ready": "Начат",
    "questions": "12"
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
        val fragmentLayout = inflater.inflate(R.layout.fragment_opros, container, false)


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
                val tex3: String = JSONArray(json1).getJSONObject(0).getString("ready")
                val tex4: String = JSONArray(json1).getJSONObject(0).getString("questions")

                activity?.runOnUiThread(){
                    text_profile_opros_title?.text = tex1
                    text_profile_opros_status?.text = tex2
                    text_profile_opros_ready?.text = tex3
                    text_profile_opros_questions?.text = ("Вопросов: "+tex4)
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
         * @return A new instance of fragment fragment_opros.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_opros().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}