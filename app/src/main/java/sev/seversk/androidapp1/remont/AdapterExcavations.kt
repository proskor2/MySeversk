package sev.seversk.androidapp1.remont

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import sev.seversk.androidapp1.R

class AdapterExcavations (val context: Context): RecyclerView.Adapter<AdapterExcavations.MyViewHolder>() {

    var exList: List<excavations> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_excavations, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val location1 = Html.fromHtml(exList.get(position).location)
        val status1 = Html.fromHtml(exList.get(position).status)
        val date1 = Html.fromHtml(exList.get(position).start)
        val date2 = Html.fromHtml(exList.get(position).start)

        holder.exc_location.text = location1
        holder.exc_status.text = status1
        holder.exc_date.text = ("$date1 "+"-"+"$date2")

        holder.card.setOnClickListener {
            val intent1 = Intent(this.context, utilities_details::class.java)
            intent1.putExtra("position", position)
            ContextCompat.startActivity(context, intent1, null)
        }
    }

    fun setExcListItems(excList: List<excavations>){
        this.exList = excList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val exc_location = itemView.findViewById<TextView>(R.id.text_exc_location)
        val exc_status = itemView.findViewById<TextView>(R.id.text_exc_status)
        val exc_date = itemView.findViewById<TextView>(R.id.text_exc_date)
        val card = itemView.findViewById<CardView>(R.id.card_exc)
    }



}