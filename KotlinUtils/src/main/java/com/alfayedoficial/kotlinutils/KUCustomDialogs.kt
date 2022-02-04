package com.alfayedoficial.kotlinutils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.google.android.material.bottomsheet.BottomSheetDialog


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Custom Dialogs
 * Date 9/3/2020 - 12:37 PM
 */
object KUCustomDialogs {

    /**
     * @param layout id of layout dialog
     * @param context of app
     * @return Dialog
     * @author Ali Al Fayed
     */
    fun kuDialogInflateByLayout(layout: Int , context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(layout)
        if (dialog.window != null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
                dialog.window!!.setElevation(20.0f)
            }
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.CENTER)
        }
        return dialog
    }

    /**
     * @param layout id of layout sheet dialog
     * @param context of app
     * @return Dialog
     * @author Ali Al Fayed
     */
    fun kuSheetDialogInflateByLayout(layout: Int ,context: Context): Dialog {
        val dialog = BottomSheetDialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(layout)
        if (dialog.window != null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
                dialog.window!!.setElevation(20.0f)
            }
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.CENTER)
        }
        return dialog
    }

    /**
     * @param viewBinding  viewBinding of layout Dialog
     * @param context of app
     * @return Dialog
     * @author Ali Al Fayed
     */
    fun kuDialogInflateByBinding(viewBinding: View, context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(viewBinding)
        if (dialog.window != null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
                dialog.window!!.setElevation(20.0f)
            }
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.CENTER)
        }
        return dialog
    }

    /**
     * @param viewBinding  viewBinding of layout sheet dialog
     * @param context of app
     * @return Dialog
     * @author Ali Al Fayed
     */
    fun kuSheetDialogInflateByBinding(viewBinding: View, context: Context): Dialog {
        val dialog = BottomSheetDialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(viewBinding)
        if (dialog.window != null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
                dialog.window!!.setElevation(20.0f)
            }
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.CENTER)
        }
        return dialog
    }


}