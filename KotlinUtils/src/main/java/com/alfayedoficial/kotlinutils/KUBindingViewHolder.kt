package com.alfayedoficial.kotlinutils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Class to create Binding View
 * Date 7/26/2021 - 9:35 AM
 */

/**
 * @author Ali Al Fayed
 * @param parent of ViewGroup Row
 * @param resId of layout Id
 * @return ViewDataBinding
 * you can case ViewDataBinding to child for get views in layout
 */
fun kuGetBindingRow(parent: ViewGroup, @LayoutRes resId: Int): ViewDataBinding {
    return DataBindingUtil.inflate(LayoutInflater.from(parent.context), resId, parent, false)
}

/**
 * @author Ali Al Fayed
 * @param layoutInflater
 * @param resId
 * @return ViewDataBinding
 * you can case ViewDataBinding to child for get views in layout
 */
fun kuGetBindingDialog(layoutInflater: LayoutInflater, @LayoutRes resId: Int): ViewDataBinding {

    return DataBindingUtil.inflate(layoutInflater, resId, null, false)
}


