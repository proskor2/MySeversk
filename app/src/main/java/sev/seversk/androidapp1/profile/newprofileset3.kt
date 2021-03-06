package sev.seversk.androidapp1.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FileDataPart
import com.github.kittinunf.fuel.core.Method
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_prodile_settings2.*
import kotlinx.android.synthetic.main.fragment_detail_problem0.*
import okhttp3.*
import org.json.JSONObject
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.*
import java.io.*


class newprofileset3: AppCompatActivity() {

    var newtoken: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prodile_settings2)

        RestSaveProfile.Companion.setContext(this)

//        loadData()

 // Get token
        val getstring = KVault(context = applicationContext)
        newtoken = getstring.string("TOKEN")

        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/profile/get"

        var okHttpClient: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder().url(URL).addHeader("Authorization",
            "Bearer " + newtoken).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call, response: Response) {

                val json = response.body()?.string()

                val parentObject = JSONObject(json)

                val jsurname = parentObject.getString("lastName")
                val jname = parentObject.getString("firstName")
                val jpatron = parentObject.getString("patronymic")
                val jmail = parentObject.getString("email")
                val jphone = parentObject.getString("phonenumber")
                val jaddress = parentObject.getString("address")
                val jbirthday = parentObject.getString("birthday")
                val jgender = parentObject.getString("gender")
                val javatar = parentObject.getString("avatar")


                var usersurname = findViewById<EditText>(R.id.set_profile_surname)
                var username = findViewById<EditText>(R.id.set_profile_name)
                var userpatr = findViewById<EditText>(R.id.set_profile_secondname)
                var usergender = findViewById<EditText>(R.id.set_profile_swx)
                var userdate = findViewById<EditText>(R.id.set_profile_dateBirth)
                var usermail = findViewById<EditText>(R.id.set_profile_email)
                var useraddress = findViewById<EditText>(R.id.set_profile_address)
                var userphone = findViewById<EditText>(R.id.set_profile_phone)
                var imview = findViewById<ImageView>(R.id.add_profilephoto)




                runOnUiThread {

                    if (jsurname != "null") usersurname?.setText(jsurname) else usersurname?.setText("")
                    if (jname != "null") username.setText(jname) else username?.setText("")
                    if (jpatron != "null")  userpatr.setText(jpatron) else userpatr?.setText("")
                    if (jmail != "null")  usermail.setText(jmail) else usermail?.setText("")
                    if (jphone != "null") userphone.setText(jphone) else userphone?.setText("")
                    if (jaddress != "null") useraddress.setText(jaddress) else useraddress?.setText("")
                    if (jbirthday != "null")  userdate.setText(jbirthday) else userdate?.setText("")
                    if (jgender != "null") usergender.setText(jgender) else usergender.setText("")


                    if (javatar != null) {
                        Glide.with(applicationContext)
                            .load(javatar)
                            .into(imview)
                    }
                }
            }


        })



// Hide keyboard
        findViewById<LinearLayout>(R.id.layout1123)?.setOnClickListener {
            hideKeyboard()
        }

// Button save profile settings
        findViewById<Button>(R.id.button_profile2_save)?.setOnClickListener {
            saveData()
            savePhotoProfile()
            Toast.makeText(this, "Изменения сохранены", Toast.LENGTH_SHORT).show()

        }

//  Button return to seversk activity
        findViewById<Button>(R.id.button_profile2_back)?.setOnClickListener {
//            val intent = Intent(this, profile_settings::class.java)
//            startActivity(intent)
            finish()
        }

// Click to set image
        val card_photo = findViewById<CardView>(R.id.add_profilephoto_card)
        card_photo?.setOnClickListener {
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

        saveUser(insertname,
            insertsurname,
            insertpatr,
            insertmail,
            insertphone,
            insertgender,
            insertdate,
            insertaddress)

    }

//    fun loadData(){
//
//        val sharedPreferences = getSharedPreferences("profiles", Context.MODE_PRIVATE)
//
//        val savedsurname = sharedPreferences?.getString("surname", null)
//        val savedname = sharedPreferences?.getString("name", null)
//        val savedpatr = sharedPreferences?.getString("patr", null)
//        val savedphone = sharedPreferences?.getString("phone", null)
//        val saveddate = sharedPreferences?.getString("date", null)
//        val savedmail = sharedPreferences?.getString("mail", null)
//        val savedaddress = sharedPreferences?.getString("address", null)
//        val savedgender = sharedPreferences?.getString("gender", null)
//
//
//        var usersurname = findViewById<EditText>(R.id.set_profile_surname)
//        var username = findViewById<EditText>(R.id.set_profile_name)
//        var userpatr = findViewById<EditText>(R.id.set_profile_secondname)
//        var usergender = findViewById<EditText>(R.id.set_profile_swx)
//        var userdate = findViewById<EditText>(R.id.set_profile_dateBirth)
//        var usermail = findViewById<EditText>(R.id.set_profile_email)
//        var useraddress = findViewById<EditText>(R.id.set_profile_address)
//        var userphone = findViewById<EditText>(R.id.set_profile_phone)
//        var photo = findViewById<ImageView>(R.id.add_profilephoto)
//
//        usersurname?.setText(savedsurname)
//        username?.setText(savedname)
//        userpatr?.setText(savedpatr)
//        userphone?.setText(savedphone)
//        userdate?.setText(saveddate)
//        usermail?.setText(savedmail)
//        useraddress?.setText(savedaddress)
//        usergender?.setText(savedgender)
//
//    }


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

    fun savePhotoProfile(){
        val fromphoto: ImageView = findViewById(R.id.add_profilephoto)
        var getphoto = fromphoto.drawable
        val getphoto1 = getphoto?.toBitmap()


        val bytes: ByteArrayOutputStream = ByteArrayOutputStream()
        getphoto1?.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val file = createTempFile("avatar", ".jpg")
        val fo: FileOutputStream = FileOutputStream(file)
        fo.write(bytes.toByteArray())
        fo.close()

        val getstring = KVault(context = applicationContext)
        newtoken = getstring.string("TOKEN")
        val URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/profile/avatar"

        Fuel.upload(
           URL, Method.POST
        ).add(FileDataPart(file, name = "avatar", filename = "avatar.jpg"))
            .header("Authorization" to "Bearer $newtoken")
            .response { result -> }
    }

    fun saveUser(
        firstName: String,
        lastName: String,
        patronymic: String,
        email: String,
        phonenumber: String,
        gender: String,
        birthday: String,
        address: String
    ) {
        val apiService = RestSaveProfile()
        val saveUserInfo = saveProfile(
            lastName = lastName,
            firstName = firstName,
            patronymic = patronymic,
            email = email,
            phonenumber = phonenumber,
            address = address,
            birthday = birthday,
            gender = gender
        )

        apiService.saveUser(saveUserInfo) {
            if (it?.firstName != null) {
                // it = newly added user parsed as response
                // it?.id = newly added user ID
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

