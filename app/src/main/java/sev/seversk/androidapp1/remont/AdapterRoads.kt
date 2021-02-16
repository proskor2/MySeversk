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


class AdapterRoads (val context: Context): RecyclerView.Adapter<AdapterRoads.MyViewHolder>() {

    var roadList: List<roads> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_roads, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return roadList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val title1 = Html.fromHtml(roadList.get(position).title)
        val status1 = Html.fromHtml(roadList.get(position).status)
        val date1 = Html.fromHtml(roadList.get(position).dateBegin)
        val date2 =  Html.fromHtml(roadList.get(position).dateEnd)

        val area1 = Html.fromHtml(roadList.get(position).area)
        val start1 = Html.fromHtml(roadList.get(position).start)
        val finish1 = Html.fromHtml(roadList.get(position).finish)
        val length = Html.fromHtml(roadList.get(position).length)
        val cost = Html.fromHtml(roadList.get(position).cost)


        holder.roads_title.text = title1
        holder.roads_status.text = status1
        holder.roads_date.text = ("$date1 "+"-"+"$date2 ")


        holder.card.setOnClickListener {
            val intent1 = Intent(this.context, road_details::class.java)
            intent1.putExtra("position", position)
            intent1.putExtra("title", title1)
            intent1.putExtra("datebegin", date1)
            intent1.putExtra("dateend", date2)
            intent1.putExtra("area", area1)
            intent1.putExtra("start", start1)
            intent1.putExtra("finish", finish1)
            intent1.putExtra("length", length)
            intent1.putExtra("cost", cost)
            ContextCompat.startActivity(context, intent1, null)
        }
    }

    fun setRoadsListItems(roadsList: List<roads>){
        this.roadList = roadsList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val roads_title = itemView.findViewById<TextView>(R.id.text_roads_title)
        val roads_status = itemView.findViewById<TextView>(R.id.text_roads_status)
        val roads_date = itemView.findViewById<TextView>(R.id.text_roads_date)
        val card = itemView.findViewById<CardView>(R.id.card_roads)
    }



}