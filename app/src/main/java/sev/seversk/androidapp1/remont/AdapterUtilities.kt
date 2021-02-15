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

class AdapterUtilities(val context: Context): RecyclerView.Adapter<AdapterUtilities.MyViewHolder>() {

    var utilList: List<utilities> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_utilities, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return utilList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val location1 = Html.fromHtml(utilList.get(position).location)
        val type1 = Html.fromHtml(utilList.get(position).type)
        val dateP1 = Html.fromHtml(utilList.get(position).startPlan)
        val dateP2 = Html.fromHtml(utilList.get(position).finishPlan)
        val dateP = "$dateP1 - $dateP2"
        val dateF1 = Html.fromHtml(utilList.get(position).startFact)
        val dateF2 = Html.fromHtml(utilList.get(position).finishFact)
        val dateF = "$dateF1 - $dateF2"


        val title1 = Html.fromHtml(utilList.get(position).title)
        val service1 = Html.fromHtml(utilList.get(position).service)
        val commen = Html.fromHtml(utilList.get(position).comments)
        val coords = Html.fromHtml(utilList.get(position).coords.toString())

        holder.util_location.text = location1
        holder.util_type.text = type1
        holder.util_datePlan.text = ("По плану: "+"$dateP1 "+"-"+"$dateP2")
        holder.util_dateFact.text = ("По факту: "+"$dateF1 "+"-"+"$dateF2")

        holder.card.setOnClickListener {
            val intent1 = Intent(this.context, utilities_details::class.java)
            intent1.putExtra("position", position)
            intent1.putExtra("title", title1)
            intent1.putExtra("location", location1)
            intent1.putExtra("service", service1)
            intent1.putExtra("dateP", dateP)
            intent1.putExtra("dateF", dateF)
            intent1.putExtra("comment", commen)

            ContextCompat.startActivity(context, intent1, null)
        }
    }

    fun setUtilListItemsutil(utilList: List<utilities>){
        this.utilList = utilList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val util_location = itemView.findViewById<TextView>(R.id.text_util_location)
        val util_type = itemView.findViewById<TextView>(R.id.text_util_type)
        val util_datePlan = itemView.findViewById<TextView>(R.id.text_util_dateplan)
        val util_dateFact = itemView.findViewById<TextView>(R.id.text_util_datefact)
        val card = itemView.findViewById<CardView>(R.id.card_util)
    }



}