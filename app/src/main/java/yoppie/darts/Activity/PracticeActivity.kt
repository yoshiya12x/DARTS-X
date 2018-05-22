package yoppie.darts.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_practice.*
import yoppie.darts.Database.ScoreDatabase
import yoppie.darts.Entity.DartScore
import yoppie.darts.Game.ManageImage
import yoppie.darts.R
import yoppie.darts.Twitter.ApiClient
import yoppie.darts.Twitter.Search
import java.util.*

class PracticeActivity : AppCompatActivity() {

    private lateinit var search: Search
    private lateinit var manageImage: ManageImage
    private lateinit var dartScore: DartScore
    private var count59 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        val screenName = intent.getStringExtra("TWITTER_SCREEN_NAME_KEY")

        // ManageImageインスタンスを作成
        this.manageImage = ManageImage()

        // Searchインスタンスを作成
        val apiClient = ApiClient(
                this,
                getString(R.string.twitter_consumer_key),
                getString(R.string.twitter_consumer_secret))
        this.search = Search(screenName, apiClient.getStatusesService())

        // ScoreEntityのインスタンスを作成
        this.dartScore = DartScore()

        // 初期画像をセット
        val changeImageList = ArrayList<ImageView>()
        changeImageList.add(bonus_image_view_1)
        changeImageList.add(bonus_image_view_2)
        changeImageList.add(bonus_image_view_3)
        this.search.setImage(changeImageList)

        // 過去のスコアをintentに付与
        val intentResultActivity = Intent(this, ResultActivity::class.java)
        val scoreDatabase = ScoreDatabase()
        scoreDatabase.select(this, intentResultActivity)

        // BACKボタン押下時の挙動
        back_to_top_button.setOnClickListener {
            val intentMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentMainActivity)
        }

        // RESULTボタン押下時の挙動
        move_to_result_button.setOnClickListener {
            this.dartScore.putCreatedAt(Date())
            scoreDatabase.insert(this.dartScore, this)
            intentResultActivity.putExtra("MANAGE_COUNT_KEY", this.dartScore)
            startActivity(intentResultActivity)
        }
    }

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        Log.d("debug_keyevent", event!!.keyCode.toString())

        if (event.action == KeyEvent.ACTION_DOWN) {
            if (this.count59 == 0) {
                when (event.keyCode) {
                    11, 76, 38, 32 -> controlHighScore(event.keyCode)
                    59 -> this.count59++
                    else -> dartScore.throwCountUP()
                }
            } else if (this.count59 == 1) {
                when (event.keyCode) {
                    42, 51, 44, 54 -> controlHighScore(event.keyCode)
                    else -> dartScore.throwCountUP()
                }
                this.count59 = 0
            }
        }

        return super.dispatchKeyEvent(event)
    }

    private fun controlHighScore(scorePoint: Int) {
        dartScore.throwCountUP()
        dartScore.countUp(scorePoint)
        changeImage()
    }

    private fun changeImage() {
        if (this.manageImage.getShowImageNumber() != 0) {
            this.reloadImage()
        }
        target_text_view.visibility = View.GONE
        this.manageImage.changeImageNumber()
        this.manageImage.changeImageState()
        bonus_image_view_1.visibility = this.manageImage.getImage1State()
        bonus_image_view_2.visibility = this.manageImage.getImage2State()
        bonus_image_view_3.visibility = this.manageImage.getImage3State()
    }

    private fun reloadImage() {
        val targetImageView = when (this.manageImage.getShowImageNumber()) {
            1 -> bonus_image_view_1
            2 -> bonus_image_view_2
            3 -> bonus_image_view_3
            else -> bonus_image_view_1
        }

        val changeImageList = ArrayList<ImageView>()
        changeImageList.add(targetImageView)
        this.search.setImage(changeImageList)
    }
}
