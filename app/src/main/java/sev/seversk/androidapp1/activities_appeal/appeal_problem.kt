package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.seversk
import kotlinx.android.synthetic.main.activitiy_appeal_request2.*
import kotlinx.android.synthetic.main.activity_newproblem.*

class appeal_problem : AppCompatActivity() {

    fun AppCompatActivity.hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        else {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newproblem)


//
//        val token = "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi"
//        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/news"
//        var okHttpClient: OkHttpClient = OkHttpClient()
//        val request: Request = Request.Builder().url(URL).addHeader("Authorization", token).build()
//        val response = okHttpClient.newCall(request).execute()
//        val json = response.body()?.string()

//        fun post(url: String, json: String ): String? {
//            val mediaType = MediaType.parse("json2")
//            val body: RequestBody = RequestBody.create(mediaType, json)
//            val request2: Request = Request.Builder().url(URL).post(body).build()
//            val response2: Response = okHttpClient.newCall(request2).execute()
//            return response2.body()?.string()
//        }

        val json2 = 
        button_newproblem_ready.setOnClickListener(){
            val ready1 = Intent(this@appeal_problem, appeal_problem2::class.java)
            startActivity(ready1)
            finish()
        }
        button_appeal_cancel2.setOnClickListener(){
            val appeal3 = Intent(this@appeal_problem, seversk::class.java )
            startActivity(appeal3)
            finish()
        }
        button_problem_addfile.setOnClickListener(){
            val addpick = Intent(Intent.ACTION_PICK)
            addpick.setType("image/*")
            startActivityForResult(addpick,1 )
            val one = addpick.data
            imageView_add.setImageURI(one)
        }
        linear7.setOnClickListener(){
            hideKeyboard()
        }
    }
}