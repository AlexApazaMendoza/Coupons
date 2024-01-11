package com.alpamedev.coupons

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.alpamedev.coupons.mainModule.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Boolean.FALSE

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest() {
        val etCoupon = onView(withId(R.id.tieCoupon))
        etCoupon.check(matches(withText("")))   //verifica que(view)(coincida(con el texto("")))

        etCoupon.perform(click())  //hace click
        etCoupon.perform(replaceText("welcome01"))    //escribe

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())    //hace click

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(isDisplayed()))    //verifica que(btn)(sea visible)

        //verifica que descripcion sea vacio
        val etDescription = onView(withId(R.id.tieDescription))
        etDescription.check(matches(withText("")))

        //ingresa alguna descripcion
        etDescription.perform(click())
        etDescription.perform(typeText("10% discount"))

        //click en crear
        btnCreate.perform(click())
    }
}