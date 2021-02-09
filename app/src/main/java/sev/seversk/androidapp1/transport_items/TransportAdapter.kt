package sev.seversk.androidapp1.transport_items

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
        var pit1 = Html.fromHtml(transportList.get(position).pitstop)

        holder.transport_title.text = title1
        holder.transport_number.text = ("Маршрут №"+number1)
        holder.transport_pit.text = pit1
        holder.transport_length.text = length1

        holder.card.setOnClickListener {
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()

        }
    }


    fun setTransportListItems(transportList: List<Transport>) {
        this.transportList = transportList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val transport_title = itemView.findViewById<TextView>(R.id.bus_title)
        val transport_number = itemView.findViewById<TextView>(R.id.bus_numer)
        val transport_pit = itemView.findViewById<TextView>(R.id.bus_pitstop)
        val transport_length = itemView.findViewById<TextView>(R.id.bus_lenght11)
        val card = itemView.findViewById<CardView>(R.id.card_bus)
    }


}