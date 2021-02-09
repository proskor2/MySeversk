package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import sev.seversk.androidapp1.R
import kotlinx.android.synthetic.main.fragment_iniciate_detail2.*
import kotlinx.android.synthetic.main.fragment_iniciate_detail2.view.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [iniciate_detail2.newInstance] factory method to
 * create an instance of this fragment.
 */
class iniciate_detail2 : Fragment() {

    val json1 = """
    [{
"id": 130,
"code": "35805-88258-68181",
"dateEnd": "22.12.2018",
"status": "Обработана",
"title": "Мои предложения",
"text": "от 2 гимназии, вдоль забора до пешеходной тропы, заросшие кусты, вместо них можно благоустроить цветочные клумбы.",
"comments_count": "12",
"followers_count": "56",
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
        val fragmentLayout = inflater.inflate(R.layout.fragment_iniciate_detail2, container, false)
        val navController = NavHostFragment.findNavController(this)
        fragmentLayout.button_detailiniciate_back.setOnClickListener{navController.navigate(R.id.fragment_iniciativa)}
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
                val tex2: String = JSONArray(json1).getJSONObject(0).getString("dateEnd")
                val tex3: String = JSONArray(json1).getJSONObject(0).getString("text")
                val tex4: String = JSONArray(json1).getJSONObject(0).getString("comments_count")
                val tex5: String = JSONArray(json1).getJSONObject(0).getString("followers_count")
                val tex6: String = JSONArray(json1).getJSONObject(0).getString("status")


                activity?.runOnUiThread {
                    text_detailiniciate_title?.text = tex1
                    text_detailiniciate_date1?.text = tex2
                    text_detailiniciate_descr?.text = tex3
                    text_detailiniciate_countcomments?.text = ("Комментарии "+"("+tex4+")")
                    text_detailiniciate_countpeople?.text = tex5
                    text_detailinicicate_status?.text = tex6
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
         * @return A new instance of fragment iniciate_detail2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            iniciate_detail2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}