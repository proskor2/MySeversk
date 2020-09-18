package sev.seversk.androidapp1.activities_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.example_district.*
import org.json.JSONArray
import sev.seversk.androidapp1.R

class district : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district)

        val json = """
            [ 
            {
            "number": "1",
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 2,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 3,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 4,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 5,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 6,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 7,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 8,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 9,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 10,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 11,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 12,
            "name1": " ",
             "name2": " ",
             "streets": " "
             },
             {"number": 13,
            "name1": " ",
             "name2": " ",
             "streets": " "
             }
            ]
        """.trimIndent()


    }
}