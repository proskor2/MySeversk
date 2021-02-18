package sev.seversk.androidapp1.emergency

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

class EmergAdapter (val context: Context): RecyclerView.Adapter<EmergAdapter.MyViewHolder>() {

    var emergList: List<Emergency> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_emerg, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emergList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(emergList.get(position).title)
//        var type1 = Html.fromHtml(emergList.get(position).type)
        var address1 = Html.fromHtml(emergList.get(position).address)
        var email1 = Html.fromHtml(emergList.get(position).email)
        var site1 = Html.fromHtml(emergList.get(position).site)



        var emplstring = Html.fromHtml(emergList.get(position).employees.toString())
        var phonestring = Html.fromHtml(emergList.get(position).phones.toString())
        var coordsstring = Html.fromHtml(emergList.get(position).coords.toString())

        holder.emerg_title.text = title1
        holder.emerg_address.text = address1

        holder.card.setOnClickListener {
            val intent1 = Intent(this.context, emerg_detail::class.java)
            intent1.putExtra("title", title1)
            intent1.putExtra("position", position)
            intent1.putExtra("address", address1)
            intent1.putExtra("email", email1)
            intent1.putExtra("site", site1)
            ContextCompat.startActivity(context, intent1, null)
        }
    }

    fun setEmergListItems(emergList: List<Emergency>){
        this.emergList = emergList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val emerg_title = itemView.findViewById<TextView>(R.id.text_emerg_title)
        val emerg_address = itemView.findViewById<TextView>(R.id.text_emerg_address)
        val card = itemView.findViewById<CardView>(R.id.card_variant)
    }



}
