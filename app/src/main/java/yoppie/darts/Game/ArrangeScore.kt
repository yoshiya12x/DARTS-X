package yoppie.darts.Game

import yoppie.darts.Entity.DartScore
import yoppie.darts.Entity.DartScore_Selector

class ArrangeScore {
    fun convertScore(dartScoreSelector: DartScore_Selector): ArrayList<DartScore> {
        val dartScoreList = ArrayList<DartScore>()
        dartScoreSelector.forEach{
            val dartScore = DartScore()
            dartScore.id = it.id
            dartScore.throwCount = it.throwCount
            dartScore.bullCount = it.bullCount
            dartScore.t20Count = it.t20Count
            dartScore.t19Count = it.t19Count
            dartScore.t18Count = it.t18Count
            dartScore.t17Count = it.t17Count
            dartScore.t16Count = it.t16Count
            dartScore.t15Count = it.t15Count
            dartScore.createdAt = it.createdAt
            dartScoreList.add(dartScore)
        }
        return dartScoreList
    }
}