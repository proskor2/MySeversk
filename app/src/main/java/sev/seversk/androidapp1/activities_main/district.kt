package sev.seversk.androidapp1.activities_main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_district.*
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.disctrict_items.district_description

class district : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district)

card_district1.setOnClickListener(){
    val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №1"
    val name = "МАЕВСКИЙ АЛЕКСАНДР ИЗИДОРОВИЧ"
    val streets = """
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Победы, 14а, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 27, 29, 31, 33, 33а, 35, 35а, 39
ул. Ленинградская, 2, 4, 6, 6б, 6в, 8, 10, 12, 14, 14а, 16а, 18, 20, 22, 24, 26, 28, 30, 33, 34
ул. Славского, 20, 34
ул. Ксензовка
ул. Верхняя Ксензовка
ул. Смолокурка
пикет 109
кардон
ул. Нижняя Ксензовка
пер. Чекист, 3, 11
СОПК "Сосна"
в/ч 3480 """
    val intent = Intent(this@district, district_description::class.java)
    intent.putExtra("name1", name )
    intent.putExtra("num1", num)
    intent.putExtra("streets1", streets)
    intent.putExtra("resId", R.drawable.maevsky)
    startActivity(intent)
}

        card_district2.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №1"
            val name = "МАЕВСКИЙ АЛЕКСАНДР ИЗИДОРОВИЧ"
            val streets = """
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Победы, 14а, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 27, 29, 31, 33, 33а, 35, 35а, 39
ул. Ленинградская, 2, 4, 6, 6б, 6в, 8, 10, 12, 14, 14а, 16а, 18, 20, 22, 24, 26, 28, 30, 33, 34
ул. Славского, 20, 34
ул. Ксензовка
ул. Верхняя Ксензовка
ул. Смолокурка
пикет 109
кардон
ул. Нижняя Ксензовка
пер. Чекист, 3, 11
СОПК "Сосна"
в/ч 3480 """
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.makarenko)
            startActivity(intent)
        }

        card_district3.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №3"
            val name = "СЕЛЕЗНЕВ АНДРЕЙ ПАВЛОВИЧ"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Ленина, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 118, 122, 124, 126, 130, 130б, 132
пр. Коммунистический, 98, 116, 118
проезд Южный, 5, 9, 11
ул. Солнечная, 1, 1а, 3, 3а, 5, 7, 7а, 9, 13
ул. Курчатова, 6, 8
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.seleznev)
            startActivity(intent)
        }

        card_district4.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №4"
            val name = "КОРШУНОВА ОЛЬГА ПЕТРОВНА"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
пр. Коммунистический, 145, 151, 153, 157, 161
ул. Солнечная, 19, 21, 23
ул. Курчатова, 34, 34а, 36а, 38, 38а, 42
ул. Калинина, 70, 74, 76, 78, 80, 82, 84, 86, 92, 96, 100, 139, 147
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.korshunova)
            startActivity(intent)
        }

        card_district5.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №5"
            val name = "КОППАЛОВА ЛАРИСА НИКОЛАЕВНА"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
кордон
пр. Коммунистический, 90, 96, 100, 106, 108, 112, 121, 123, 125, 127, 129, 131, 133, 143, 147, 147а, 149
ул. Солнечная, 8, 10, 11, 12, 14, 16
ул. Курчатова, 9, 11, 13, 17, 18, 19, 21, 22, 24, 26, 28, 30, 32
ул. Калинина, 119
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.koppalova)
            startActivity(intent)
        }

        card_district6.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №6"
            val name = "МЕТЕЛЬКОВА ЕКАТЕРИНА АЛЕКСАНДРОВНА"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
кордон
ул. Солнечная, 18
ул. Калинина, 68, 95, 99, 101, 113, 115, 117, 121, 129, 131, 133, 137
проезд Новый, 1, 3, 4, 7, 12
ул. Северная, 2, 2а, 4, 8, 10, 14, 16, 20, 22, 24, 24а, 26, 30, 34, 36
ул. Сосновая, 1, 2, 3, 4, 16, 17
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.metelkova)
            startActivity(intent)
        }

        card_district7.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №7"
            val name = "ДЕЕВА ЕЛЕНА ВЛАДИМИРОВНА"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Ленина, 66, 68, 72, 74, 78, 80, 84
пр. Коммунистический, 68, 70, 74, 80, 82, 84, 84а, 84б, 88, 90а, 91, 93, 95, 99, 105, 107, 109, 115, 117
ул. Курчатова, 1, 5, 15
ул. Калинина, 48, 50, 52, 52а, 54, 54а, 54б, 56, 56а, 58, 60, 62, 64, 66, 89, 91, 103, 105
ул. Царевского, 8, 10
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.deeva)
            startActivity(intent)
        }

        card_district8.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №8"
            val name = "ВЛАСОВ АЛЕКСАНДР ЮРЬЕВИЧ"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Ленина, 52, 54, 60, 62, 64
пр. Коммунистический, 54, 58, 60, 64, 64а, 66, 87, 87а, 89
ул. Калинина, 44, 46, 71, 73, 75, 79, 81, 83, 85, 87, 93, 97
ул. Царевского, 1, 2, 3, 4, 5, 6, 7, 9, 11, 12, 13, 18, 20
ул. Куйбышева, 1, 4, 5, 6а, 8, 10, 14, 15, 15а, 16, 19
ул. Кирова, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12а, 14
ул. Транспортная, 82, 84, 86, 88, 92, 94, 98, 100, 102, 104
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.vlasov)
            startActivity(intent)
        }

        card_district9.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №9"
            val name = "РУНДА АЛЕКСАНДР МИХАЙЛОВИЧ"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
пр. Коммунистический, 75, 79, 81, 83, 85
ул. Калинина, 2, 4, 6, 8, 14, 16, 18, 20, 38, 40, 41, 43, 45, 49, 51, 53, 55, 59, 61
ул. Куйбышева, 2, 7, 7а, 9, 11, 17
ул. Транспортная, 32, 54, 56, 58, 58а, 60, 62, 64, 66, 70, 72
ул. 40 лет Октября, 11, 13, 17, 19
ул. Крупской, 2, 2а, 4, 6, 8, 9, 9а, 10, 11(общежитие), 12, 13, 14а, 15, 19, 21, 23
ул. Советская, 3, 5, 9, 13, 14, 17, 18, 26
ул. Строителей, 3, 4, 5, 6, 8, 9, 10, 15, 16, 17, 19, 20, 21, 23
ул. Московская, 4, 4а, 6, 6а, 10
ул. Тупиковая, 4, 6, 8, 10
в/ч 3478
в/ч 3481
в/ч 6887
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.runda)
            startActivity(intent)
        }

        card_district10.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №10"
            val name = "АТАМАНЧУК НАТАЛЬЯ СЕРГЕЕВНА"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Ленина, 44, 48, 50
пр. Коммунистический, 40, 44, 50, 52, 55, 59, 61, 61а, 67а, 69, 71, 73
ул. Калинина, 23, 27, 29
ул. Транспортная, 2, 4, 6, 10, 12, 14, 18, 20, 22, 24, 26
ул. 40 лет Октября, 2, 3, 5, 6, 10, 14
ул. Крупской, 16, 18, 20, 22, 24, 31, 35
ул. Советская, 19, 22, 23, 28, 30, 34, 36
ул. Строителей, 22, 26, 28, 29, 31, 33, 35, 36, 37
ул. Свердлова, 3, 4, 5, 7 (общежитие)
ул. Ершова, 4, 6
ул. Лесная, 10, 11, 12
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.ataman)
            startActivity(intent)
        }

        card_district11.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №11"
            val name = "СТЕПИН ДЕНИС АЛЕКСАНДРОВИЧ"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Ленина, 2, 4, 6, 7, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 30, 32, 34, 36, 40, 42
пр. Коммунистический, 2, 4, 6, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 23а, 24, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 41, 43, 45, 47
ул. Свердлова, 16, 17, 19
ул. Леонтичука, 6, 7, 8, 9, 11, 13, 15
ул. Маяковского, 5, 6, 7, 8, 12, 14
ул. Мира, 10, 10а, 12, 12а, 14
ул. Парковая, 4, 6, 8, 10, 12, 18, 18а, 22, 22а
ул. Первомайская, 17, 19, 20, 21, 21а, 22, 24, 26, 28, 29, 29а, 31, 31а
ул. Пушкина, 5, 7, 9
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.stepin)
            startActivity(intent)
        }

        card_district12.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №12"
            val name = "ЕРМОЛОВА ОЛЬГА ГЕННАДЬЕВНА"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
ул. Калинина, 13, 19
ул. Свердлова, 6
ул. Лесная, 1, 2, 3, 4, 5, 6, 6б, 7, 8, 9, 9б, 10б, 11б, 12б
ул. Мира, 9, 11а, 13, 15, 17, 18, 18а, 19, 20, 21, 22, 23, 25
ул. Парковая, 2
ул. Первомайская, 3, 3а, 4, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18
ул. Пушкина, 1, 3
ул. Горького, 5, 5а, 7а, 9а, 10, 12, 13, 14, 16, 20, 22, 28, 29, 30, 31, 33, 37
ул. Пионерская, 6, 10, 14, 28, 30, 32, 34
ул. Полевая, 5
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.ermolova)
            startActivity(intent)
        }

        card_district13.setOnClickListener(){
            val num = "ИЗБИРАТЕЛЬНЫЙ ОКРУГ №13"
            val name = "ИВАНОВ ОЛЕГ НИКОЛАЕВИЧ"
            val streets = """ 
УЛИЦЫ, ВХОДЯЩИЕ В ОКРУГ:
пр. Коммунистический, 1, 3, 7, 9
ул. Мира, 1, 1а, 2, 3, 3а, 5, 7, 8
ул. Первомайская, 30, 32, 34, 38, 40
ул. Пушкина, 2, 4, 6, 8, 10, 10а, 12, 12а
ул. Горького, 4, 4а, 6, 8
ул. Полевая, 8
ул. Комсомольская, 6, 8, 10, 12, 14, 16, 18, 20, 22, 22а, 24, 24а, 26
ул. Братьев Иглаковых
дер. Кижирово
дер. Семиозерки
дер. Чернильщиково
пос. Орловка
ул. Лермонтова
ул. Ломоносова
ул. Луговая
ул. Матросова
ул. Набережная
ул. Октябрьская
ул. Песочный тупик
ул. Подгорный тупик
ул. Речной тупик
ул. Тракторная
ул. Садовая
ул. Трудовая
ул. Тургенева
ул. Чайковского
ул. Чернышевского
ул. Чехова
пер. Западный
СНТ "Мир" (Иглаково)
пос. Самусь
СНТ "Планета"
"""
            val intent = Intent(this@district, district_description::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("num1", num)
            intent.putExtra("streets1", streets)
            intent.putExtra("resId", R.drawable.ivamov)
            startActivity(intent)
        }


    }
}