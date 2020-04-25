package jp.wings.nikkeibp.omikuji

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.preference.PreferenceManager
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.runner.RunWith

import org.junit.Assert.*
import androidx.test.rule.*
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import androidx.test.uiautomator.UiDevice
import org.junit.*


@RunWith(AndroidJUnit4::class)
class OmikujiActivityTest {
    private lateinit var device: UiDevice

    @get:Rule
    val activityRule = ActivityTestRule(OmikujiActivity::class.java)

    val context = ApplicationProvider.getApplicationContext<Context>()
    //val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testActionBarOverflow() {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val valueBefore = pref.getBoolean("button", false)

        // Open the options menu OR open the overflow menu, depending on whether
        // the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(
            ApplicationProvider.getApplicationContext<Context>())

        // Click the item.
        onView(withText("設定"))
        //onView(withText("おみくじアプリについて"))
            .perform(click())
        /*
        // 以下のコードは使えない（テストが失敗する）
        onView(withId(R.id.item1))
            .perform(click())
         */

        onView(withText("ボタン表示のあり／なしを切り替えます"))
            .perform(click())
        /*
        // 以下のコードは使えない（テストが失敗する）
        onView(withId(R.id.button))
            .perform(click())
         */

        // 戻るボタンをクリックする
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressBack()

        //onView(isRoot()).perform(pressBack())

        /*
        // Then "press" the back button (in the ui thread of the app under test)
        activityRule.runOnUiThread(Runnable {
            activityRule.getActivity().onBackPressed()
        })
         */

        val valueAfter = pref.getBoolean("button", false)
        assertNotEquals(valueAfter, valueBefore)
        println("valueBefore = " + valueBefore)
        println("valueAfter = " + valueAfter)
        //assertThat(valueAfter, is(true))

        // TODO: [戻る]ボタンをクリックしたときに「うらなうボタン表示／非表示」の設定値に応じて[うらなう]ボタンが表示されるようにしたい。
        if (valueBefore) {
            onView(withText("うらなう"))
                //onView(withId(R.id.button))
                .perform(click())
        }
    }

    @Ignore
    fun onButtonClick() {
        /*
        activityRule.launchActivity(Intent())
        onView(withId(R.id.button))
            .perform(click())
         */
    }

    @Ignore
    fun onOptionsItemSelected() {
    }

    @Ignore
    fun onTouchEvent() {
    }
}

