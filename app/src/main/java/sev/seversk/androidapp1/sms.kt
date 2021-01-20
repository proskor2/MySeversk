package sev.seversk.androidapp1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_sms.*
import java.util.concurrent.TimeUnit

class sms : AppCompatActivity() {

    private var mVerificationId: String? = null
    private var mAuth: FirebaseAuth? = null
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken


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
        setContentView(R.layout.activity_sms)

        val token = FirebaseAuth.getInstance().getAccessToken(true)


        val getphonenum = intent.extras?.get("phonenumber")
        mAuth = FirebaseAuth.getInstance()

        val smsField = findViewById<EditText>(R.id.edit_smspass)






        @Suppress("DEPRECATION")
        PhoneAuthProvider.getInstance().verifyPhoneNumber("+7$getphonenum", 60, TimeUnit.SECONDS, this, callback)


        // move to My Seversk screen
        but_sms.setOnClickListener(){
            if (smsField.text.isEmpty() || smsField.text.length < 6){
                Toast.makeText(this.applicationContext, "Пожалуйста введите корректный код", Toast.LENGTH_SHORT).show()
            } else {
            verifyVerificationCode(smsField.text.toString())
            val autor_mysev = Intent (this@sms, seversk::class.java)
            startActivity(autor_mysev)
                finish()
            }
        }



        // SMS once again
        text_resms.setOnClickListener(){
            val resms = Toast.makeText(applicationContext, "Мы повторно выслали Вам код", Toast.LENGTH_SHORT)
            resms.show()

        }


        // Button back
        left_button.setOnClickListener(){
            val left1 = Intent(this@sms, Autor::class.java)
            startActivity(left1)
            finish()
        }
        linearlayout4.setOnClickListener(){
            hideKeyboard()
        }
    }


    private val callback: PhoneAuthProvider.OnVerificationStateChangedCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            val code = p0.smsCode
            if (code != null) {
                verifyVerificationCode(code)

            }
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            if (p0 is FirebaseAuthInvalidCredentialsException) {
                Toast.makeText(applicationContext, p0.message, Toast.LENGTH_LONG).show()
            } else if (p0 is FirebaseTooManyRequestsException) {
                Toast.makeText(applicationContext, p0.message, Toast.LENGTH_LONG).show()
            }
        }

//        override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
//            mVerificationId = verificationId
//            resendToken = token
//        }

        override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(s, forceResendingToken)
            mVerificationId = s
//        mResendToken = forceResendingToken
        }
    }

    private fun verifyVerificationCode(code: String){

        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)
        signInWithPhoneCredential(credential)

    }



    private fun signInWithPhoneCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this, OnCompleteListener<AuthResult?> { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, seversk::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
    }

}


