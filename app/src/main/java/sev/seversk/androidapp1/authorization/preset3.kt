package sev.seversk.androidapp1.authorization

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.fragment_detail_problem0.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import sev.seversk.androidapp1.R
import java.io.IOException
import java.lang.StringBuilder

class preset3 : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset3)


//click on button next
        findViewById<Button>(R.id.button_preset3_next).setOnClickListener(){
            getGender()
            val intent = Intent(this, preset1::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_preset3_back).setOnClickListener(){
            val intent = Intent(this, preset2::class.java)
            startActivity(intent)
        }


    }
    fun getGender(){

        val gender = findViewById<RadioGroup>(R.id.gender)
        val genderid = gender.checkedRadioButtonId

        if (genderid != -1) {
            val radio: RadioButton = findViewById(genderid)
            val string: String = radio.text.toString()
            val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.putString("gender", string)
            editor?.apply()

            val intent = Intent(this, seversk::class.java)
            intent.putExtra("gender", string)
            startActivity(intent)

        } else {

        }

    }




}