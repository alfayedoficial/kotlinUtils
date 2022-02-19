package com.alfayedoficial.kotlinutils

import android.util.Patterns
import android.view.View
import java.util.regex.Pattern

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Check network issues and Validation of EditText or TextInputLayout Data
 * Date 4/18/2020 - 4:28 PM updated Date 3/7/2021 - 1:12 PM updated Date 3/2/2022 - 8:00 PM
 */

object KUCheckValidation {

    /**
     * string of Edit Name
     * @return - return Check Boolean
     */
    fun String.kuValidName(): Boolean {
        var valid = true

        // Name should contain at least one number
        var exp = ".*[0-9].*"
        var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        var matcher = pattern.matcher(this)
        if (matcher.matches()) {
            valid = false
        }
        // Name should contain at least one special character
        // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
        exp = ".*[~!@#$%^&*()_=+|/,.\"';:{}<>?].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(this)
        if (matcher.matches()) {
            valid = false
        }
        return valid
    }

    /**
     * String of Email
     * @return - Boolean
     */
    fun String.kuValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }


    /**
     * String of Phone
     * @return - Boolean
     */
    fun String.kuValidPhone(): Boolean {
        return Patterns.PHONE.matcher(this).matches()
    }

    /**
     * String of Address
     * @return - Boolean
     */
    fun String.kuValidAddress(): Boolean {
        var valid = true
        val exp = ".*[~!@#$%^&*()_=+|/.\"';:{}<>?].*"
        val pattern = Pattern.compile(exp)
        val matcher = pattern.matcher(this)
        if (matcher.matches()) {
            valid = false
        }
        return valid
    }

    /**
     * string of Edit Password
     * @return - return Check Boolean
     */
    fun String.kuValidPasswordNumber(): Boolean {
        var valid = true

        // Name should contain at least one number
        val exp = ".*[0-9].*"
        val pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(this)
        if (!matcher.matches()) {
            valid = false
        }
        return valid
    }

    /**
     * string of Edit Password
     * @return - return Check Boolean
     */
    fun String.kuValidPasswordUpperCase(): Boolean? {
        var valid = true

        // Password should contain at least one capital letter
        val exp = ".*[A-Z].*"
        val pattern = Pattern.compile(exp)
        val matcher = pattern.matcher(this)
        if (!matcher.matches()) {
            valid = false
        }
        return valid
    }

    /**
     * string of Edit Password
     * @return - return Check Boolean
     */
    fun String.kuValidPasswordSmallCase(): Boolean {
        var valid = true

        // Password should contain at least one small letter
        val exp = ".*[a-z].*"
        val pattern = Pattern.compile(exp)
        val matcher = pattern.matcher(this)
        if (!matcher.matches()) {
            valid = false
        }
        return valid
    }

    /**
     * string of Edit Password
     * @return - return Check Boolean
     */
    fun String.kuValidPasswordContain(): Boolean {
        var valid = true

        // Name should contain at least one special character
        // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
        val exp = ".*[~!@#$%^&*()_=+|/,.\"';:{}<>?].*"
        val pattern = Pattern.compile(exp)
        val matcher = pattern.matcher(this)
        if (!matcher.matches()) {
            valid = false
        }
        return valid
    }

    /**
     * Disable views
     * view of components
     */
    fun kuDisableViews(vararg views: View?) {
        views.forEach {
            if (it != null) it.isEnabled = false
        }
    }

    /**
     * Enable views
     *
     * @param views view of components
     */
    fun kuEnableViews(vararg views: View?) {
        views.forEach {
            if (it != null) it.isEnabled = true
        }
    }


    fun String.kuExtractLinks(): Map<String, String>? {
        val pattern = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"")
        val links = LinkedHashMap<String, String>()
        val matcher = pattern.matcher(this)
        while (matcher.find()) {
            val count = matcher.groupCount()
            if (count == 2) {
                links[matcher.group(2)] = matcher.group(1)
            }
        }
        return links
    }

    fun String.kuIsIntNumber(): Boolean =  try {
        this.toInt()
        true
    } catch (n: NumberFormatException) {
        false
    } catch (e: Exception) {
        false
    }

    fun String.kuToIntNumber(): Int =  if (this.kuIsIntNumber()){
        this.toInt()
    }else 0


}