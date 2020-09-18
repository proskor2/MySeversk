package sev.seversk.androidapp1.activities_appeal

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.scale
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.DataPart
import com.github.kittinunf.fuel.core.FileDataPart
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.seversk
import kotlinx.android.synthetic.main.activitiy_appeal_request2.*
import kotlinx.android.synthetic.main.activity_eventid.*
import kotlinx.android.synthetic.main.activity_newproblem.*
import kotlinx.android.synthetic.main.activity_prodile_settings2.*
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sev.seversk.androidapp1.activities_main.problem
import sev.seversk.androidapp1.problems_items.ApiProblems
import sev.seversk.androidapp1.problems_items.Problem
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class appeal_problem : AppCompatActivity() {

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

    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newproblem)


//////////////////////////////////////////////////////////////////////////////////////////// POST //////////////////////////////////////////////////////////////////////////////////////////////////////
        var mainurl = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/treatments"
        var gettitle = text_newproblem_title.text
        var getdescr = text_newproblem_descr.text
        var getaddress = text_newproblem_address.text



        button_newproblem_ready.setOnClickListener(){
            val fromphoto:ImageView = findViewById(R.id.add_photo_new)
            var getphoto = fromphoto.drawable
            val getphoto1 = getphoto.toBitmap()
            getphoto1.scale(10, 10)

            val bytes: ByteArrayOutputStream = ByteArrayOutputStream()
            getphoto1.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            val file = createTempFile("photo", ".jpg")
            val fo: FileOutputStream = FileOutputStream(file)
            fo.write(bytes.toByteArray())
            fo.close()

//            Fuel.post(mainurl, listOf("title" to "Проблема проблем 4", "description" to "Потеря потерь 3")).header("authorization" to "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi").response{request, response, result ->  }

            Fuel.upload(mainurl, Method.POST, listOf(
                "title" to "$gettitle",
                "description" to "$getdescr",
                "address" to "$getaddress"
            )).add(FileDataPart(file, name = "photo", filename = "treatment.jpg")).header("authorization" to "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi").response{ result ->  }


            val ready1 = Intent(this@appeal_problem, appeal_problem2::class.java)
            startActivity(ready1)
            finish()
        }
//////////////////////////////////////////////////////////////////////////////////////////// POST ////////////////////////////////////////////////////////////////////////////////////////////////////////
        button_appeal_cancel2.setOnClickListener(){
            val appeal3 = Intent(this@appeal_problem, seversk::class.java )
            startActivity(appeal3)
            finish()
        }

        button_problem_addfile.setOnClickListener(){
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }

        }

        linear7.setOnClickListener(){
            hideKeyboard()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    add_photo_new.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT)
            }
        }
    }


}