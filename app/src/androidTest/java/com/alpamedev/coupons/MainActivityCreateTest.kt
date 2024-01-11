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
import org.hamcrest.core.IsNot.not
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
        etCoupon.perform(replaceText("welcome02"))    //escribe

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

        etCoupon.perform(replaceText("welcome01"))    //escribe

        //click en crear
        btnCreate.perform(click())

        //validar al snackbar
        val snackbar = onView(withId(com.google.android.material.R.id.snackbar_text))
        snackbar.check(matches(withText(R.string.main_save_success)))
    }

    /*
    * Corrobora que el botón "crear" no existe y no es visible
    * Test: muestro etCoupon inicia vacio, luego haz click sobre el, añade el texto "welcome01"
    * y ahora desde btnConsult, haz click sobre el.
    * Verifica que el boton crear no es visible
    * */
    @Test
    fun consultCouponExistTest(){
        createCouponTest()
        val tieCoupon = onView(withId(R.id.tieCoupon))
        /**/
        tieCoupon.perform(replaceText(""))
        /**/
        tieCoupon.check(matches(withText("")))
        tieCoupon.perform(click())
        tieCoupon.perform(replaceText("welcome01"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(not(isDisplayed())))
    }
}