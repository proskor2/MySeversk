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
        val date2 = Html.fromHtml(exList.get(position).finish)

        val dateorder1 = Html.fromHtml(exList.get(position).dateOrder)
        val numberorder1 = Html.fromHtml(exList.get(position).numberOrder)
        val renewal1 = Html.fromHtml(exList.get(position).renewalOrder)
        val customer1 = Html.fromHtml(exList.get(position).customer)
        val contact1 = Html.fromHtml(exList.get(position).contact)
        val contactposition1 = Html.fromHtml(exList.get(position).contactPosition)
        val contactphone1 = Html.fromHtml(exList.get(position).contactPhone)
        val comment1 = Html.fromHtml(exList.get(position).comments)
        val type1 = Html.fromHtml(exList.get(position).type)
        val nature1 = Html.fromHtml(exList.get(position).nature)

        holder.exc_location.text = location1
        holder.exc_status.text = status1
        holder.exc_date.text = ("$date1 "+"-"+"$date2")

        holder.card.setOnClickListener {
            val intent1 = Intent(this.context, excavation_details::class.java)
            intent1.putExtra("position", position)
            intent1.putExtra("dateorder", dateorder1)
            intent1.putExtra("numberorder",numberorder1)
            intent1.putExtra("renewal",renewal1)
            intent1.putExtra("customer", customer1)
            intent1.putExtra("contact", contact1)
            intent1.putExtra("contactposition", contactposition1)
            intent1.putExtra("contactphone", contactphone1)
            intent1.putExtra("location", location1)
            intent1.putExtra("start", date1)
            intent1.putExtra("finish", date2)
            intent1.putExtra("comment", comment1)
            intent1.putExtra("type", type1)
            intent1.putExtra("nature", nature1)
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