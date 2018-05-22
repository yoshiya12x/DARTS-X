package yoppie.darts.Twitter

import android.util.Log
import android.widget.ImageView
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.core.services.StatusesService

class Search(private val screenName: String,
             private val twitterStatusesService: StatusesService) {

    private var lastTwitterId: Long? = null

    fun setImage(changeImageList: ArrayList<ImageView>) {
        val call = this.twitterStatusesService.userTimeline(
                null,
                this.screenName,
                changeImageList.size + 1,
                null,
                lastTwitterId,
                false,
                false,
                false,
                false
        )
        call.enqueue(object : Callback<List<Tweet>>() {
            override fun success(result: Result<List<Tweet>>) {
                var imageListCount = 0
                result.data.forEach {
                    if(changeImageList.size == imageListCount){
                        lastTwitterId = it.id
                    }else{
                        val regex = Regex("https://.+")
                        regex.findAll(it.text)
                                .map { it.value }
                                .forEach {
                                    val crawler = Crawler(it, changeImageList.get(imageListCount))
                                    crawler.execute()
                                }
                    }
                    imageListCount ++
                }
            }

            override fun failure(exception: TwitterException) {
                Log.d("error", "twitter_error")
            }
        })
    }
}
