package com.alpamedev.coupons

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CouponDao {
    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun requestCouponByCode(code: String): CouponEntity?
    @Insert
    suspend fun insertCoupon(coupon: CouponEntity): Long
}