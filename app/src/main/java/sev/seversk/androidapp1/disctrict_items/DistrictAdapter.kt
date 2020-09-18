package sev.seversk.androidapp1.disctrict_items

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
import sev.seversk.androidapp1.opros_items.Opros
import sev.seversk.androidapp1.opros_items.OprosAdapter

class DistrictAdapter(val context: Context): RecyclerView.Adapter<DistrictAdapter.MyViewHolder>() {

    var dsitrictList: List<District> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DistrictAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.example_district, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dsitrictList.size
    }


    override fun onBindViewHolder(holder: DistrictAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(dsitrictList.get(position).district_num)


        holder.district_title.text = title1

        holder.card.setOnClickListener() {
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
//            val intent1 = Intent(this@AfishaAdapter.context, eventid::class.java)
//            intent1.putExtra("daten", date1)
//            intent1.putExtra("photon", photo1)
//            ContextCompat.startActivity(context, intent1, null)
        }
    }


    fun setOprosListItems(dsitrictList: List<District>) {
        this.dsitrictList = dsitrictList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val district_title = itemView.findViewById<TextView>(R.id.text_district)

        val card = itemView.findViewById<CardView>(R.id.card_district)
    }


}