package sev.seversk.androidapp1.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.liftric.kvault.KVault
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.Autor

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
            FirebaseAuth.getInstance().currentUser?.delete()
            val sharedPreferences = activity?.getSharedPreferences("profiles", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.clear()?.apply()
            val intent = Intent(context, Autor::class.java)
            startActivity(intent)
        }

        activity?.findViewById<Button>(R.id.button_logot_anon)?.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(context, sev.seversk.androidapp1.authorization.startActivity::class.java)
            startActivity(intent)
        }

    }
}