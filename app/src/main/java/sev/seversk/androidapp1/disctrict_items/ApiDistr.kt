package sev.seversk.androidapp1.disctrict_items

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import sev.seversk.androidapp1.alerts_items.Alert
import sev.seversk.androidapp1.alerts_items.ApiAlert

interface ApiDistr {

    @GET("district.json")

//    @Headers("Accept: application/json", "Authorization: Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")


    fun getAlert() : retrofit2.Call<List<Alert>>

    companion object {

        var BASE_URL = " "

        fun create() : ApiAlert {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiAlert::class.java)
        }

        val json = """
            [ 
            {
            "number": "Избирательный округ №1",
            "name1": "МАЕВСКИЙ АЛЕКСАНДР ИЗИДОРОВИЧ",
             "name2": "Улицы, входящие в округ:",
             "streets": {"ул. Победы, 14а, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 27, 29, 31, 33, 33а, 35, 35а, 39",
                         "ул. Ленинградская, 2, 4, 6, 6б, 6в, 8, 10, 12, 14, 14а, 16а, 18, 20, 22, 24, 26, 28, 30, 33, 34",
                         "ул. Славского, 20, 34",
                         "ул. Ксензовка",
                         "ул. Верхняя Ксензовка",
                         "ул. Смолокурка",
                         "пикет 109",
                         "кардон",
                         "ул. Нижняя Ксензовка",
                         "пер. Чекист, 3, 11",
                         "СОПК Сосна",
                         "в/ч 3480"}
                        },
             
             {"number": "Избирательный округ №2",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №3",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №4",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №5",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №6",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №7",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №8",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №9",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №10",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №11",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №12",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             },
             
             {"number": "Избирательный округ №13",
            "name1": " ",
             "name2": "Улицы, входящие в округ:",
             "streets": " "
             }
             
            ]
        """.trimIndent()
    }
}