package yoppie.darts.Twitter

import android.content.Context
import android.util.Log
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.services.StatusesService

class ApiClient(context: Context, key: String, secret: String) {

    private var statusesService: StatusesService

    init {
        val twitterConfig = TwitterConfig.Builder(context)
                .logger(DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(TwitterAuthConfig(key, secret))
                .debug(true)
                .build()
        Twitter.initialize(twitterConfig)
        val twitterApiClient = TwitterCore.getInstance().apiClient
        this.statusesService = twitterApiClient.statusesService as StatusesService
    }

    fun getStatusesService(): StatusesService {
        return this.statusesService
    }
}
