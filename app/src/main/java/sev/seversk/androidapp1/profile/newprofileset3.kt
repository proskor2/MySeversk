package sev.seversk.androidapp1.profile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.drawToBitmap
import kotlinx.android.synthetic.main.activity_prodile_settings2.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.seversk
import java.io.ByteArrayOutputStream


class newprofileset3: AppCompatActivity() {



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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prodile_settings2)

        loadData()



        findViewById<LinearLayout>(R.id.layout1123)?.setOnClickListener(){
            hideKeyboard()
        }

       findViewById<Button>(R.id.button_profile2_save)?.setOnClickListener(){
            saveData()
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageButton>(R.id.button_profile2_back)?.setOnClickListener(){
            val intent = Intent(this, seversk::class.java)
            startActivity(intent)


        }

        findViewById<CardView>(R.id.add_profilephoto_card)?.setOnClickListener(){
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, 1)

            }
        }


    }


    fun saveData(){

        var usersurname = findViewById<EditText>(R.id.set_profile_surname)
        var username = findViewById<EditText>(R.id.set_profile_name)
        var userpatr = findViewById<EditText>(R.id.set_profile_secondname)
        var usergender = findViewById<EditText>(R.id.set_profile_swx)
        var userdate = findViewById<EditText>(R.id.set_profile_dateBirth)
        var usermail = findViewById<EditText>(R.id.set_profile_email)
        var useraddress = findViewById<EditText>(R.id.set_profile_address)
        var userphone = findViewById<EditText>(R.id.set_profile_phone)
        var imview = findViewById<ImageView>(R.id.add_profilephoto)

        var insertsurname = usersurname?.text
        var insertname = username?.text
        var insertpatr = userpatr?.text
        var insertphone = userphone?.text
        var insertdate = userdate?.text
        var insertmail = usermail?.text
        var insertaddress = useraddress?.text
        var insertgender = usergender?.text



        val fromphoto: ImageView = findViewById(R.id.add_profilephoto)
        val bitmap = fromphoto.drawToBitmap()
        val bbb = encodeImage(bitmap)



        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString("surname", insertsurname.toString())
        editor?.putString("name", insertname.toString())
        editor?.putString("patr", insertpatr.toString())
        editor?.putString("phone", insertphone.toString())
        editor?.putString("date", insertdate.toString())
        editor?.putString("mail", insertmail.toString())
        editor?.putString("address", insertaddress.toString())
        editor?.putString("gender", insertgender.toString())
        editor?.putString("photo", bbb)

        editor?.apply()




    }

    fun loadData(){


        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val savedsurname = sharedPreferences?.getString("surname", null)
        val savedname = sharedPreferences?.getString("name", null)
        val savedpatr = sharedPreferences?.getString("patr", null)
        val savedphone = sharedPreferences?.getString("phone", null)
        val saveddate = sharedPreferences?.getString("date", null)
        val savedmail = sharedPreferences?.getString("mail", null)
        val savedaddress = sharedPreferences?.getString("address", null)
        val savedgender = sharedPreferences?.getString("gender", null)
        val savedphoto = sharedPreferences?.getString("photo", null)

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

//        val imageBytes = Base64.decode(savedphoto, Base64.DEFAULT)
//        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
//        photo.setImageBitmap(decodedImage)




    }

    private fun encodeImage(bm: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.JPEG,100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

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

}

