package sev.seversk.androidapp1.activities_appeal

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.get
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FileDataPart
import com.github.kittinunf.fuel.core.Method
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_newproblem.*
import kotlinx.android.synthetic.main.activity_yandex_maps.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.seversk
import sev.seversk.androidapp1.yandex_maps
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


@Suppress("DEPRECATION")
class appeal_problem : AppCompatActivity() {

val token1 = FirebaseAuth.getInstance().currentUser?.uid
    var file: File? = null

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

   val txt = findViewById<TextView>(R.id.text_newproblem_address)
        val txt2 = findViewById<TextView>(R.id.text_newproblem_descr)
        txt.setOnFocusChangeListener { v, hasFocus ->
            if (txt.text.toString() == "Введите адрес") txt.text = ""
        }

        txt2.setOnFocusChangeListener { v, hasFocus ->
            if (txt2.text.toString() == "Описание проблемы") txt2.text = ""
        }

        button_appeal_cancel2.setOnClickListener() {
            val appeal3 = Intent(this@appeal_problem, seversk::class.java)
            startActivity(appeal3)
            finish()
        }


//////////////////////////////////////////////////////////////////////////////////////////// POST //////////////////////////////////////////////////////////////////////////////////////////////////////
        var mainurl = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/treatments"
//        var gettitle = text_newproblem_title.text

        button_tomap.setOnClickListener(){
            var int1 = Intent(this@appeal_problem, yandex_maps::class.java)
            startActivity(int1)
        }

// Click on button Ready
        button_newproblem_ready.setOnClickListener() {


            var gettitle = spinner.selectedItem.toString()

            var getdescr = text_newproblem_descr.text
            var getaddress = text_newproblem_address.text

            val fromphoto: ImageView = findViewById(R.id.add_photo_new)
            var getphoto = fromphoto.drawable
            val getphoto1 = getphoto?.toBitmap()


            val bytes: ByteArrayOutputStream = ByteArrayOutputStream()
            getphoto1?.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
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

        linear7.setOnClickListener() {
            hideKeyboard()
        }
    }


    private val GALLERY = 1
    private val CAMERA = 2

    var mCurrentPhotoPath: String? = null

    @Throws(IOException::class)
    private fun createImageFile(): File? {
        // Create an image file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",  /* suffix */
            storageDir /* directory */
        )

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.absolutePath
        return image
    }


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
//        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse("Android/data/sev.seversk.androidapp1/files/Pictures/temp.jpg"))
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




