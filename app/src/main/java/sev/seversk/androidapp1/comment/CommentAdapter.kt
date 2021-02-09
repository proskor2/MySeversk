package sev.seversk.androidapp1.comment

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
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
    var arraycomment: ArrayList<comments> = ArrayList()

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

//        val commenttitle = Html.fromHtml(commentList.get(position).title)
//        holder.commenttitle.text = commenttitle

//        var commenttext = Html.fromHtml(commentList.get(position).comment_text)
//        var commentuser = Html.fromHtml(commentList.get(position).user)
//        var commentdate = Html.fromHtml(commentList.get(position).create_time)
//        holder.commentautor1.text = commentuser
//        holder.commentdate1.text = commentdate
//        holder.commenttext1.text = commenttext

//        Glide.with(context).load(photocommentautor)
//            .apply(RequestOptions().centerCrop())
//            .into(holder.newsImage)

        holder.card1.setOnClickListener {
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()

        }
    }

    fun setCommentListItems(commentList: comment){
        this.commentList = listOf(commentList)
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val commentautor1 = itemView.findViewById<TextView>(R.id.text_autorcomment)
        val commenttext1 = itemView.findViewById<TextView>(R.id.text_commenttext)
        val commentdate1 = itemView.findViewById<TextView>(R.id.text_datecomment)
//        val commenttitle = itemView.findViewById<TextView>(R.id.text_comments_namenews)
        val card1 = itemView.findViewById<LinearLayout>(R.id.card_comment)
    }
}