package sev.seversk.androidapp1.opros_items

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sev.seversk.androidapp1.R


class questionAdapter (val context: Context): RecyclerView.Adapter<questionAdapter.MyViewHolder>() {

    var qList: List<questions> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): questionAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_variant, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return qList.size
    }
    override fun onBindViewHolder(holder: questionAdapter.MyViewHolder, position: Int) {

        val question = qList.get(position).question
        holder.textopros.text = question
        holder.card1.setOnClickListener {

        }
    }

    fun setqListItems(qList: List<questions>?){
        if (qList != null) {
            this.qList = qList
        }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textopros = itemView.findViewById<TextView>(R.id.text_startopros_title)
        val card1 = itemView.findViewById<LinearLayout>(R.id.card_variant)
    }
}