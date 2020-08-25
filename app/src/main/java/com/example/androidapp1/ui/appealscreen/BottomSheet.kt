package com.example.androidapp1.ui.appealscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidapp1.R
import com.example.androidapp1.activities_appeal.activitiy_request
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*

open class BottomSheet: BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    return root

    }

    @SuppressLint("WrongConstant")
    override fun onStart() {
        super.onStart()


        button_problems123.setOnClickListener(){
            val appeal_pr = Intent(this@BottomSheet.context, activitiy_request::class.java)
            startActivity(appeal_pr)
        }
        button_request.setOnClickListener(){
            val t_request = Toast.makeText(context, "Ожидайте ответа", 1)
            t_request.show()
        }

    }

}




