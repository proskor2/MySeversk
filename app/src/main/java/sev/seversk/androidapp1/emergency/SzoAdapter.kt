package sev.seversk.androidapp1.emergency

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.fragment_appeals.*
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.parse
import kotlinx.serialization.stringify
import okhttp3.*
import org.json.JSONArray
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.szo
import java.io.IOException


@ImplicitReflectionSerializer
class SzoAdapter (val context: Context): RecyclerView.Adapter<SzoAdapter.MyViewHolder>() {

        var szoList: List<Szo> = listOf()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.example_szo, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return szoList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            var title1 = Html.fromHtml(szoList.get(position).title)
            var type1 = Html.fromHtml(szoList.get(position).type)
            var address1 = Html.fromHtml(szoList.get(position).address)
            var email1 = Html.fromHtml(szoList.get(position).email)
            var site1 = Html.fromHtml(szoList.get(position).site)

            var emplstring = Html.fromHtml(szoList.get(position).employees.toString())
            var phonestring = Html.fromHtml(szoList.get(position).phones.toString())
            var coordsstring = Html.fromHtml(szoList.get(position).coords.toString())



            holder.szo_title.text = title1
            holder.szo_address.text = address1

            holder.card.setOnClickListener(){
                val intent1 = Intent(this.context, szo_details::class.java)
                intent1.putExtra("address", address1)
                intent1.putExtra("email", email1)
                intent1.putExtra("site", site1)
                intent1.putExtra("position", position)
                ContextCompat.startActivity(context, intent1, null)
            }
        }

        fun setSzoListItems(szoList: List<Szo>){
            this.szoList = szoList
            notifyDataSetChanged()
        }

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val szo_title = itemView.findViewById<TextView>(R.id.text_szo_title)
            val szo_address = itemView.findViewById<TextView>(R.id.text_szo_address)
            val card = itemView.findViewById<CardView>(R.id.card_szo)
        }



    }

