package com.alpamedev.coupons.common.utils

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CouponUtilsKtTest{
    @Test
    fun validateTextCodeSuccessTest() {
        val code = "WELCOME"
        assertTrue(validateTextCode(code))
    }
    @Test
    fun validateTextCodeEmptyFailTest() {
        val code = " "
        assertFalse(validateTextCode(code))
    }
}