package com.alfayedoficial.kotlinutils

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.*
import android.os.Build
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

/**
 * @author Ali Al Fayed
 * @return widthPixels
 */
fun Context.kuGetDisplayWidth(): Int = resources.displayMetrics.widthPixels

/**
 * @author Ali Al Fayed
 * @return heightPixels
 */
fun Context.kuGetDisplayHeight(): Int = resources.displayMetrics.heightPixels

/**
 * @author Ali Al Fayed
 * @param dp
 * @return Px
 */
fun Context.kuConvertDpToPx(dp: Int): Int = (dp * resources.displayMetrics.density).toInt()

/**
 * @author Ali Al Fayed
 * @param px
 * @return Px
 */
fun Context.kuConvertPxToDp(px: Int): Int = (resources.displayMetrics.density / px).toInt()

/**
 * @author Ali Al Fayed
 * @param View
 * @return resources
 */
val View.kuRes: Resources get() = resources

/**
 * @author Ali Al Fayed
 * @param View
 * @return context
 */
val View.kuCtx: Context get() = context
/**
 * @param text text of SnackBar
 * @param bgColor background color of snack bar
 * @param tvColor  text color of snack bar
 * @param duration Snack_bar.LENGTH but default is Snack_bar.LENGTH_LONG
 * * call function from any View
 */
fun View.kuSnackBarError(text: String ,@ColorInt bgColor : Int  ,@ColorInt tvColor : Int = Color.WHITE , duration: Int = Snackbar.LENGTH_LONG) {
    val snackBar = Snackbar.make(this, text, duration)
    snackBar.apply {
        val sbView = snackBar.view
        sbView.setBackgroundColor(bgColor)
        setTextColor(tvColor)
    }.show()
}

/**
 * @author Ali Al Fayed
 * @param View
 * @param text text of SnackBar
 * @param duration Snack_bar.LENGTH but default is Snack_bar.LENGTH_LONG
 * @return Snackbar
 * * call function from any View
 * * must be call show() after init function
 */
fun View.kuSnackBar(text: String, duration: Int = Snackbar.LENGTH_LONG): Snackbar {
    return Snackbar.make(this, text,duration).apply {
        val mTextView = view.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
        mTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * @author Ali Al Fayed
 * @param View
 * @see :hide soft Keyboard
 * <p> call function from any Activity
 */
fun View.kuHideSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * @param View
 * @see :show soft Keyboard
 * <p> call function from any Activity
 * @author Ali Al Fayed
 */
fun View.exShowSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

/**
 * @author Ali Al Fayed
 * @param View
 * @param newColor color Resource
 * @param duration time delay
 * @see : delay background change
 */
fun View.kuChangeBackgroundColor(@ColorInt newColor: Int, duration: Int = 300) {
    val oldBackground = background
    val color = ColorDrawable(newColor)
    val ld = LayerDrawable(arrayOf<Drawable>(color))
    if (oldBackground == null) background = ld
    else {
        val td = TransitionDrawable(arrayOf(oldBackground, ld))
        background = td
        td.startTransition(duration)
    }
}

/**
 * @author Ali Al Fayed
 * @param View
 * @see  :Screenshot of the view and returns it as a Bitmap
 */
fun View.kuScreenshot(): Bitmap {
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bmp)
    draw(canvas)
    canvas.save()
    return bmp
}

/**
 * @author Ali Al Fayed
 * @param View
 * @see  :FadeIn view
 */
fun View.kuFadeIn(duration: Int = 400) {
    clearAnimation()
    val alphaAnimation = AlphaAnimation(this.alpha, 1.0f)
    alphaAnimation.duration = duration.toLong()
    startAnimation(alphaAnimation)
}

/**
 * @author Ali Al Fayed
 * @param View
 * @see  :FadeOut view
 */
fun View.kuFadeOut(duration: Int = 400) {
    clearAnimation()
    val alphaAnimation = AlphaAnimation(this.alpha, 0.0f)
    alphaAnimation.duration = duration.toLong()
    startAnimation(alphaAnimation)
}

/**
 * @author Ali Al Fayed
 * @param View
 * @see  :set view a VISIBLE
 */
fun View.kuShow() {
    visibility = View.VISIBLE
}
/**
 * @author Ali Al Fayed
 * @param View
 * @see  :set view a GONE
 */
fun View.kuHide() {
    visibility = View.GONE
}
/**
 * @author Ali Al Fayed
 * @param View
 * @see  :set view a INVISIBLE
 */
fun View.kuInShow() {
    visibility = View.INVISIBLE
}
/**
 * @author Ali Al Fayed
 * @param View
 * @see  :set view if condition == True -> a VISIBLE  else -> a GONE
 */
fun View.kuShowIf(condition: Boolean) = if (condition) kuShow() else kuHide()

/**
 * @author Ali Al Fayed
 * @param View
 * @see  : loop to view and set a VISIBLE
 */
fun showViews(vararg views: View?) {
    for (v in views) v?.kuShow()
}
/**
 * @author Ali Al Fayed
 * @param View
 * @see  : loop to view and set a GONE
 */
fun hideViews(vararg views: View?) {
    for (v in views) v?.kuHide()
}

/**
 * @author Ali Al Fayed
 * @param View
 * @see  : Check if view is VISIBLE
 * @return Boolean
 */
fun View.kuIsVisible() = visibility == View.VISIBLE
/**
 * @author Ali Al Fayed
 * @param View
 * @see  : Check if view is GONE
 * @return Boolean
 */
fun View.kuIsGone() = visibility == View.GONE
/**
 * @author Ali Al Fayed
 * @param View
 * @see  : Check if view is INVISIBLE
 * @return Boolean
 */
fun View.kuIsInvisible() = visibility == View.INVISIBLE

/**
 * @author Ali Al Fayed
 * @param View
 * @param color resource
 * @see  : Change BackgroundTint of view
 */
fun View.kuChangeBackgroundTint(color: Int) {
    (background as GradientDrawable).setColor(color)
    (background as GradientDrawable).setStroke(0, 0)
    background.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY)
}
/**
 * @author Ali Al Fayed
 * @param View
 * @param backgroundColor resource
 * @param strokeColor resource
 * @param alpha alpha of color but default =  1.0f
 * @param strokeWidth stroke of view but default =  3
 * @see  : Set Stroked Background to view
 */
fun View.kuSetStrokedBackground(backgroundColor: Int, strokeColor: Int = 0, alpha: Float = 1.0f, strokeWidth: Int = 3) {
    val drawable = background as GradientDrawable
    drawable.setStroke(strokeWidth, strokeColor)
    drawable.setColor(kuAdjustAlpha(backgroundColor, alpha))
}

/**
 * @author Ali Al Fayed
 * @param RecyclerView
 * @param orientation Layout orientation. Should be {HORIZONTAL} or {VERTICAL}.
 * @param rvAdapter Adapter of RecyclerView
 * @param aReverseLayout When set to true, layouts from end to start
 * @param hasFixedSize true if adapter changes cannot affect the size of the RecyclerView.
 * @see  : init LinearLayout and Adapter
 */
fun RecyclerView.kuInitLinearLayoutManager(
    orientation: Int,
    rvAdapter: RecyclerView.Adapter<*>,
    aReverseLayout: Boolean = false ,
    hasFixedSize : Boolean = true
) {
    this.apply {
        layoutManager = LinearLayoutManager(context, orientation, aReverseLayout)
        setHasFixedSize(hasFixedSize)
        adapter = rvAdapter
    }
}

/**
 * @author Ali Al Fayed
 * @param RecyclerView
 * @return MutableMap<String, Int> of dx and dy
 * @see  : scrollListen to RecyclerView
 */
fun RecyclerView.kuScrollListener() : MutableMap<String, Int>{
    val location : HashMap<String, Int> = HashMap()
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            location["dx"] = dx
            location["dy"] = dy
        }
    })
    return location
}

/**
 * @author Ali Al Fayed
 * @param RecyclerView
 * @param aReverseLayout When set to true, layouts from end to start
 * @see  : init LayoutManager of RecyclerView to VERTICAL LAYOUT MANAGER
 */
fun RecyclerView.kuSetVerticalLayout(aReverseLayout: Boolean = false) {
    layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, aReverseLayout)
}

/**
 * @author Ali Al Fayed
 * @param RecyclerView
 * @param aReverseLayout When set to true, layouts from end to start
 * @see  : init LayoutManager of RecyclerView to VERTICAL LAYOUT MANAGER
 */
fun RecyclerView.kuSetHorizontalLayout(aReverseLayout: Boolean = false) {
    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, aReverseLayout)
}

/**
 * @author Ali Al Fayed
 * @param color color Res
 * @param factor float
 * @return Color.argb() -> INT
 */
fun kuAdjustAlpha(@ColorRes color: Int, factor: Float): Int {
    val alpha = (Color.alpha(color) * factor).roundToInt()
    val red = Color.red(color)
    val green = Color.green(color)
    val blue = Color.blue(color)
    return Color.argb(alpha, red, green, blue)
}

/**
 * @author Ali Al Fayed
 * @param MaterialButton
 * @param iconSelected Drawable Res
 * @param colorBg color Res
 * @param colorTv color Res
 * @see  : set Custom view of MaterialButton
 */
fun MaterialButton.kuCustomMaterialButton(@DrawableRes iconSelected : Int, @ColorRes colorTv : Int, @ColorRes colorBg : Int  ){
    setIconResource(iconSelected)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
        setTextColor(kuRes.getColor(colorTv , context.theme))
    }else{
        setTextColor(kuRes.getColor(colorTv ))
    }
    kuChangeBackgroundTint(colorBg)
    setIconTintResource(colorTv)
}

/**
 * @author Ali Al Fayed
 * @param MaterialButton
 * @param colorBg color Res
 * @see  : set backgroundTint to MaterialButton
 */
fun MaterialButton.kuChangeBackgroundTint(@ColorRes colorBg :Int){
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
        setBackgroundColor(kuRes.getColor(colorBg , context.theme))
    }else{
        setBackgroundColor(kuRes.getColor(colorBg ))
    }
}
/**
 * @author Ali Al Fayed
 * @param EditText
 * @param autofillHint string value like View.AUTOFILL_HINT_PASSWORD
 * @see  : set AutofillHint to EditText
 */
fun EditText.kuSetAutofillHint(autofillHint: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        setAutofillHints(autofillHint)
    }
}
/**
 * @author Ali Al Fayed
 * @param drawable  drawable res
 * @see  : set setDrawable to EditText
 */
fun EditText.kuSetDrawable(@DrawableRes drawable : Int) {
    setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
}
/**
 * @author Ali Al Fayed
 * @param EditText
 * @param input string value like InputType.TYPE_TEXT_VARIATION_PERSON_NAME
 * @see  : set setInputTypeMethod to EditText
 */
fun EditText.kuSetInputTypeMethod(input : Int) {
    inputType = input
}
/**
 * @author Ali Al Fayed
 * @param EditText
 * @see  : remove error when text Changed Listen
 */
fun EditText.kuRemoveErrorListener(){
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            error = null
        }

        override fun afterTextChanged(p0: Editable?) {}

    })
}

/**
 * @author Ali Al Fayed
 * @param TextView
 * @param color color res
 * @see  : change TextView Color
 */
fun TextView.kuSetColor(@ColorRes color : Int){
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
        setTextColor(context.resources.getColor(color , context.theme))
    }else{
        setTextColor(context.resources.getColor(color))
    }
}

/**
 * @author Ali Al Fayed
 * @param TextView
 * @param links multi links has 2 value String and action
 * @param soldColor color res of value
 * @param fontRes font Res of value
 * @see  : make string a clickable link
 */
fun TextView.kuMakeLinks( vararg links: Pair<String, View.OnClickListener>,@ColorRes  soldColor : Int  ,@FontRes fontRes : Int ) {
    val spannableString = SpannableString(text)
    for (link in links) {
        val clickableSpan = object : ClickableSpan() {

            override fun updateDrawState(textPaint: TextPaint) {
                // use this to change the link color
                textPaint.color = ContextCompat.getColor(context, soldColor)
                // toggle below value to enable/disable
                // the underline shown below the clickable text
                textPaint.typeface =  ResourcesCompat.getFont(context, fontRes)
            }

            override fun onClick(view: View) {
                Selection.setSelection((view as TextView).text as Spannable, 0)
                view.invalidate()
                link.second.onClick(view)
            }
        }
        val startIndexOfLink = text.toString().indexOf(link.first)
        spannableString.setSpan(
            clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    movementMethod = LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
    setText(spannableString, TextView.BufferType.SPANNABLE)
}



