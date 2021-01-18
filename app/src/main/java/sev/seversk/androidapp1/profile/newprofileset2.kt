package sev.seversk.androidapp1.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_newproblem.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.ui.profilescreen.ProfileFragment
import java.io.IOException


@Suppress("DEPRECATION")
class newprofileset2: Fragment()  {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentInflater = inflater.inflate(R.layout.activity_prodile_settings2, container, false)

        return fragmentInflater
    }



    override fun onStart() {
        super.onStart()

        loadData()

        activity?.findViewById<Button>(R.id.button_profile2_save)?.setOnClickListener(){
            saveData()
            Toast.makeText(this.context, "Сохранено", Toast.LENGTH_SHORT).show()
        }

        activity?.findViewById<ImageButton>(R.id.button_profile2_back)?.setOnClickListener(){
            replaceFragment(ProfileFragment())
        }


    }

    private fun replaceFragment(fragment: Fragment){
        val trans = fragmentManager?.beginTransaction()
        trans?.replace(R.id.fragment_cont1, fragment)
        trans?.commit()
    }



    fun saveData(){
        var usersurname = activity?.findViewById<EditText>(R.id.set_profile_surname)
        var username = activity?.findViewById<EditText>(R.id.set_profile_name)
        var userpatr = activity?.findViewById<EditText>(R.id.set_profile_secondname)
        var usergender = activity?.findViewById<EditText>(R.id.set_profile_swx)
        var userdate = activity?.findViewById<EditText>(R.id.set_profile_dateBirth)
        var usermail = activity?.findViewById<EditText>(R.id.set_profile_email)
        var useraddress = activity?.findViewById<EditText>(R.id.set_profile_address)
        var userphone = activity?.findViewById<EditText>(R.id.set_profile_phone)

        var insertsurname = usersurname?.text
        var insertname = username?.text
        var insertpatr = userpatr?.text
        var insertphone = userphone?.text
        var insertdate = userdate?.text
        var insertmail = usermail?.text
        var insertaddress = useraddress?.text
        var insertgender = usergender?.text

        val sharedPreferences = activity?.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString("surname", insertsurname.toString())
        editor?.putString("name", insertname.toString())
        editor?.putString("patr", insertpatr.toString())
        editor?.putString("phone", insertphone.toString())
        editor?.putString("date", insertdate.toString())
        editor?.putString("mail", insertmail.toString())
        editor?.putString("address", insertaddress.toString())
        editor?.putString("gender", insertgender.toString())
        editor?.apply()

    }

    fun loadData(){
        val sharedPreferences = activity?.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val savedsurname = sharedPreferences?.getString("surname", null)
        val savedname = sharedPreferences?.getString("name", null)
        val savedpatr = sharedPreferences?.getString("patr", null)
        val savedphone = sharedPreferences?.getString("phone", null)
        val saveddate = sharedPreferences?.getString("date", null)
        val savedmail = sharedPreferences?.getString("mail", null)
        val savedaddress = sharedPreferences?.getString("address", null)
        val savedgender = sharedPreferences?.getString("gender", null)

        var usersurname = activity?.findViewById<EditText>(R.id.set_profile_surname)
        var username = activity?.findViewById<EditText>(R.id.set_profile_name)
        var userpatr = activity?.findViewById<EditText>(R.id.set_profile_secondname)
        var usergender = activity?.findViewById<EditText>(R.id.set_profile_swx)
        var userdate = activity?.findViewById<EditText>(R.id.set_profile_dateBirth)
        var usermail = activity?.findViewById<EditText>(R.id.set_profile_email)
        var useraddress = activity?.findViewById<EditText>(R.id.set_profile_address)
        var userphone = activity?.findViewById<EditText>(R.id.set_profile_phone)

        usersurname?.setText(savedsurname)
        username?.setText(savedname)
        userpatr?.setText(savedpatr)
        userphone?.setText(savedphone)
        userdate?.setText(saveddate)
        usermail?.setText(savedmail)
         useraddress?.setText(savedaddress)
        usergender?.setText(savedgender)


    }






    }








