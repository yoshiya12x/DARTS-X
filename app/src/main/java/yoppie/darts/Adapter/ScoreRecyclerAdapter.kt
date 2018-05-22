package yoppie.darts.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import yoppie.darts.Entity.DartScore
import yoppie.darts.R
import yoppie.darts.ViewHolder.ScoreRecyclerViewHolder
import java.util.*

class ScoreRecyclerAdapter(private val context: Context, private val itemList: ArrayList<DartScore>) : RecyclerView.Adapter<ScoreRecyclerViewHolder>() {

    override fun getItemCount(): Int = itemList.count()

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ScoreRecyclerViewHolder, position: Int) {
        holder.let{
            val score = itemList[position]
            Log.d("debug_item_position", position.toString())
            Log.d("debug_item_id", score.id.toString())
            Log.d("debug_item_date",score.createdAt)

            it.itemDateTextView.text = score.createdAt
            it.itemThrowCountTextView.text = "Throw count : ${score.throwCount}"
            it.itemBullCountTextView.text = "Bull : ${score.bullCount}"
            it.itemT20CountTextView.text = "T20 : ${score.t20Count}"
            it.itemT19CountTextView.text = "T19 : ${score.t19Count}"
            it.itemT18CountTextView.text = "T18 : ${score.t18Count}"
            it.itemT17CountTextView.text = "T17 : ${score.t17Count}"
            it.itemT16CountTextView.text = "T16 : ${score.t16Count}"
            it.itemT15CountTextView.text = "T15 : ${score.t15Count}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val scoreRecyclerViewItem = layoutInflater.inflate(R.layout.score_recycler_view_item, parent, false)
        return ScoreRecyclerViewHolder(scoreRecyclerViewItem)
    }

}