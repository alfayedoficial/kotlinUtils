package com.alfayedoficial.kotlinutils

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.RequiresPermission
import androidx.annotation.StringRes
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import com.alfayedoficial.kotlinutils.KUConstants.KU_GOOGLE_PLAY_URL
import com.alfayedoficial.kotlinutils.KUConstants.KU_MARKET_PLAY_ID
import com.google.android.material.snackbar.Snackbar
import java.util.*


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Extensions of many functions
 * Date 3/7/2021 - 2:24 PM
 */

/**
 * @author Ali Al Fayed
 * @param delayMillis it is delay time by millisecond but default value is 200 millis
 * @param action it is function to do after delay time gone
 */
fun kuRunDelayed(delayMillis: Long = 200, action: () -> Unit) =
    Handler(Looper.myLooper()!!).postDelayed(Runnable(action), delayMillis)

/**
 * @author Ali Al Fayed
 * @param delayMillis it is delay time by millisecond but default value is 200 millis
 * @param action it is function to do after delay time gone
 * this function rin on UI Thread
 */
fun kuRunDelayedOnUiThread(delayMillis: Long, action: () -> Unit) =
    Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)

/**
 * @author Ali Al Fayed
 * @param text text of toast
 * @param duration Toast.LENGTH but default is Toast.LENGTH_SHORT
 * call function from any Activity
 */
fun Activity.kuToast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, duration).show()

/**
 * @author Ali Al Fayed
 * @param text text of toast
 * @param duration Toast.LENGTH but default is Toast.LENGTH_SHORT
 * call function from any Fragment
 */
fun Fragment.kuToast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    activity?.run { kuToast(text, duration) }

/**
 * @author Ali Al Fayed
 * @param text text of toast
 * @param duration Toast.LENGTH but default is Toast.LENGTH_SHORT
 * call function from any Context
 */
fun Context.kuToast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this.applicationContext, text, duration).show()

/**
 * @author Ali Al Fayed
 * @param stringRes id of String resource
 * @param duration Toast.LENGTH but default is Toast.LENGTH_SHORT
 * call function from any Activity
 */
fun Activity.kuToast(@StringRes stringRes: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, stringRes, duration).show()

/**
 * @author Ali Al Fayed
 * @param stringRes id of String resource
 * @param duration Toast.LENGTH but default is Toast.LENGTH_SHORT
 * call function from any Fragment
 */
fun Fragment.kuToast(@StringRes stringRes: Int, duration: Int = Toast.LENGTH_SHORT) =
    activity?.run { kuToast(stringRes, duration) }

/**
 * @author Ali Al Fayed
 * @param stringRes id of String resource
 * @param duration Toast.LENGTH but default is Toast.LENGTH_SHORT
 * call function from any Context
 */
fun Context.kuToast(@StringRes stringRes: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this.applicationContext, stringRes, duration).show()


/**
 * @author Ali Al Fayed
 * @param text text of SnackBar
 * @param duration Snack_bar.LENGTH but default is Snack_bar.LENGTH_LONG
 * @return Snackbar
 * must be call show() after init function
 * call function from any Activity
 */
fun Activity.kuSnackBar(text: String , duration: Int = Snackbar.LENGTH_LONG): Snackbar {
    return Snackbar.make(findViewById(android.R.id.content), text,duration).apply {
        val mTextView = view.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
        mTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * @author Ali Al Fayed
 * @param text text of SnackBar
 * @param duration Snack_bar.LENGTH but default is Snack_bar.LENGTH_LONG
 * @return Snackbar
 * must be call show() after init function
 * call function from any Fragment
 */
fun Fragment.kuSnackBar(text: String , duration: Int = Snackbar.LENGTH_LONG): Snackbar? = activity?.run { kuSnackBar(text , duration) }

/**
 * @author Ali Al Fayed
 * @param text text of SnackBar
 * @param bgColor background color of snack bar
 * @param tvColor  text color of snack bar
 * @param duration Snack_bar.LENGTH but default is Snack_bar.LENGTH_LONG
 * call function from any Activity
 */
fun Activity.kuSnackBarError(text: String ,@ColorInt bgColor : Int  ,@ColorInt tvColor : Int = Color.WHITE, duration: Int = Snackbar.LENGTH_LONG) {
    val snackBar = Snackbar.make(findViewById(android.R.id.content), text ,duration)
    snackBar.apply {
        view.setBackgroundColor(bgColor)
        val mTextView = view.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
        mTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        setTextColor(tvColor)
        show()
    }
}

/**
 * @author Ali Al Fayed
 * @param text text of SnackBar
 * @param bgColor background color of snack bar
 * @param tvColor  text color of snack bar
 * @param duration Snack_bar.LENGTH but default is Snack_bar.LENGTH_LONG
 * call function from any Fragment
 */
fun Fragment.kuSnackBarError(text: String, @ColorInt bgColor : Int,@ColorInt tvColor : Int = Color.WHITE, duration: Int = Snackbar.LENGTH_LONG) =
    activity?.run { kuSnackBarError(text, bgColor, tvColor, duration) }

/**
 * @author Ali Al Fayed
 * hide soft Keyboard
 * call function from any Activity
 */
fun Activity.kuHideSoftKeyboard() {
    currentFocus?.run {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}

/**
 * @author Ali Al Fayed
 * hide soft Keyboard
 * call function from any Fragment
 */
fun Fragment.kuHideSoftKeyboard() =  activity?.run { kuHideSoftKeyboard() }

/**
 * @author Ali Al Fayed
 * @param view you want to take focus of screen
 * call function from any Activity
 */
fun Activity.kuTakeFocus(view: View){
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}

/**
 * @author Ali Al Fayed
 * @param view you want to take focus of screen
 * call function from any Fragment
 */
fun Fragment.kuTakeFocus(view: View)=  activity?.run { kuTakeFocus(view) }

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @return Intent
 * call function from any Fragment
 */
fun Activity.kuIntentClass(cls: Class<*>?): Intent {
    return Intent(this, cls)
}

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @return Intent
 * call function from any Fragment
 */
fun Fragment.kuIntentClass(cls: Class<*>?): Intent? = activity?.run { kuIntentClass(cls) }

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @param extra this is vararg has key and value
 * @return Intent has putExtra
 * call function from any Activity
 */
fun Activity.kuIntentClass(cls: Class<*>?, vararg extra:Pair<String, Any>): Intent {
    val intent = Intent(this,cls)
    extra.forEach {
        when(it.second){
            is String ->{ intent.putExtra(it.first , it.second as String)}
            is Float ->{intent.putExtra(it.first , it.second as Float)}
            is Double ->{intent.putExtra(it.first , it.second as Double)}
            is Int ->{intent.putExtra(it.first , it.second as Int)}
            is Boolean ->{intent.putExtra(it.first , it.second as Boolean)}
        }
    }
    return intent
}

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @param extra this is vararg has key and value
 * @return Intent has putExtra
 * call function from any Fragment
 */
fun Fragment.kuIntentClass(cls: Class<*>?, vararg extra:Pair<String, Any>): Intent? {
    var intent: Intent? =null
    activity?.run {
        intent = Intent(this,cls)
        extra.forEach {
            when(it.second){
                is String ->{intent!!.putExtra(it.first , it.second as String)}
                is Float ->{intent!!.putExtra(it.first , it.second as Float)}
                is Double ->{intent!!.putExtra(it.first , it.second as Double)}
                is Int ->{intent!!.putExtra(it.first , it.second as Int)}
                is Boolean ->{intent!!.putExtra(it.first , it.second as Boolean)}
            }
        }
        return intent
    }
    return intent
}
/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @param extra this is vararg has key and value
 * @return Intent has putExtra
 * call function from any Context
 */
fun Context.kuIntentClass(cls: Class<*>?, vararg extra:Pair<String, Any>): Intent? {
    val intent = Intent(this,cls)
    extra.forEach {
        when(it.second){
            is String ->{ intent.putExtra(it.first , it.second as String)}
            is Float ->{intent.putExtra(it.first , it.second as Float)}
            is Double ->{intent.putExtra(it.first , it.second as Double)}
            is Int ->{intent.putExtra(it.first , it.second as Int)}
            is Boolean ->{intent.putExtra(it.first , it.second as Boolean)}
        }
    }
    return intent
}
/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * move to new class and set FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK
 * call function from any Activity
 */
fun Activity.kuClearIntentClass(cls: Class<*>?){
    val intent = kuIntentClass(cls)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    startActivity(intent)
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * move to new class and set FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK
 * call function from any Fragment
 */
fun Fragment.kuClearIntentClass(cls: Class<*>?) = activity?.run {kuClearIntentClass(cls)}

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @param extra this is vararg has key and value
 * move to new class and set FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK
 * call function from any Activity
 */
fun Activity.kuClearIntentClass(cls: Class<*>?, vararg extra:Pair<String, Any>) {
    val intent = kuIntentClass(cls)
    extra.forEach {
        when(it.second){
            is String ->{intent.putExtra(it.first , it.second as String)}
            is Float ->{intent.putExtra(it.first , it.second as Float)}
            is Double ->{intent.putExtra(it.first , it.second as Double)}
            is Int ->{intent.putExtra(it.first , it.second as Int)}
            is Boolean ->{intent.putExtra(it.first , it.second as Boolean)}
        }
    }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    startActivity(intent)
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @param extra this is vararg has key and value
 * move to new class and set FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK
 * call function from any Activity
 */
fun Context.kuClearIntentClass(cls: Class<*>?, vararg extra:Pair<String, Any>) {
    val intent = kuIntentClass(cls)
    extra.forEach {
        when(it.second){
            is String ->{intent?.putExtra(it.first , it.second as String)}
            is Float ->{intent?.putExtra(it.first , it.second as Float)}
            is Double ->{intent?.putExtra(it.first , it.second as Double)}
            is Int ->{intent?.putExtra(it.first , it.second as Int)}
            is Boolean ->{intent?.putExtra(it.first , it.second as Boolean)}
        }
    }
    intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    startActivity(intent)
}

/**
 * @author Ali Al Fayed
 * @param cls this is class you want to IntentClass
 * @param extra this is vararg has key and value
 * move to new class and set FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK
 * call function from any Fragment
 */
fun Fragment.kuClearIntentClass(cls: Class<*>?, vararg extra:Pair<String, Any>) = activity?.run {kuClearIntentClass(cls , *extra)}

/**
 * @author Ali Al Fayed
 * @param link this is link of website
 * open any website link from activity
 * call function from any Activity
 */
fun Activity.kuOpenLink(link : String){
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link)).apply {
            // The URL should either launch directly in a non-browser app (if it's
            // the default), or in the disambiguation dialog.
            addCategory(Intent.CATEGORY_BROWSABLE)
            flags = if (Build.VERSION.SDK_INT > 30){
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_REQUIRE_NON_BROWSER
            }else{
                Intent.FLAG_ACTIVITY_NEW_TASK
            }
        }
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // Only browser apps are available, or a browser is the default.
        // So you can open the URL directly in your app, for example in a
        // Custom Tab.
        val builderWeb = CustomTabsIntent.Builder()
        val intentWeb = builderWeb.build()
        intentWeb.launchUrl(this , Uri.parse(link))
    }

}

/**
 * @author Ali Al Fayed
 * @param link this is link of website
 * call function from any Fragment
 */
fun Fragment.kuOpenLink(link : String) = activity?.run { kuOpenLink(link) }


/**
 * @author Ali Al Fayed
 * @param number this is number you want to open
 * open any whatsapp number from activity
 * call function from any Activity
 */
const val noFoundWhatsApp = "WhatsApp not install, Please install WhatsApp"
fun Activity.kuOpenWhatsAppPhone(number : String , message: String? = noFoundWhatsApp){
    val sendIntent = Intent(Intent.ACTION_VIEW)
    sendIntent.data = Uri.parse("http://api.whatsapp.com/send?phone=$number")
    val appPackage: String
    when {
        isAppInstalled( "com.whatsapp") -> {
            appPackage = "com.whatsapp"
            val pm = packageManager
            pm.getPackageInfo(appPackage, PackageManager.GET_ACTIVITIES)
            startActivity(sendIntent)
        }
        isAppInstalled("com.whatsapp.w4b") -> {
            appPackage = "com.whatsapp.w4b"
            val pm = packageManager
            pm.getPackageInfo(appPackage, PackageManager.GET_ACTIVITIES)
            startActivity(sendIntent)
        }
        isAppInstalled( "Whatsapp.Gold.Plus") -> {
            appPackage = "Whatsapp.Gold.Plus"
            val pm = packageManager
            pm.getPackageInfo(appPackage, PackageManager.GET_ACTIVITIES)
            startActivity(sendIntent)
        }
        else -> {
//            toast(getString(R.string.noFoundWhatsApp))
            message?.let{kuToast(it)}
        }
    }
}

/**
 * Is app installed
 *
 * @param packageName
 * @return Boolean Check If App is Installed
 */
fun Context.isAppInstalled(packageName: String): Boolean {
    val pm: PackageManager = packageManager
    val appInstalled: Boolean = try {
        pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
    return appInstalled
}

/**
 * @author Ali Al Fayed
 * @param number this is number you want to open
 * call function from any Fragment
 */
fun Fragment.kuOpenWhatsAppPhone(number : String ,  message: String? = null) = activity?.run { kuOpenWhatsAppPhone(number , message) }

/**
 * Open map
 * @author Ali Al Fayed
 * @param latitude
 * @param longitude
 * open Google map by latitude , longitude
 * call function from any Activity
 */
fun Activity.openMap(latitude : Double, longitude: Double){
    val uri: String = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude)
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
    startActivity(intent)
}


/**
 * Open map
 * @author Ali Al Fayed
 * @param latitude
 * @param longitude
 * open Google map by latitude , longitude
 * call function from any Fragment
 */
fun Fragment.openMap(latitude : Double, longitude: Double){
    requireActivity().openMap(latitude, longitude)
}

/**
 * @author Ali Al Fayed
 * open app on google play market
 * call function from any Activity
 */
fun Activity.kuOpenAppOnGooglePlay(){
    val packageName = applicationContext?.packageName
    val uri: Uri = Uri.parse(KU_MARKET_PLAY_ID+packageName)
    val goToMarket = Intent(Intent.ACTION_VIEW, uri)
    // To count with Play market backstack, After pressing back button,
    // to taken back to our application, we need to add following flags to intent.
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
        goToMarket.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    }else{
        goToMarket.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    }
    try {
        startActivity(goToMarket)
    } catch (e: ActivityNotFoundException) {
        startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse(KU_GOOGLE_PLAY_URL+packageName))
        )
    }
}

/**
 * @author Ali Al Fayed
 * call function from any Fragment
 */
fun Fragment.kuOpenAppOnGooglePlay() = activity?.run { kuOpenAppOnGooglePlay() }

/**
 * @author Ali Al Fayed
 * Handler time 1000 millisecond ==> 1Second
 * throws  ActivityNotFoundException
 */
const val noFoundWifi = "No Have Wifi Feature"
fun Context.kuOpenWifi() {
    Handler(Looper.myLooper()!!).postDelayed({
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            (this as Activity).startActivity(intent)
        } catch (e: ActivityNotFoundException) {
//            kuToast(getString(R.string.noFoundWifi))
            kuToast(noFoundWifi)
        }
    }, 500.toLong())
}

/**
 * @author Ali Al Fayed
 * Get the Connectivity Manager
 * @return ConnectivityManager
 */
@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
private fun Context.getConnectivityManager(): ConnectivityManager {
    return getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}

/**
 * @author Ali Al Fayed
 * Check if there is any connectivity
 * @return boolean boolean
 */
@Suppress("DEPRECATION")
@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.kuIsConnected(): Boolean {
    var result = 0 // Returns connection type. 0: none; 1: mobile data; 2: wifi
    val cm = getConnectivityManager()
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
        cm.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        result = 1
                    }
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        result = 2
                    }
                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> {
                        result = 3
                    }
                }
            }
        }
    }else {
        val info = cm.activeNetworkInfo
        result = if (info != null && info.isConnected) 4 else 0
    }

    return result == 1 || result == 2 ||result == 3 ||result == 4
}

/**
 * @author Ali Al Fayed
 * @param tag
 * @param value
 * Logcat Info
 */
fun kuInfoLog(tag: String, value: String)  = Log.i("$tag =:", value)

/**
 * @author Ali Al Fayed
 * @param tag
 * @param value
 * Logcat Error
 */
fun kuErrorLog(tag: String, value: String)  = Log.e("$tag =:", value)

/**
 * @author Ali Al Fayed
 * @param tag
 * @param value
 * Logcat Debug
 */
fun kuDebugLog(tag: String, value: String)  = Log.d("$tag =:", value)

/**
 * Ku app version name
 * @author Ali Al Fayed
 * @param Activity
 * @return String
 */
fun Activity.kuAppVersionName(): String {
    var pInfo: PackageInfo? = null
    try {
        pInfo = packageManager.getPackageInfo(packageName, 0)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    assert(pInfo != null)
    return pInfo!!.versionName
}

/**
 * Ku app version name
 * @author Ali Al Fayed
 * @param Activity
 * @return String
 */
fun Fragment.kuAppVersionName(): String {
    return requireActivity().kuAppVersionName()
}







