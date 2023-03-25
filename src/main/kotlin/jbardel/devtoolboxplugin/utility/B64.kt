package jbardel.devtoolboxplugin.utility

import java.util.Base64

fun decodeB64(ch: String): String {
    return Base64.getDecoder().decode(ch).decodeToString()
}

fun encodeB64(ch: String): String {
    return Base64.getEncoder().encode(ch.toByteArray()).decodeToString()
}