package com.alfayedoficial.kotlinutils

import com.alfayedoficial.kotlinutils.KUConstants.DATA_SETTINGS
import com.alfayedoficial.kotlinutils.KUConstants.DATA_USER
import com.alfayedoficial.kotlinutils.KUConstants.IS_NOTIFICATION
import com.alfayedoficial.kotlinutils.KUConstants.KU_DATA_USER_ACCESS_TOKEN
import com.alfayedoficial.kotlinutils.KUConstants.KU_IS_LOGIN
import com.alfayedoficial.kotlinutils.KUConstants.KU_IS_WIZARD
import com.alfayedoficial.kotlinutils.KUConstants.KU_LOCALE
import com.google.gson.Gson
import java.util.*

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : App Extensions to Files
 * Date 1/1/2021 - 4:59 PM
 */
object KUExtensionsApp {

    /**
     * @param kuPreferences
     * @return ApiToken
     */
    fun kuApiToken(kuPreferences: KUPreferences): String = "Bearer "+kuPreferences.getStringValue(KU_DATA_USER_ACCESS_TOKEN)

    /**
     * @param kuPreferences
     * @return exLocale
     */
    fun kuLocale(kuPreferences: KUPreferences): String =kuPreferences.getStringValue(KU_LOCALE, Locale.getDefault().language)

    /**
     * @param kuPreferences
     * @return exIsLogin
     */
    fun kuIsLogin(kuPreferences: KUPreferences): Boolean = kuPreferences.getBooleanValue(KU_IS_LOGIN , defaultValue = false)

    /**
     * @param kuPreferences
     * @return exIsWizard
     */
    fun kuIsWizard(kuPreferences: KUPreferences): Boolean = kuPreferences.getBooleanValue(KU_IS_WIZARD , defaultValue = false)


    /**
     * @param kuPreferences
     * @return settingsConfig
     */
    fun <T>settingsConfig(kuPreferences: KUPreferences ,  classOfT: Class<T>?): T? = Gson().fromJson(kuPreferences.getStringValue(DATA_SETTINGS),classOfT)


    /**
     * @param kuPreferences
     * @return userModel
     */
    fun <T>userModel(kuPreferences: KUPreferences , classOfT : Class<T>?): T? = Gson().fromJson(kuPreferences.getStringValue(DATA_USER), classOfT)

    /**
     * @param kuPreferences
     * @return isIsNotify
     */
    fun isIsNotify(kuPreferences: KUPreferences): Boolean = kuPreferences.getBooleanValue(IS_NOTIFICATION, defaultValue = true)

}
