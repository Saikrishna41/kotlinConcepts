package security

import java.security.KeyStore
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey

class SecurityFileHelper {

    companion object {
        val keyStore = KeyStore.getInstance("JKS").apply { load(null) }

        val secretKey : SecretKey? = keyStore.getEntry("alias", null) as SecretKey?


        fun encrypt(plaintext: String): String {
            val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding").apply {
                init(Cipher.ENCRYPT_MODE, secretKey)

            }
            val excryptedData  = cipher.doFinal()

            return Base64.getEncoder().encode(excryptedData).toString()

        }

        fun decrypt(cipherText: String): String {
            val encrypted =  Base64.getDecoder().decode(cipherText)
            val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding").apply {
                init(Cipher.DECRYPT_MODE, secretKey)
            }
            return String(cipher.doFinal(encrypted))
        }
    }
}

fun main(args : Array<String>)  {

    val securityFileHelper = SecurityFileHelper.encrypt("sai")

    println(securityFileHelper)
}