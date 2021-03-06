package sev.seversk.androidapp1.ui.profilescreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import sev.seversk.androidapp1.R
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth

import sev.seversk.androidapp1.R.id.fragment_profile_main
import sev.seversk.androidapp1.profile.fragment_nonauth

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class ProfileFragment : Fragment() {

//    private lateinit var notificationsViewModel: NotificationsViewModel
    private var auth = FirebaseAuth.getInstance().currentUser
    private var auth2 = FirebaseAuth.getInstance().currentUser?.isAnonymous

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (auth == null || auth2 == true) {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment, fragment_nonauth())
            transaction?.commit()
        }

//          notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
            val root = inflater.inflate(R.layout.fragment_profile, container, false)
            return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    @SuppressLint("ResourceType")
    override fun onStart() {
        super.onStart()



// Replace fragments
        val navController = activity?.let { Navigation.findNavController(it, fragment_profile_main) }

        val imcardappeal = activity?.findViewById<ImageView>(R.id.imageView1)
        val imcardproblem = activity?.findViewById<ImageView>(R.id.imageView2)
        val imopros = activity?.findViewById<ImageView>(R.id.imageView3)
        val iminic = activity?.findViewById<ImageView>(R.id.imageView4)

        activity?.findViewById<CardView>(R.id.cardButton_profile_appeals)?.setOnClickListener {
          navController?.navigate(R.id.fragment_appeals)
        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_problems)?.setOnClickListener {
            navController?.navigate(R.id.fragment_problems)
        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_opross)?.setOnClickListener {
            navController?.navigate(R.id.fragment_opros)
        }

        activity?.findViewById<CardView>(R.id.cardButton_profile_iniciatives)?.setOnClickListener {
            navController?.navigate(R.id.fragment_iniciativa)
        }

    }

}

