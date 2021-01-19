package sev.seversk.androidapp1.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.sms
import java.util.zip.Inflater

class newprofileset: Fragment(){

    private var auth: FirebaseAuth? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLayoutInflater = inflater.inflate(R.layout.fragment_profile1, container, false)
        return fragmentLayoutInflater
    }

    override fun onStart() {
        super.onStart()

        activity?.findViewById<CardView>(R.id.card_profile_set)?.setOnClickListener(){
            val intent = Intent(context, newprofileset3::class.java)
            startActivity(intent)
        }

        activity?.findViewById<Button>(R.id.butto_logout)?.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(context, sev.seversk.androidapp1.startActivity::class.java)
            startActivity(intent)
        }


    }

}