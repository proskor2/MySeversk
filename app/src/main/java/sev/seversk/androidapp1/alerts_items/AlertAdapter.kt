package sev.seversk.androidapp1.alerts_items

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import sev.seversk.androidapp1.R


class AlertAdapter (val context: Context): RecyclerView.Adapter<AlertAdapter.MyViewHolder>() {

    var alertList: List<Alert> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlertAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.example_alert, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return alertList.size
    }


    override fun onBindViewHolder(holder: AlertAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(alertList.get(position).title)
        var status1 = Html.fromHtml(alertList.get(position).updated)

        holder.alert_title.text = title1
        holder.alert_upd.text = ("Последнее изменение: "+status1)
        holder.card.setOnClickListener() {
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
        }
    }


    fun setAlertListItems(oprosList: List<Alert>) {
        this.alertList = oprosList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alert_title = itemView.findViewById<TextView>(R.id.text_alert_title1)
        val alert_upd = itemView.findViewById<TextView>(R.id.text_alert_upd)
        val card = itemView.findViewById<CardView>(R.id.card_alert)
    }


}
