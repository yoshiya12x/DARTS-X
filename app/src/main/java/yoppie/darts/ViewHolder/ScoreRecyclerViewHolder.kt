package yoppie.darts.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import yoppie.darts.R

class ScoreRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemDateTextView: TextView = view.findViewById(R.id.item_date_text_view)
    val itemThrowCountTextView: TextView = view.findViewById(R.id.item_throw_count_text_view)
    val itemBullCountTextView: TextView = view.findViewById(R.id.item_bull_count_text_view)
    val itemT20CountTextView: TextView = view.findViewById(R.id.item_t20_count_text_view)
    val itemT19CountTextView: TextView = view.findViewById(R.id.item_t19_count_text_view)
    val itemT18CountTextView: TextView = view.findViewById(R.id.item_t18_count_text_view)
    val itemT17CountTextView: TextView = view.findViewById(R.id.item_t17_count_text_view)
    val itemT16CountTextView: TextView = view.findViewById(R.id.item_t16_count_text_view)
    val itemT15CountTextView: TextView = view.findViewById(R.id.item_t15_count_text_view)
}
