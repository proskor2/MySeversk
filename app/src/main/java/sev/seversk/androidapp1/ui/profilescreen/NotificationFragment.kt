package sev.seversk.androidapp1.ui.profilescreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.profile.profile_settings

import kotlinx.android.synthetic.main.fragment_notifications.*

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
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }



    @SuppressLint("ResourceType")
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

        activity?.findViewById<Button>(R.id.button_profile_settings2)?.setOnClickListener(){
            val settings1 = Intent (this@NotificationFragment.context, profile_settings::class.java)
            startActivity(settings1)

        }


//
//        val navHostFragment = NavHostFragment.create(R.id.routes)
//        val navController = navHostFragment.navController




      activity?.findViewById<CardView>(R.id.cardButton_profile_appeals)?.setOnClickListener(){
          Toast.makeText(context, "Обращения", Toast.LENGTH_SHORT).show()


      }

        activity?.findViewById<CardView>(R.id.cardButton_profile_problems)?.setOnClickListener(){
            Toast.makeText(context, "Проблемы", Toast.LENGTH_SHORT).show()

        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_opross)?.setOnClickListener(){
            Toast.makeText(context, "Опросы", Toast.LENGTH_SHORT).show()

        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_iniciatives)?.setOnClickListener(){
            Toast.makeText(context, "Предложения", Toast.LENGTH_SHORT).show()

        }



    }









}

