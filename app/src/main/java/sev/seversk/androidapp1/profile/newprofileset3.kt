package sev.seversk.androidapp1.profile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.liftric.kvault.KVault
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_prodile_settings2.*
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.*
import java.io.*
import java.lang.reflect.Array.set


class newprofileset3: AppCompatActivity() {

    var newtoken: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prodile_settings2)

        loadData()

 // Get token
        val getstring = KVault(context = applicationContext)
        newtoken = getstring.string("TOKEN")

// Hide keyboard
        findViewById<LinearLayout>(R.id.layout1123)?.setOnClickListener(){
            hideKeyboard()
        }

// Button save profile settings
        findViewById<Button>(R.id.button_profile2_save)?.setOnClickListener() {
            saveData()
            Toast.makeText(this, "Изменения сохранены", Toast.LENGTH_SHORT).show()
        }

//  Button return to seversk activity
        findViewById<Button>(R.id.button_profile2_back)?.setOnClickListener(){
            val intent = Intent(this, profile_settings::class.java)
            startActivity(intent)
        }

// Click to set image
        val card_photo = findViewById<CardView>(R.id.add_profilephoto_card)
        card_photo?.setOnClickListener(){
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, 1)
            }
        }

    }

    fun saveData(){
        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)

        var usersurname = findViewById<EditText>(R.id.set_profile_surname)
        var username = findViewById<EditText>(R.id.set_profile_name)
        var userpatr = findViewById<EditText>(R.id.set_profile_secondname)
        var usergender = findViewById<EditText>(R.id.set_profile_swx)
        var userdate = findViewById<EditText>(R.id.set_profile_dateBirth)
        var usermail = findViewById<EditText>(R.id.set_profile_email)
        var useraddress = findViewById<EditText>(R.id.set_profile_address)
        var userphone = findViewById<EditText>(R.id.set_profile_phone)
        var imview = findViewById<ImageView>(R.id.add_profilephoto)

        var insertsurname = usersurname?.text.toString()
        var insertname = username?.text.toString()
        var insertpatr = userpatr?.text.toString()
        var insertphone = userphone?.text.toString()
        var insertdate = userdate?.text.toString()
        var insertmail = usermail?.text.toString()
        var insertaddress = useraddress?.text.toString()
        var insertgender = usergender?.text.toString()
        val intgender = if (insertgender == "Мужской"|| insertgender == "мужской"|| insertgender =="муж" || insertgender == "Муж") 1 else 0


        val editor = sharedPreferences?.edit()
        editor?.putString("surname", insertsurname)
        editor?.putString("name", insertname)
        editor?.putString("patr", insertpatr)
        editor?.putString("phone", insertphone)
        editor?.putString("date", insertdate)
        editor?.putString("mail", insertmail)
        editor?.putString("address", insertaddress)
        editor?.putString("gender", insertgender)
        editor?.apply()

        createNewUser(insertname, insertsurname, insertpatr, insertmail, insertphone, intgender, insertdate, insertaddress)

    }

    fun loadData(){

        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)

        val savedsurname = sharedPreferences?.getString("surname", null)
        val savedname = sharedPreferences?.getString("name", null)
        val savedpatr = sharedPreferences?.getString("patr", null)
        val savedphone = sharedPreferences?.getString("phone", null)
        val saveddate = sharedPreferences?.getString("date", null)
        val savedmail = sharedPreferences?.getString("mail", null)
        val savedaddress = sharedPreferences?.getString("address", null)
        val savedgender = sharedPreferences?.getString("gender", null)


        var usersurname = findViewById<EditText>(R.id.set_profile_surname)
        var username = findViewById<EditText>(R.id.set_profile_name)
        var userpatr = findViewById<EditText>(R.id.set_profile_secondname)
        var usergender = findViewById<EditText>(R.id.set_profile_swx)
        var userdate = findViewById<EditText>(R.id.set_profile_dateBirth)
        var usermail = findViewById<EditText>(R.id.set_profile_email)
        var useraddress = findViewById<EditText>(R.id.set_profile_address)
        var userphone = findViewById<EditText>(R.id.set_profile_phone)
        var photo = findViewById<ImageView>(R.id.add_profilephoto)

        usersurname?.setText(savedsurname)
        username?.setText(savedname)
        userpatr?.setText(savedpatr)
        userphone?.setText(savedphone)
        userdate?.setText(saveddate)
        usermail?.setText(savedmail)
        useraddress?.setText(savedaddress)
        usergender?.setText(savedgender)

    }


// On result for set avatar
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    add_profilephoto.setImageBitmap(data.extras?.get("data") as Bitmap)

                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT)
            }
        }
    }


// Function for hide keyboard
    fun AppCompatActivity.hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        else {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }

    fun createNewUser(firstName: String, lastName: String, patronymic: String, email: String, phonenumber: String, gender: Int, birthday: String, address: String) {
        val apiService = RestSaveProfile()
        val saveUserInfo = saveProfile(  lastName = null,
            firstName = firstName,
            patronymic = patronymic,
            email = email,
            phonenumber = phonenumber,
            address = address,
            birthday = birthday,
            gender = gender

        )

        apiService.addUser(saveUserInfo) {
            if (it?.lastName != null) {
                // it = newly added user parsed as response
                // it?.id = newly added user ID
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }


}

