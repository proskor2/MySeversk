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
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
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

//        var commenttext = Html.fromHtml(commentList.get(position).c)
        var commentautor = Html.fromHtml(commentList.get(position).title)
//        var commentdate = Html.fromHtml(commentList.get(position).create_time)

//        holder.commenttext1.text = commenttext
        holder.commentautor1.text = commentautor
//        holder.commentdate1.text = commentdate

//        Glide.with(context).load(photocommentautor)
//            .apply(RequestOptions().centerCrop())
//            .into(holder.newsImage)

        holder.card1.setOnClickListener(){
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()

        }
    }

    fun setCommentListItems(commentList: List<comment>){
        this.commentList = commentList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val commenttext1 = itemView.findViewById<TextView>(R.id.text_commenttext)
        val commentautor1 = itemView.findViewById<TextView>(R.id.text_autorcomment)
        val commentdate1 = itemView.findViewById<TextView>(R.id.text_datecomment)
        val card1 = itemView.findViewById<CardView>(R.id.card_comment)
    }
}