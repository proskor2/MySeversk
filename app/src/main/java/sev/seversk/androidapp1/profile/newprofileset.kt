package sev.seversk.androidapp1.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import sev.seversk.androidapp1.R

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

        val sharedPreferences = activity?.getSharedPreferences("profiles", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        val cardname = sharedPreferences?.getString("name", "Имя")
        val cardsurname = sharedPreferences?.getString("surname", "Фамилия")
        val newname = "$cardname $cardsurname"
        val cardnamesurname = activity?.findViewById<TextView>(R.id.profile_setcard_name)
        cardnamesurname?.setText(newname)


        activity?.findViewById<CardView>(R.id.card_profile_set)?.setOnClickListener(){
            val intent = Intent(context, profile_settings::class.java)
            startActivity(intent)
        }

//        activity?.findViewById<Button>(R.id.butto_logout)?.setOnClickListener(){
//            val sharedPreferences = activity?.getSharedPreferences("profiles", Context.MODE_PRIVATE)
//            val editor = sharedPreferences?.edit()
//            editor?.clear()?.apply()
//            FirebaseAuth.getInstance().signOut()
//            val intent = Intent(context, sev.seversk.androidapp1.authorization.startActivity::class.java)
//            startActivity(intent)
//        }




    }

}