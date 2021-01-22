package sev.seversk.androidapp1

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class token {

    fun getTok() {
        FirebaseAuth.getInstance().currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
            val token: String? = task.result?.getToken()
            return@addOnCompleteListener
        }
    }

}