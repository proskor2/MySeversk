package sev.seversk.androidapp1.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sev.seversk.androidapp1.R

class newprofileset2: Fragment() {
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


    }
}