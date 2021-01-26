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
                val kVault = KVault(context = applicationContext)
                FirebaseAuth.getInstance().currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
                    val token: String? = task.result?.getToken()
                    kVault.set("TOKEN", token.toString())
                }

                val newtoken = kVault.string("TOKEN").toString()
                val phonenumber = kVault.string("PHONENUM").toString()

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

            val getNameField = findViewById<EditText>(R.id.preset_name).text.toString()
            editor?.putString("name", getNameField)
            editor?.apply()

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


}
