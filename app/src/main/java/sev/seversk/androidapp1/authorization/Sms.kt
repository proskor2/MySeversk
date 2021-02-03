package sev.seversk.androidapp1.authorization

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
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_sms.*
import sev.seversk.androidapp1.R
import java.util.concurrent.TimeUnit

class sms : AppCompatActivity() {
// global
    private var mVerificationId: String? = null
    private lateinit var mAuth: FirebaseAuth
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
// onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

    val smsField = findViewById<EditText>(R.id.edit_smspass)
    mAuth = FirebaseAuth.getInstance()

// get Phone number and Code number(+n)
        val getphonenum = intent.extras?.get("phonenumber")
        val codenum = intent.extras?.get("codenumber")
        val phonenum = "$codenum$getphonenum"

// Save phonenumber in prefs
    val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("phone", phonenum)
    editor.apply()

    val kVault = KVault(context = applicationContext)
    kVault.set("PHONE", phonenum)


    // FB verify phonenum
    @Suppress("DEPRECATION")
    PhoneAuthProvider.getInstance().verifyPhoneNumber(phonenum, 60, TimeUnit.SECONDS, this, callback)


// SMS resend
        text_resms.setOnClickListener(){
            Toast.makeText(applicationContext, "Мы повторно выслали Вам код", Toast.LENGTH_SHORT).show()
            resendVerificationCode(phonenum, resendToken )
        }

// Button back
        left_button.setOnClickListener(){
            val left1 = Intent(this@sms, Autor::class.java)
            startActivity(left1)
            finish()
        }

// hide keyboard
        linearlayout4.setOnClickListener(){
            hideKeyboard()
        }



    // move to My Seversk screen
    but_sms.setOnClickListener(){

        if (smsField.text.isEmpty() || smsField.text.length < 6){
            Toast.makeText(this.applicationContext, "Пожалуйста введите корректный код", Toast.LENGTH_SHORT).show()
        } else {

            verifyVerificationCode(smsField.text.toString())
//            val tokenget = sharedPreferences.getString("token", null)
//            addTokenUser(tokenget.toString(), phonenum)
        }
    }
    }
 /////////////////////////////////callback//////////////////////////////////////////////////

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


        override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(s, forceResendingToken)
            mVerificationId = s
        resendToken = forceResendingToken
        }

        /////////////////////////////////callback//////////////////////////////////////////////////
    }

    private fun verifyVerificationCode(code: String){
        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)
        signInWithPhoneCredential(credential)

    }

    private fun resendVerificationCode(
        phoneNumber: String,
        token: PhoneAuthProvider.ForceResendingToken?
    ) {
        val optionsBuilder = PhoneAuthOptions.newBuilder(mAuth!!)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callback)          // OnVerificationStateChangedCallbacks
        if (token != null) {
            optionsBuilder.setForceResendingToken(resendToken) // callback's ForceResendingToken
        }
        PhoneAuthProvider.verifyPhoneNumber(optionsBuilder.build())
    }

    private fun signInWithPhoneCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this, OnCompleteListener<AuthResult?> { task ->
                if (task.isSuccessful) {
// get TOKEN and save to keychain
                    val kVault = KVault(context = applicationContext)
                    val phone2 = kVault.string("PHONE")

                    val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()

                    FirebaseAuth.getInstance().currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val token = task.result?.token.toString()
                            kVault.set("TOKEN", token)
                            editor.putString("token", token)
                            editor.apply()

                            addTokenUser(token, phone2.toString())
                            return@addOnCompleteListener
                        } else {
                            Toast.makeText(this, "Error token", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    Toast.makeText(applicationContext, "Ошибка авторизации. Проверьте введенные данные", Toast.LENGTH_SHORT).show()
                }
            })
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



    fun addTokenUser(token: String, phoneNumber: String) {
        val apiService = RestApiService()
        val tokenInfo = tokenInfo(  status = null,
            code = null,
        token = token,
        phonenumber = phoneNumber)

        apiService.addToken(tokenInfo) {
            if (it?.status == "Токен подтвержден. Обновлены данные пользователя") {
                val intent = Intent(this, seversk::class.java)
                startActivity(intent)
                finish()
            } else if (it?.status == "Токен подтвержден") {
                val intent = Intent(this, preset1::class.java)
                startActivity(intent)
                finish()
        } else if(it?.status == "Токен подтвержден. Анонимный пользователь") {
                val intent = Intent(this, seversk::class.java)
                startActivity(intent)
                finish()
        } else {
                Toast.makeText(this, "Ошибка авторизации", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Autor::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}



