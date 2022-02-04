package com.alfayedoficial.kotlinutils

import com.alfayedoficial.kotlinutils.KUConstants.KU_DATA_USER_ACCESS_TOKEN
import com.alfayedoficial.kotlinutils.KUConstants.KU_IS_LOGIN
import com.alfayedoficial.kotlinutils.KUConstants.KU_IS_WIZARD
import com.alfayedoficial.kotlinutils.KUConstants.KU_LOCALE
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
    fun exApiToken(kuPreferences: KUPreferences): String = "Bearer "+kuPreferences.getStringValue(KU_DATA_USER_ACCESS_TOKEN)

    /**
     * @param kuPreferences
     * @return exLocale
     */
    fun exLocale(kuPreferences: KUPreferences): String =kuPreferences.getStringValue(KU_LOCALE, Locale.getDefault().language)

    /**
     * @param kuPreferences
     * @return exIsLogin
     */
    fun exIsLogin(kuPreferences: KUPreferences): Boolean = kuPreferences.getBooleanValue(KU_IS_LOGIN , defaultValue = false)

    /**
     * @param kuPreferences
     * @return exIsWizard
     */
    fun exIsWizard(kuPreferences: KUPreferences): Boolean = kuPreferences.getBooleanValue(KU_IS_WIZARD , defaultValue = false)
}