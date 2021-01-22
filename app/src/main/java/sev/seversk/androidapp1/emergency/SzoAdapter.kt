package sev.seversk.androidapp1.emergency

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
import sev.seversk.androidapp1.R


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

            holder.szo_title.text = title1

            holder.card.setOnClickListener(){
                Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
                val intent1 = Intent(this.context, szo_details::class.java)
                ContextCompat.startActivity(context, intent1, null)
            }
        }


        fun setSzoListItems(szoList: List<Szo>){
            this.szoList = szoList
            notifyDataSetChanged()
        }

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val szo_title = itemView.findViewById<TextView>(R.id.text_szo_title)
            val card = itemView.findViewById<CardView>(R.id.card_szo)
        }



    }

