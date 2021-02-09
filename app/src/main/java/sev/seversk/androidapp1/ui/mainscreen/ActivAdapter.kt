package sev.seversk.androidapp1.ui.mainscreen

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import sev.seversk.androidapp1.R

class ActivAdapter(val context: Context): RecyclerView.Adapter<ActivAdapter.MyViewHolder>() {

        var activList: List<Activ> = listOf()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ActivAdapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.example_activ, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return activList.size
        }



        override fun onBindViewHolder(holder: ActivAdapter.MyViewHolder, position: Int) {

            var title1 = Html.fromHtml(activList.get(position).title)
            var pre_photo = activList.get(position).photo
            var photo1 ="https://"+"$pre_photo"
            var desc = Html.fromHtml(activList.get(position).description)
            var date1 = Html.fromHtml(activList.get(position).date)


            holder.activName.text = title1
            holder.activDescr.text = date1

            Glide.with(context).load(photo1)
                .apply(RequestOptions().centerCrop())
                .into(holder.activImage)
            holder.card.setOnClickListener {
//            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
                val intent1 = Intent(this@ActivAdapter.context, Activid::class.java)
                intent1.putExtra("date", date1)
                intent1.putExtra("desc", desc)
                intent1.putExtra("photo", photo1)
                ContextCompat.startActivity(context, intent1, null)
            }

        }


        fun setActivListItems(activList: List<Activ>){
            this.activList = activList
            notifyDataSetChanged()
        }

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val activName = itemView.findViewById<TextView>(R.id.text_activ1)
            val activDescr = itemView.findViewById<TextView>(R.id.text_activ2)
            val activImage = itemView.findViewById<ImageView>(R.id.activ_photo1)
            val card = itemView.findViewById<CardView>(R.id.card_activ)
        }




    }
