package com.alpamedev.coupons.common.utils

import com.alpamedev.coupons.R
import com.alpamedev.coupons.common.entities.CouponEntity
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
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
    @Test
    fun validateTextCodeMinLengthTest() {
        val code = "hola"
        assertFalse(validateTextCode(code))
        val code2 = "hola2"
        assertTrue(validateTextCode(code2))
    }
    @Test
    fun validateTextCodeMaxLengthTest() {
        val code = "hola mundo"
        assertTrue(validateTextCode(code))
        val code2 = "hola programador"
        assertFalse(validateTextCode(code2))
    }
    @Test
    fun getMessageErrorNullTest() {
        val codeError = null
        val expectedValue = R.string.error_unknown
        val result = getMessageError(codeError)
        assertEquals("Error al evaluar un null", expectedValue, result)
    }
    @Test
    fun getMessageErrorExistTest() {
        val codeError = Constants.ERROR_EXIST
        val expectedValue = R.string.error_unique_code
        val result = getMessageError(codeError)
        assertEquals("Error al evaluar un cupon existente", expectedValue, result)
    }
    @Test
    fun getMessageErrorLengthTest() {
        val codeError = Constants.ERROR_LENGTH
        val expectedValue = R.string.error_invalid_length
        val result = getMessageError(codeError)
        assertEquals("Error al evaluar la longitud valida del cupon", expectedValue, result)
        assertNotEquals("El recurso no existe", -1, result)
    }
    @Test
    fun checkNotNullCouponTest(){
        val coupon = CouponEntity(code = "Android", description = "Cursos a $9.99 USD")
        assertNotNull("El cupon no puede ser nulo",coupon)
    }
    @Test
    fun checkGroupsSuccessTest(){
        val aNames = arrayOf("Alex", "Bob", "Cathy")
        val bNames = arrayOf("Alex", "Bob", "Cathy")
        assertArrayEquals("Los arreglos deberían coindicir",aNames, bNames)
    }
    @Test
    fun checkNullCouponTest(){
        val coupon = null
        assertNull("El cupon debería ser nulo",coupon)
    }
    @Test
    fun checkGroupsFailTest(){
        val aNames = arrayOf("Alexis", "Bob", "Cathy")
        val bNames = arrayOf("Alex", "Bob", "Cathys")
        assertNotEquals("Los arreglos deberían coindicir", aNames, bNames)
    }
}