package jp.shiguredo.sora.sdk

import android.content.Context
import jp.shiguredo.sora.sdk.ng.Configuration
import jp.shiguredo.sora.sdk.ng.MediaChannel

class Sora {

    companion object {

        fun connect(configuration: Configuration,
                    completionHandler: (Result<MediaChannel>) -> Unit) {
            val mediaChannel = MediaChannel(configuration)
            mediaChannel.connect() { error ->
                if (error == null) {
                    completionHandler(Result.failure(error!!))
                } else {
                    completionHandler(Result.success(mediaChannel))
                }
            }
        }

    }

}