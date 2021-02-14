package sev.seversk.androidapp1.disctrict_items

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


class DistrictAdapter (val context: Context): RecyclerView.Adapter<DistrictAdapter.MyViewHolder>() {

    var districtList: List<District> = listOf()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DistrictAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_district, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return districtList.size
    }



    override fun onBindViewHolder(holder: DistrictAdapter.MyViewHolder, position: Int) {

        val number = Html.fromHtml(districtList.get(position).number)
        val addresses = Html.fromHtml(districtList.get(position).addresses.toString())
        val areas = Html.fromHtml(districtList.get(position).area.toString())

        holder.distr_title.text = ("Избирательный округ №"+number)

        holder.card.setOnClickListener {
            val intent1 = Intent(this.context, district_description::class.java)
            intent1.putExtra("position", position)
            intent1.putExtra("number", number)
            intent1.putExtra("addresses", addresses)
            intent1.putExtra("area", areas)
            ContextCompat.startActivity(context, intent1, null)
        }
    }


    fun setDistrictListItems(districtList: List<District>){
        this.districtList = districtList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val distr_title = itemView.findViewById<TextView>(R.id.text_district)
        val card = itemView.findViewById<CardView>(R.id.card_district)
    }



}