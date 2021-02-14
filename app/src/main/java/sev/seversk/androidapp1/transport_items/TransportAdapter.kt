package sev.seversk.androidapp1.transport_items

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.authorization.startActivity

class TransportAdapter(val context: Context): RecyclerView.Adapter<TransportAdapter.MyViewHolder>() {

    var transportList: List<Transport> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransportAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.example_transport, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transportList.size
    }


    override fun onBindViewHolder(holder: TransportAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(transportList.get(position).title)
        var number1 = Html.fromHtml(transportList.get(position).number)
        var length1 = Html.fromHtml(transportList.get(position).length)
        var datebegin1 = Html.fromHtml(transportList.get(position).dateBegin)
        var payrules1 = Html.fromHtml(transportList.get(position).payRules)

        val streetF = Html.fromHtml(transportList.get(position).streetForward.toString())
        val streetB = Html.fromHtml(transportList.get(position).streetBack.toString())
        val stopF = Html.fromHtml(transportList.get(position).stopForward.toString())
        val stopB = Html.fromHtml(transportList.get(position).stopBack.toString())

        val carriers = Html.fromHtml(transportList.get(position).carrier.toString())
        val typebus = Html.fromHtml(transportList.get(position).typeBus.toString())




        holder.transport_title.text = title1
        holder.transport_number.text = ("Маршрут №"+number1)
        holder.transport_length.text = ("Протяженность"+length1)

        holder.card.setOnClickListener {
            val intent = Intent(this.context, bus_detail::class.java)
            intent.putExtra("busnumber", number1)
            intent.putExtra("busntitle", title1)
            intent.putExtra("busdate", datebegin1)
            intent.putExtra("buslength", length1)
            intent.putExtra("buspayrules", payrules1)

            intent.putExtra("streetF", streetF)
            intent.putExtra("streetB", streetB)
            intent.putExtra("stopF", stopF)
            intent.putExtra("stopB", stopB)
            intent.putExtra("carriers", carriers)
            intent.putExtra("typebus", typebus)
            context.startActivity(intent)
        }
    }


    fun setTransportListItems(transportList: List<Transport>) {
        this.transportList = transportList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val transport_title = itemView.findViewById<TextView>(R.id.bus_title)
        val transport_number = itemView.findViewById<TextView>(R.id.bus_numer)
        val transport_length = itemView.findViewById<TextView>(R.id.bus_lenght11)
        val card = itemView.findViewById<CardView>(R.id.card_bus)
    }


}