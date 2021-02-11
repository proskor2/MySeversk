package sev.seversk.androidapp1.comment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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

        val user = commentList.get(position).user
        val created = commentList.get(position).create_time
        val textcomment = commentList.get(position).comment_text

        holder.commentautor1.text = user
        holder.commentdate1.text = created
        holder.commenttext1.text = textcomment


        holder.card1.setOnClickListener {

        }
    }

    fun setCommentListItems(commentList: List<comment>?){
        if (commentList != null) {
            this.commentList = commentList
        }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val commentautor1 = itemView.findViewById<TextView>(R.id.text_autorcomment)
        val commenttext1 = itemView.findViewById<TextView>(R.id.text_commenttext)
        val commentdate1 = itemView.findViewById<TextView>(R.id.text_datecomment)
        val card1 = itemView.findViewById<LinearLayout>(R.id.card_comment)
    }
}