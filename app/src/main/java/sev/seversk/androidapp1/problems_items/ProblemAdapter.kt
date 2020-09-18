package sev.seversk.androidapp1.problems_items

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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import sev.seversk.androidapp1.R


class ProblemAdapter(val context: Context): RecyclerView.Adapter<ProblemAdapter.MyViewHolder>() {

    var problemsList: List<Problem> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProblemAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_problems, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return problemsList.size
    }


    override fun onBindViewHolder(holder: ProblemAdapter.MyViewHolder, position: Int) {

        var title1 = Html.fromHtml(problemsList.get(position).title)
        var user1 = Html.fromHtml(problemsList.get(position).user)
        var pre_photo = problemsList.get(position).photo
        var photo1 = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai" + pre_photo
        val description1 = Html.fromHtml(problemsList.get(position).description)
        var create1 = Html.fromHtml(problemsList.get(position).created)
        var update1 = Html.fromHtml(problemsList.get(position).updated)
        var status1 = Html.fromHtml(problemsList.get(position).status)

        holder.problems_title.text = title1
        holder.problems_user.text = ("Автор: "+user1)
        holder.problem_descr.text = description1
        holder.problem_status.text = status1
        Glide.with(context).load(photo1)
            .apply(RequestOptions().centerCrop())
            .into(holder.problem_photo)


        holder.card.setOnClickListener() {
            Toast.makeText(this.context, "Position $position", Toast.LENGTH_SHORT).show()

        }

    }


    fun setProblemListItems(problemsList: List<Problem>) {
        this.problemsList = problemsList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val problems_user = itemView.findViewById<TextView>(R.id.text_problem_user)
        val problems_title = itemView.findViewById<TextView>(R.id.text_newproblem_title)
        val problem_descr = itemView.findViewById<TextView>(R.id.text_newproblem_descr)
        val problem_status = itemView.findViewById<TextView>(R.id.text_problem_status)
        val problem_photo = itemView.findViewById<ImageView>(R.id.image_problem)
        val card = itemView.findViewById<CardView>(R.id.card_problem)
    }
}