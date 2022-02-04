package com.alfayedoficial.kotlinutils

import android.os.Handler
import android.os.Looper

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/4/2022 - 6:28 PM
 */
object Utils {

    /**
     * @author Ali Al Fayed
     * @param delayMillis it is delay time by millisecond but default value is 200 millis
     * @param action it is function to do after delay time gone
     */
    fun kuRunDelayed(delayMillis: Long = 200, action: () -> Unit) =
        Handler(Looper.myLooper()!!).postDelayed(Runnable(action), delayMillis)


}