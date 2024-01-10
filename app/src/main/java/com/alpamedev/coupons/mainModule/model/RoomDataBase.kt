package com.alpamedev.coupons.mainModule.model

import android.database.sqlite.SQLiteException
import com.alpamedev.coupons.CouponsApp
import com.alpamedev.coupons.common.dataAccess.CouponDao
import com.alpamedev.coupons.common.entities.CouponEntity
import com.alpamedev.coupons.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataBase {
    private val dao: CouponDao by lazy { CouponsApp.db.couponDao() }
    suspend fun getCouponByCode(code: String) = withContext(Dispatchers.IO) { dao.requestCouponByCode(code) }
    suspend fun insertCoupon(coupon: CouponEntity) = withContext(Dispatchers.IO) {
        try {
            dao.insertCoupon(coupon)
        } catch (e: Exception) {
            (e as? SQLiteException)?.let { throw Exception(Constants.ERROR_EXIST) }
            throw Exception(e.message ?: Constants.ERROR_UNKNOWN)
        }
    }
}