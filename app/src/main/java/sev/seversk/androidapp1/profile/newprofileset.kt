package sev.seversk.androidapp1.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import sev.seversk.androidapp1.R
import java.util.zip.Inflater

class newprofileset: Fragment(){

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

//        activity?.findViewById<CardView>(R.id.card_profile_set)?.setOnClickListener(){
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fragment_cont1, newprofileset2())
//            transaction?.commit()
//
//        }


        activity?.findViewById<CardView>(R.id.card_profile_set)?.setOnClickListener(){
            val intent = Intent(context, newprofileset3::class.java)
            startActivity(intent)


        }

        val extr = activity?.intent?.extras
        val newname = extr?.getString("name")
        val surname = extr?.getString("surname")


    }



}