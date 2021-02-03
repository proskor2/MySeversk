package sev.seversk.androidapp1.comment

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import sev.seversk.androidapp1.R


class CommentAdapter(val context: Context): RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {

    var commentList: List<comment> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_comment, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }



    override fun onBindViewHolder(holder: CommentAdapter.MyViewHolder, position: Int) {

//        var title1 = Html.fromHtml(commentList.get(position).title)
        var commenttext = Html.fromHtml(commentList.get(position).comment_text)
        var commentautor = Html.fromHtml(commentList.get(position).user)
        var commentdate = Html.fromHtml(commentList.get(position).create_time)


//        Glide.with(context).load(photocommentautor)
//            .apply(RequestOptions().centerCrop())
//            .into(holder.newsImage)



        holder.card.setOnClickListener(){
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()
//            val intent1 = Intent(this@AfishaAdapter.context, eventid::class.java)
//            intent1.putExtra("daten", date1)
//            intent1.putExtra("photon", photo1)
//            ContextCompat.startActivity(context, intent1, null)
        }
    }


    fun setCommentListItems(commentList: List<comment>){
        this.commentList = commentList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val commenttext = itemView.findViewById<TextView>(R.id.text_commenttext)
        val commentautor = itemView.findViewById<TextView>(R.id.text_autorcomment)
        val commentdate = itemView.findViewById<ImageView>(R.id.text_datecomment)
        val card = itemView.findViewById<CardView>(R.id.card_comment)
    }



}