package com.alpamedev.coupons.common.adapters

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.alpamedev.coupons.R

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone:Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("couponTitle")
fun setCouponTitle(view: TextView, isActive:Boolean) {
    if (isActive) {
        view.text = view.context.getString(R.string.main_text_title)
        view.setTextColor(Color.GREEN)
    } else {
        view.text = view.context.getString(R.string.main_text_create_coupon_title)
        view.setTextColor(Color.RED)
    }
}