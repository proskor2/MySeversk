package sev.seversk.androidapp1.authorization

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.liftric.kvault.KVault

open class takeToken:AppCompatActivity() {

    val kVault = KVault(context = applicationContext)
    val gettok = kVault.string("TOKEN").toString()

}