package sev.seversk.androidapp1.news_items

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.activities_main.newsid
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.ui.mainscreen.Activ

class RecyclerAdapter(val context: Context): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var newsList: List<News> = listOf()
    var activList: List<Activ> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_news, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }



    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(newsList.get(position).title)
        var prev1 = Html.fromHtml(newsList.get(position).preview)
        var pre_photo = newsList.get(position).photo
        var photo1 ="https://"+"$pre_photo"
        var desc = Html.fromHtml(newsList.get(position).description)
        var date1 = Html.fromHtml(newsList.get(position).date)

        holder.newsName.text = title1
        holder.newsDescr.text = prev1
        Glide.with(context).load(photo1)
            .apply(RequestOptions().centerCrop())
            .into(holder.newsImage)
        holder.card.setOnClickListener(){
//            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
            val intent1 = Intent(this@RecyclerAdapter.context, newsid::class.java)
            intent1.putExtra("detail", desc)
            intent1.putExtra("daten", date1)
            intent1.putExtra("photon", photo1)
            ContextCompat.startActivity(context, intent1, null)
        }

    }


    fun setNewsListItems(newsList: List<News>){
        this.newsList = newsList
        notifyDataSetChanged()
    }

    fun setActivListItems(activList: List<Activ>){
        this.activList = activList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val newsName = itemView.findViewById<TextView>(R.id.text_news1)
        val newsDescr = itemView.findViewById<TextView>(R.id.text_news2)
        val newsImage = itemView.findViewById<ImageView>(R.id.news_photo1)
        val card = itemView.findViewById<CardView>(R.id.card_news)
    }




}