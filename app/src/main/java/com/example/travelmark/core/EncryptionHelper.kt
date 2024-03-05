package com.example.travelmark.core

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object EncryptionHelper {

    private const val KEY = "4gz9#Y5b/$2Ks@P!8" // ключ для шифрования

    fun encryptPassword(password: String): String {
        val key: SecretKey = SecretKeySpec(KEY.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedBytes = cipher.doFinal(password.toByteArray())
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
    }

    fun decryptPassword(encryptedPassword: String): String {
        val key: SecretKey = SecretKeySpec(KEY.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, key)
        val decryptedBytes = cipher.doFinal(Base64.decode(encryptedPassword, Base64.DEFAULT))
        return String(decryptedBytes)
    }
}
