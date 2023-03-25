package jbardel.devtoolboxplugin.utility

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class B64KtTest {

    @Test
    fun decodeB64() {
        val decode = decodeB64("VGVzdA==")
        assertEquals("Test", decode)
    }

    @Test
    fun encodeB64() {
        val encode = encodeB64("Test")
        assertEquals("VGVzdA==", encode)
    }
}