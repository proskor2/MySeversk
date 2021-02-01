package sev.seversk.androidapp1.authorization

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_preset3.*
import sev.seversk.androidapp1.R

class preset1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset1)

        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()


        findViewById<Button>(R.id.button_preset1_back3).setOnClickListener(){
            val intent = Intent(this, preset3::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_preset1_next).setOnClickListener(){
            val builder = AlertDialog.Builder(this@preset1)
            builder.setMessage(R.string.privacyText)
            builder.setPositiveButton("Да") { dialog, which ->

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                val getNameField = findViewById<EditText>(R.id.preset_name).text.toString()
                editor?.putString("name", getNameField)
                editor?.apply()

                val kVault = KVault(context = applicationContext)
                val newtoken = kVault.string("TOKEN").toString()
                val phonenumber = kVault.string("PHONENUM").toString()
                val phone = "+7$phonenumber"
                val createname = getNameField
                val creategender = sharedPreferences.getString("gender", null).toString()
                val gender = if (creategender == "Мужской") 1 else 0
                val createdate = sharedPreferences.getString("date", null).toString()

               createNewUser(createname,gender,createdate, newtoken,phone)

                val intent = Intent(this, seversk::class.java)
                startActivity(intent)
                finish()

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }

            builder.setNegativeButton("Отмена") {dialog, which ->
                FirebaseAuth.getInstance().currentUser?.delete()
                val intent = Intent(this, Autor::class.java) 
                startActivity(intent)

            }

            val dialog: AlertDialog = builder.create()

            dialog.show()

        }

        findViewById<LinearLayout>(R.id.linear_name).setOnClickListener(){
            hideKeyboard()
        }


        findViewById<TextView>(R.id.privacy_policy).setOnClickListener(){
            val url = "https://xn----7sbhlbh0a1awgee.xn--p1ai/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.privacy_rules).setOnClickListener(){
            val url = "https://xn----7sbhlbh0a1awgee.xn--p1ai/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        else {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }

    fun createNewUser(firstName: String, gender: Int, birthday: String, token: String, phone: String) {
        val apiService = RestCreateUser()
        val createUserInfo = createUserInfo( id = null,
            token = token,
            phone = phone,
        name = firstName,
        gender = gender,
        birthday = birthday

       )

        apiService.addUser(createUserInfo) {
            if (it?.id != null) {
                // it = newly added user parsed as response
                // it?.id = newly added user ID
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
