package yoppie.darts.Database

import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.experimental.async
import yoppie.darts.Entity.DartScore
import yoppie.darts.Entity.OrmaDatabase
import yoppie.darts.Game.ArrangeScore

class ScoreDatabase {
    fun insert(score: DartScore, context: Context) {
        async {
             OrmaDatabase.builder(context).build().insertIntoDartScore(score)
        }
    }

    fun select(context: Context, intent: Intent){
        async {
            val scoreSelector = OrmaDatabase
                    .builder(context)
                    .build()
                    .selectFromDartScore()
                    .orderByIdDesc()
            val arrangeScore = ArrangeScore()
            val scoreList = arrangeScore.convertScore(scoreSelector)
            intent.putExtra("OLD_SCORE_KEY", scoreList)
        }
    }
}
