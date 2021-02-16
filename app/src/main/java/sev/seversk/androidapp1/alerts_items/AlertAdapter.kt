package sev.seversk.androidapp1.alerts_items

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
import sev.seversk.androidapp1.authorization.startActivity


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

        val title1 = Html.fromHtml(alertList.get(position).title)
        val status1 = Html.fromHtml(alertList.get(position).updated)
//        val emerg1 = Html.fromHtml(alertList.get(position).emergency)
        val created1 = Html.fromHtml(alertList.get(position).created)
        val desc1 = Html.fromHtml(alertList.get(position).description)

        holder.alert_title.text = title1
        holder.alert_upd.text = ("Последнее изменение: "+status1)
        holder.card.setOnClickListener {
            val intent = Intent(this.context, alert_description::class.java)
//            intent.putExtra("emerg", emerg1)
            intent.putExtra("title", title1)
            intent.putExtra("update", status1)
            intent.putExtra("create", created1)
            intent.putExtra("desc", desc1)
            ContextCompat.startActivity(context, intent, null)
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
