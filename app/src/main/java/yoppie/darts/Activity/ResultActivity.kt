package yoppie.darts.Activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_result.*
import yoppie.darts.Adapter.ScoreRecyclerAdapter
import yoppie.darts.Entity.DartScore
import yoppie.darts.R

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val dartScore: DartScore = intent.getSerializableExtra("MANAGE_COUNT_KEY") as DartScore
        val oldScoreList = intent.getSerializableExtra("OLD_SCORE_KEY") as ArrayList<DartScore>

        throw_count_text_view.text = "Throw count : ${dartScore.throwCount}"
        bull_count_text_view.text = "Bull : ${dartScore.bullCount}"
        t20_count_text_view.text = "T20 : ${dartScore.t20Count}"
        t19_count_text_view.text = "T19 : ${dartScore.t19Count}"
        t18_count_text_view.text = "T18 : ${dartScore.t18Count}"
        t17_count_text_view.text = "T17 : ${dartScore.t17Count}"
        t16_count_text_view.text = "T16 : ${dartScore.t16Count}"
        t15_count_text_view.text = "T15 : ${dartScore.t15Count}"

        val scoreRecyclerAdapter = ScoreRecyclerAdapter(this, oldScoreList)
        score_recycler_view.adapter = scoreRecyclerAdapter
        score_recycler_view.layoutManager = LinearLayoutManager(this)

    }

}
