package com.alpamedev.coupons.common.dataAccess

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alpamedev.coupons.common.entities.CouponEntity

@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDatabase: RoomDatabase() {
    abstract fun couponDao(): CouponDao

    companion object {
        private const val DATABASE_NAME = "coupon.db"

        @Volatile
        private var instance: CouponDatabase? = null
        fun getDatabase(context: Context): CouponDatabase {

            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, CouponDatabase::class.java, DATABASE_NAME).build().also { instance = it }
            }
        }
    }
}