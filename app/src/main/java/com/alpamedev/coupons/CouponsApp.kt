package com.alpamedev.coupons

import android.app.Application
import com.alpamedev.coupons.common.dataAccess.CouponDatabase

class CouponsApp: Application() {
    companion object {
        lateinit var db: CouponDatabase
    }

    override fun onCreate() {
        super.onCreate()

        db = CouponDatabase.getDatabase(this)
    }
}