package yoppie.darts.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import yoppie.darts.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_darts_button.setOnClickListener {
            val intent = Intent(this, PracticeActivity::class.java)
            val screenName = screen_name_edit_text.text.toString()
            if(screenName.isNotBlank()){
                intent.putExtra("TWITTER_SCREEN_NAME_KEY", screenName)
                startActivity(intent)
            }
        }
    }
}
