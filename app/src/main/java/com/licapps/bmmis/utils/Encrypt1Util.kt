package com.licapps.bmmis.utils
/*
import android.util.Base64
import timber.log.Timber
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.security.*
import java.security.spec.InvalidKeySpecException
import java.security.spec.KeySpec
import javax.crypto.*
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec


class Encrypt1Util {
    companion object {

        const val encryption_key = "Qwm23c*3df._edjDSA"
        const val encryption_salt = "!sdjk4_*tRLo2"
        val Iv_value = byteArrayOf(1, 2, 1, 9, 8, 5, 4, 3, 2, 5, 6, 4, 3, 8, 1, 0)
        private val ivSpec = IvParameterSpec(Iv_value)
        private val mBuilder = Builder(
            Iv_value,
            128,
            Base64.DEFAULT,
            1,
            encryption_salt,
            encryption_key,
            "AES/CBC/PKCS5Padding",
            "AES",
            "UTF8",
            "PBKDF2WithHmacSHA1",
            "SHA1",
            "SHA1PRNG",
            SecureRandom.getInstance("SHA1PRNG"),
            IvParameterSpec(Iv_value)
        )


        fun encrypt(data: String?): String? {
            Timber.d("Encrypt1111")
            if (data == null) return null
            val secretKey = getSecretKey(hashTheKey(mBuilder.key))
            val dataBytes = data.toByteArray(mBuilder.charsetName)
            val cipher = Cipher.getInstance(mBuilder.algorithm)
            cipher.init(
                Cipher.ENCRYPT_MODE,
                secretKey,
                mBuilder.ivParameterSpec,
                mBuilder.secureRandom
            )
            return Base64.encodeToString(cipher.doFinal(dataBytes), mBuilder.base64Mode)
        }




        fun decrypt(data: String?): String? {
            if (data == null) return null
            val dataBytes: ByteArray = Base64.decode(data, mBuilder.base64Mode)
            val secretKey = getSecretKey(hashTheKey(mBuilder.key))
            val cipher = Cipher.getInstance(mBuilder.algorithm)
            cipher.init(
                Cipher.DECRYPT_MODE,
                secretKey,
                mBuilder.ivParameterSpec,
                mBuilder.secureRandom
            )
            val dataBytesDecrypted = cipher.doFinal(dataBytes)
            return String(dataBytesDecrypted)
        }


        @Throws(
            NoSuchAlgorithmException::class,
            UnsupportedEncodingException::class,
            InvalidKeySpecException::class
        )
        private fun getSecretKey(key: CharArray): SecretKey {
            val factory = SecretKeyFactory.getInstance(mBuilder.secretKeyType)
            val spec: KeySpec = PBEKeySpec(
                key,
                mBuilder.salt.toByteArray(mBuilder.charsetName),
                mBuilder.iterationCount,
                mBuilder.keyLength
            )
            val tmp = factory.generateSecret(spec)
            return SecretKeySpec(tmp.encoded, mBuilder.keyAlgorithm)
        }

        @Throws(UnsupportedEncodingException::class, NoSuchAlgorithmException::class)
        private fun hashTheKey(key: String?): CharArray {
            val messageDigest = MessageDigest.getInstance(mBuilder.digestAlgorithm)
            messageDigest.update(key!!.toByteArray(mBuilder.charsetName))
            return Base64.encodeToString(messageDigest.digest(), Base64.NO_PADDING).toCharArray()
        }


    }


   data class Builder
        (
       var iv: ByteArray,
       var keyLength: Int,
       var base64Mode: Int,
       var iterationCount: Int,
       var salt: String,
       var key: String,
       var algorithm: String,
       var keyAlgorithm: String,
       var charsetName: String,
       var secretKeyType: String,
       var digestAlgorithm: String,
       var secureRandomAlgorithm: String,
       var secureRandom: SecureRandom,
       var ivParameterSpec: IvParameterSpec
        )

}*/
