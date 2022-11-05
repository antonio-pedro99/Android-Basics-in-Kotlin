package com.antdev99.amazing_tips

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.matchers.JUnitMatchers.containsString
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AmazingTipTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip_test(){
        onView(withId(R.id.cost_of_service))
            .perform(typeText("50.0"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btn_calculate))
            .perform(click())

        onView(withId(R.id.result_txt))
            .check(matches(withText(containsString("$10.00"))))
    }
}