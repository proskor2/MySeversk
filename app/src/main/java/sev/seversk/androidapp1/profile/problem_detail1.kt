package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.fragment_detail_problem0.*
import kotlinx.android.synthetic.main.fragment_detail_problem0.view.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [problem_detail1.newInstance] factory method to
 * create an instance of this fragment.
 */
class problem_detail1 : Fragment() {

// Example json
    val json1 = """
    [{
"id": 130,
"code": "35805-88258-68181",
"dateEnd": "05.10.2019",
"status": "В работе",
"title": "Неубранный мусор",
"text": "в лесном массиве за домом 63 по пр.Коммунистический куча мусора, которую сотрудники ЖЭУ обходят стороной, такую картину я уже несколько раз видела. Неприятный вид из окна и запах.",
"comments_count": "3",
"autor": "Мария Эдуардовна",
"adress": "636000, Томская обл., г.Северск, пр.Коммунистический 63",
"followers_count": "11"
}]
""".trimIndent()



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
        val fragmentLayout = inflater.inflate(R.layout.fragment_detail_problem0, container, false)
        val navController = NavHostFragment.findNavController(this)
        fragmentLayout.button_detailproblem_back.setOnClickListener{navController.navigate(R.id.fragment_problems)}
        return fragmentLayout
    }

// Insert JSON
    override fun onStart() {
        super.onStart()

        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news?page=1&per-page=10"
        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",token).build()
        val response = Response.Builder().addHeader("Authorization",token).build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {


                val tex1: String = JSONArray(json1).getJSONObject(0).getString("title")
                val tex2: String = JSONArray(json1).getJSONObject(0).getString("dateEnd")
                val tex3: String = JSONArray(json1).getJSONObject(0).getString("text")
                val tex4: String = JSONArray(json1).getJSONObject(0).getString("comments_count")
                val tex5: String = JSONArray(json1).getJSONObject(0).getString("followers_count")
                val tex6: String = JSONArray(json1).getJSONObject(0).getString("status")
                val tex7: String = JSONArray(json1).getJSONObject(0).getString("adress")
                val tex8: String = JSONArray(json1).getJSONObject(0).getString("autor")



                activity?.runOnUiThread(){
                    text_detailproblem_title?.text = tex1
                    text_detailproblem_date1?.text = tex2
                    text_detailproblem_descr?.text = tex3
                    text_detailproblem_countcomments?.text = ("Комментарии "+"("+tex4+")")
                    text_detailproblem_countpeople?.text = tex5
                    text_detailproblem_status?.text = tex6
                    text_detailproblem_adress?.text = tex7
                    text_detailproblem_autor?.text = tex8
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
         * @return A new instance of fragment problem_detail1.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            problem_detail1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}