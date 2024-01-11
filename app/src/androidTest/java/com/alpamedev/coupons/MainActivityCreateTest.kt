package com.alpamedev.coupons

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.alpamedev.coupons.mainModule.view.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
}