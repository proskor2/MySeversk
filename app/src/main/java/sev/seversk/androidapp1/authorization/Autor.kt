package sev.seversk.androidapp1.authorization

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_autor.*
import sev.seversk.androidapp1.R


class Autor : AppCompatActivity() {


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
        setContentView(R.layout.activity_autor)


        val phonenum = findViewById<EditText>(R.id.editTextPhone3).text

        val auth = FirebaseAuth.getInstance()


// Later autorization
        autor_later.setOnClickListener() {

            if (auth.currentUser?.isAnonymous == true){

                Toast.makeText(this, "Анонимный поьлзователь", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, seversk::class.java)
                startActivity(intent)

            } else {

                auth.signInAnonymously().addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(applicationContext,
                            "signInAnonymously:success",
                            Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                        updateUI(user)


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(applicationContext,
                            "signInAnonymously:failure",
                            Toast.LENGTH_SHORT).show()
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)


                    }

                    val autor_later = Intent(Intent(this@Autor, seversk::class.java))
                    startActivity(autor_later)
                }
            }
        }

//Move to SMS
        but_autor.setOnClickListener() {
            if (phonenum.isEmpty() || phonenum.count().toInt() < 10) {
                Toast.makeText(this, R.string.errorphone, Toast.LENGTH_SHORT).show()

            } else {
                val autor_sms = Intent(this@Autor, sms::class.java)
                autor_sms.putExtra("phonenumber", phonenum.toString())
                startActivity(autor_sms)

            }

            linearLayout3.setOnClickListener() {
                hideKeyboard()
            }

        }

    }
}

    private fun updateUI(user: FirebaseUser?) {
        val isSignedIn = user != null

    }












