package sev.seversk.androidapp1.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import sev.seversk.androidapp1.Autor
import sev.seversk.androidapp1.R

class fragment_nonauth: Fragment(R.layout.fragment_profile_notauth) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        activity?.findViewById<Button>(R.id.button_nonatuth_toauth)?.setOnClickListener(){
            val intent = Intent(context, Autor::class.java)
            startActivity(intent)
        }

        activity?.findViewById<Button>(R.id.button_logot_anon)?.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(context, sev.seversk.androidapp1.startActivity::class.java)
            startActivity(intent)
        }

    }
}