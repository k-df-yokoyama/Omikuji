package jp.wings.nikkeibp.omikuji

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
    fun onOptionsItemSelected() {
    }

    @Test
    fun onTouchEvent() {
    }
}