package sev.seversk.androidapp1.events_items

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.eventid


class AfishaAdapter(val context: Context): RecyclerView.Adapter<AfishaAdapter.MyViewHolder>() {

    var afishaList: List<Afisha> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AfishaAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_afisha, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return afishaList.size
    }

    override fun onBindViewHolder(holder: AfishaAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(afishaList.get(position).title)
        var pre_photo = afishaList.get(position).photo
        var photo1 ="https://"+"$pre_photo"
        var date1 = Html.fromHtml(afishaList.get(position).date)
        var idevent = Html.fromHtml(afishaList.get(position).id.toString())
        var comm = Html.fromHtml(afishaList.get(position).comments_count.toString())

        holder.afisha_title.text = title1
        Glide.with(context).load(photo1)
            .apply(RequestOptions().centerCrop())
            .into(holder.newsImage)
        holder.afisha_date.text = date1
        holder.card.setOnClickListener {

            val intent1 = Intent(this.context, event_web::class.java)
            intent1.putExtra("idevent", idevent)
            intent1.putExtra("comm", comm)
            ContextCompat.startActivity(context, intent1, null)
        }
    }

    fun setAfishaListItems(afishaList: List<Afisha>){
        this.afishaList = afishaList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val afisha_title = itemView.findViewById<TextView>(R.id.text_afisha_title)
        val afisha_date = itemView.findViewById<TextView>(R.id.text_afiasha_data)
        val newsImage = itemView.findViewById<ImageView>(R.id.image_afisha)
        val card = itemView.findViewById<CardView>(R.id.card_afisha)
    }



}