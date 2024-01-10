package com.alpamedev.coupons.common.utils

import android.content.Context
import android.view.View
import com.alpamedev.coupons.R

fun validateTextCode(coupon: String): Boolean {
    return (coupon.length in 5..10)
}

fun geMessageError(codeError: String?): Int {
    return when (codeError) {
        Constants.ERROR_EXIST -> R.string.error_unique_code
        Constants.ERROR_LENGTH -> R.string.error_invalid_length
        else -> R.string.error_unknown
    }
}

fun hideKeyboard(context : Context, view: View) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}