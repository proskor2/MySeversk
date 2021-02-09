package sev.seversk.androidapp1.authorization

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.liftric.kvault.KVault
import com.rbddevs.splashy.Splashy
import kotlinx.android.synthetic.main.activity_autor.*
import sev.seversk.androidapp1.R


class Autor : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autor)

        linearLayout3.setOnClickListener {
            hideKeyboard()
        }

        val auth = FirebaseAuth.getInstance()

// Later autorization
        val button_later = findViewById<Button>(R.id.autor_later)

        button_later.setOnClickListener {
            button_later.setTextColor(R.color.otherColor)

            if (auth.currentUser?.isAnonymous == true){
                auth.signInAnonymously().addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Ошибка", Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
            }

            val autor_later = Intent(Intent(this@Autor, seversk::class.java))
            startActivity(autor_later)
        }

//Move to SMS
        but_autor.setOnClickListener {

            val phonenum = findViewById<EditText>(R.id.editTextPhone3).text
            val codefield = findViewById<EditText>(R.id.editTextPhone2).text

            val getstring = KVault(context = applicationContext)
            getstring.set("PHONENUM", phonenum.toString())

            if (phonenum.isEmpty() || phonenum.count().toInt() < 10) {
                Toast.makeText(this, R.string.errorphone, Toast.LENGTH_SHORT).show()

            } else {
                val autor_sms = Intent(this@Autor, sms::class.java)
                autor_sms.putExtra("phonenumber", phonenum.toString())
                autor_sms.putExtra("codenumber", codefield.toString())
                startActivity(autor_sms)
            }
        }
    }

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
    private fun updateUI(user: FirebaseUser?) {
        val isSignedIn = user != null

        if (isSignedIn) {
            FirebaseAuth.getInstance().currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val token = task.result?.token
                    val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("TOKEN", token)
                    editor.apply()
                    return@addOnCompleteListener
                } else {
                    Toast.makeText(this, "Error token", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}















