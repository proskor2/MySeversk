package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FileDataPart
import com.github.kittinunf.fuel.core.Method
import kotlinx.android.synthetic.main.activity_newproblem.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.seversk
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URI


class appeal_problem : AppCompatActivity() {

    private var mImageUri :Uri? = null

    fun AppCompatActivity.hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } else {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newproblem)


        button_appeal_cancel2.setOnClickListener() {
            val appeal3 = Intent(this@appeal_problem, seversk::class.java)
            startActivity(appeal3)
            finish()
        }

        linear7.setOnClickListener() {
            hideKeyboard()
        }

//////////////////////////////////////////////////////////////////////////////////////////// POST //////////////////////////////////////////////////////////////////////////////////////////////////////
        var mainurl = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/treatments"
        var gettitle = text_newproblem_title.text
        var getdescr = text_newproblem_descr.text
        var getaddress = text_newproblem_address.text


// Click on button Ready
        button_newproblem_ready.setOnClickListener() {
            val fromphoto: ImageView = findViewById(R.id.add_photo_new)
            var getphoto = fromphoto.drawable
            val getphoto1 = getphoto.toBitmap()


            val bytes: ByteArrayOutputStream = ByteArrayOutputStream()
            getphoto1.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            val file = createTempFile("photo", ".jpg")
            val fo: FileOutputStream = FileOutputStream(file)
            fo.write(bytes.toByteArray())
            fo.close()

//            Fuel.post(mainurl, listOf("title" to "Проблема проблем 4", "description" to "Потеря потерь 3")).header("authorization" to "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi").response{request, response, result ->  }

            Fuel.upload(
                mainurl, Method.POST, listOf(
                    "title" to "$gettitle",
                    "description" to "$getdescr",
                    "address" to "$getaddress"
                )
            ).add(FileDataPart(file, name = "photo", filename = "treatment.jpg"))
                .header("authorization" to "Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")
                .response { result -> }


            val ready1 = Intent(this@appeal_problem, appeal_problem2::class.java)
            startActivity(ready1)
            finish()
        }
//////////////////////////////////////////////////////////////////////////////////////////// POST ////////////////////////////////////////////////////////////////////////////////////////////////////////


// add photo
        button_problem_addfile.setOnClickListener() {
            showPictureDialog()

        }
    }


    private val GALLERY = 1
    private val CAMERA = 2



    private fun showPictureDialog() {
        val pictureDialog = android.app.AlertDialog.Builder(this)
        pictureDialog.setTitle("Выберите действие")
        val pictureDialogItems = arrayOf("Выбрать из галереи", "Сделать снимок")
        pictureDialog.setItems(
            pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> chooseImageFromGallery()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }

    fun chooseImageFromGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, GALLERY)
    }

    private fun takePhotoFromCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA)

    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val contentURI = data!!.data
        if (requestCode == GALLERY) {
            if (data != null) {

                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    add_photo_new!!.setImageBitmap(bitmap)


                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this@appeal_problem, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        } else if (requestCode == CAMERA) {

            add_photo_new.setImageBitmap(data?.extras?.get("data") as Bitmap)


        }

    }

}
