package sev.seversk.androidapp1.opros_items

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.events_items.AfishaAdapter
import sev.seversk.androidapp1.startActivity

class OprosAdapter (val context: Context): RecyclerView.Adapter<OprosAdapter.MyViewHolder>() {

    var oprosList: List<Opros> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):OprosAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_opros, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return oprosList.size
    }



    override fun onBindViewHolder(holder: OprosAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(oprosList.get(position).name_questionnaire)
        var status1 = Html.fromHtml(oprosList.get(position).status)

        holder.opros_title.text = title1
        holder.opros_status.text = status1
        holder.card.setOnClickListener(){
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
            val intent1 = Intent(this.context, opros_details::class.java)
           startActivity(context, intent1, null)
        }
    }


    fun setOprosListItems(oprosList: List<Opros>){
        this.oprosList = oprosList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val opros_title = itemView.findViewById<TextView>(R.id.text_opros_title)
        val opros_status = itemView.findViewById<TextView>(R.id.text_opros_status)
        val card = itemView.findViewById<CardView>(R.id.card_opros)
    }



}