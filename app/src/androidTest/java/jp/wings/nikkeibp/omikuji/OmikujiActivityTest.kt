package jp.wings.nikkeibp.omikuji

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.After
import org.junit.Before
import org.junit.Test

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import androidx.test.rule.*

@RunWith(AndroidJUnit4::class)
class OmikujiActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(OmikujiActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testActionBarOverflow() {
        // Open the options menu OR open the overflow menu, depending on whether
        // the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(
            ApplicationProvider.getApplicationContext<Context>())

        // Click the item.
        onView(withText("設定"))
            .perform(click())
    }

    @Test
    fun onButtonClick() {
        /*
        activityRule.launchActivity(Intent())
        onView(withId(R.id.button))
            .perform(click())
         */
    }

    @Test
    fun onOptionsItemSelected() {
    }

    @Test
    fun onTouchEvent() {
    }
}