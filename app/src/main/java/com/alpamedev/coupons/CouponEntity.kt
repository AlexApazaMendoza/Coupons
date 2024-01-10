package com.alpamedev.coupons

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "CouponEntity", indices = [Index(value = ["code"], unique = true)])
data class CouponEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var code: String = "",
    var description: String = "",
    var isActive: Boolean = false
)
