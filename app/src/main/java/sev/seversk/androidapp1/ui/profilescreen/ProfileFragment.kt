package sev.seversk.androidapp1.ui.profilescreen

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.profile.profile_settings
import android.provider.MediaStore
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import kotlinx.android.synthetic.main.activity_newproblem.*
import kotlinx.android.synthetic.main.activity_prodile_settings2.*

import kotlinx.android.synthetic.main.fragment_notifications.*
import sev.seversk.androidapp1.R.id.fragment_profile_main
import sev.seversk.androidapp1.profile.newprofileset
import sev.seversk.androidapp1.profile.newprofileset2
import java.io.IOException

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class ProfileFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    @SuppressLint("ResourceType")
    override fun onStart() {
        super.onStart()

// Replace fragments
        val navController = activity?.let { Navigation.findNavController(it, fragment_profile_main) }


      activity?.findViewById<CardView>(R.id.cardButton_profile_appeals)?.setOnClickListener(){
          navController?.navigate(R.id.fragment_appeals)
      }

        activity?.findViewById<CardView>(R.id.cardButton_profile_problems)?.setOnClickListener(){
            navController?.navigate(R.id.fragment_problems)
        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_opross)?.setOnClickListener(){
            navController?.navigate(R.id.fragment_opros)
        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_iniciatives)?.setOnClickListener(){
            navController?.navigate(R.id.fragment_iniciativa)
        }

        activity?.findViewById<CardView>(R.id.card_profile_set)?.setOnClickListener(){
           replaceFragment(newprofileset2())
        }


    }

    private fun replaceFragment(fragment: Fragment){
        val trans = fragmentManager?.beginTransaction()
        trans?.replace(R.id.fragment_cont1, fragment)
        trans?.commit()
    }


}

