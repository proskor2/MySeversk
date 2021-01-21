package sev.seversk.androidapp1.opros_items

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.seversk

class opros_details : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opros_details)

  findViewById<ImageButton>(R.id.button_backopros).setOnClickListener(){
      val intent = Intent(this, seversk::class.java)
      startActivity(intent)
  }

    }
}