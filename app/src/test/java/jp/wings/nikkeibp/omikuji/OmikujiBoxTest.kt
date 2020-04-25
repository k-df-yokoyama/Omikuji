package jp.wings.nikkeibp.omikuji

import org.junit.Test
import org.junit.Assert.*

class OmikujiBoxTest {
    @Test
    fun getNumber_isValidValueSetted() {
        val omikujiBox = OmikujiBox()
        assertTrue(omikujiBox.number >= 0)
        assertTrue(omikujiBox.number < 20)
    }
}