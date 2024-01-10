package com.alpamedev.coupons.mainModule.model

import com.alpamedev.coupons.common.entities.CouponEntity
import com.alpamedev.coupons.common.utils.Constants
import com.alpamedev.coupons.common.utils.validateTextCode

class MainRepository {
    private val roomDataBase = RoomDataBase()
    suspend fun getCouponByCode(code: String) = roomDataBase.requestCouponByCode(code)
    suspend fun addCoupon(coupon: CouponEntity) {
        if (validateTextCode(coupon.code)){
            roomDataBase.insertCoupon(coupon)
        } else {
            throw Exception(Constants.ERROR_LENGTH)
        }
    }
}