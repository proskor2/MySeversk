package sev.seversk.androidapp1.ui.appealscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_appeal.appeal_iniciate
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    @SuppressLint("WrongConstant")
    override fun onStart() {
        super.onStart()


        button_iniciate.setOnClickListener(){
            val inic = Intent(this@DashboardFragment.context, appeal_iniciate::class.java)
            startActivity(inic)
        }
        button_request.setOnClickListener(){
            val t_request = Toast.makeText(context, "Ожидайте ответа", 1)
            t_request.show()
        }
    }
}


