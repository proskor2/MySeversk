package com.example.androidapp1.ui.profilescreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.androidapp1.R
import com.example.androidapp1.profile.profile_settings
import kotlinx.android.synthetic.main.activity_prodile_settings2.*

import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*

@Suppress("UNREACHABLE_CODE")
class NotificationFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }

    override fun onStart() {
        super.onStart()

        fun addPhoto1(){
            val addpick = Intent(Intent.ACTION_PICK)
            addpick.setType("image/*")
            startActivityForResult(addpick,1)
            val one = addpick.data
            image_profile.setImageURI(one)
        }
        image_profile_card.setOnClickListener(){
            addPhoto1()
        }

        button_profile_settings.setOnClickListener(){
            val settings1 = Intent (this@NotificationFragment.context, profile_settings::class.java)
            startActivity(settings1)

        }


    }

}