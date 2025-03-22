package com.licapps.bmmis.utils

import android.util.Base64
import com.licapps.bmmis.constants.Constants
import timber.log.Timber
import java.nio.charset.Charset
import java.security.*
import java.security.spec.InvalidKeySpecException
import java.security.spec.KeySpec
import javax.crypto.*
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

//import java.security.SecureRandom;
class EncryptUtil {

    companion object {
        private const val pswdIterations = 1
        private const val keySize = 128
        private const val cypherInstance = "AES/CBC/PKCS5Padding"
        private const val secretKeyInstance = "PBKDF2WithHmacSHA1"
        private const val plainText = "Qwm23c*3df._edjDSA"
        private const val AESSalt = "@34dt*"
        private  val initializationVector = byteArrayOf(1, 2, 1, 9, 8, 5, 4, 3, 2, 5, 6, 4, 3, 8, 1, 0)
        private const val digestAlgorithm = "SHA1"
        private const val secureRandomAlgorithm = "SHA1PRNG"
        fun get_SHA_512_SecurePassword(passwordToHash: String): String {
            var generatedPassword = ""
            var salt = getSalt()
            try {
                val md = MessageDigest.getInstance("SHA-512")
                println("Saltbytes:" + getSalt().toByteArray())
                md.update(salt.toByteArray())
                println("Salt:$salt")
                generatedPassword =   md.digest(passwordToHash.toByteArray())
                .map { Integer.toHexString(0xFF and it.toInt()) }
                    .map { if (it.length < 2) "0$it" else it }
                    .fold("", { acc, d -> acc + d })

            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            return generatedPassword


         /*   // Convert byte array into signum representation
            val no = BigInteger(1, messageDigest)

            // Convert message digest into hex value
            var hashtext: String = no.toString(16)

            // Add preceding 0s to make it 32 bit
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }

            // return the HashText
            return hashtext*/
        }

        //Add salt
        fun getSalt(): String {
            return Constants.SALT

        }

      /*  *//**
         * @return an default builder with the follow defaults:
         * the default char set is UTF-8
         * the default base mode is Base64
         * the Secret Key Type is the PBKDF2WithHmacSHA1
         * the default salt is "some_salt" but can be anything
         * the default length of key is 128
         * the default iteration count is 65536
         * the default algorithm is AES in CBC mode and PKCS 5 Padding
         * the default secure random algorithm is SHA1PRNG
         * the default message digest algorithm SHA1
         *//*
        fun getDefaultBuilder(key: String?, salt: String?, iv: ByteArray?): Builder? {
            return Builder()
                .setIv(iv)
                .setKey(key)
                .setSalt(salt)
                .setKeyLength(128)
                .setKeyAlgorithm("AES")
                .setCharsetName("UTF8")
                .setIterationCount(1)
                .setDigestAlgorithm("SHA1")
                .setBase64Mode(Base64.DEFAULT)
                .setAlgorithm("AES/CBC/PKCS5Padding")
                .setSecureRandomAlgorithm("SHA1PRNG")
                .setSecretKeyType("PBKDF2WithHmacSHA1")
        }


        fun encrypt1(data:String):String{
            val plaintext: ByteArray = ...
            val keygen = KeyGenerator.getInstance("AES")
            keygen.init(256)
            val key: SecretKey = keygen.generateKey()
            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.ENCRYPT_MODE, key)
            val ciphertext: ByteArray = cipher.doFinal(plaintext)
            val iv: ByteArray = cipher.iv


            if (data != null) {
                val secretKey = getSecretKey(hashTheKey(mBuilder.getKey()))
                val dataBytes = data.toByteArray(charset(mBuilder.getCharsetName()))
                val cipher = Cipher.getInstance(mBuilder.getAlgorithm())
                cipher.init(
                    Cipher.ENCRYPT_MODE,
                    secretKey,
                    mBuilder.getIvParameterSpec(),
                    mBuilder.getSecureRandom()
                )
                return Base64.encodeToString(cipher.doFinal(dataBytes), mBuilder.getBase64Mode())
            }
            else
                return null

        }
*/
        @Throws(Exception::class)
        fun encrypt(textToEncrypt: String): String? {
            Timber.d("Encrypt")
            val skeySpec = SecretKeySpec(getRaw(hashTheKey(plainText), AESSalt), "AES")
            val cipher = Cipher.getInstance(cypherInstance)
            cipher.init(
                Cipher.ENCRYPT_MODE,
                skeySpec,
                IvParameterSpec(initializationVector),
                SecureRandom.getInstance(secureRandomAlgorithm)
            )
            val encrypted = cipher.doFinal(textToEncrypt.toByteArray())
            return Base64.encodeToString(encrypted, Base64.DEFAULT)
        }

        @Throws(Exception::class)
        fun decrypt(textToDecrypt: String?): String? {
            val encryted_bytes = Base64.decode(textToDecrypt, Base64.DEFAULT)
            val skeySpec = SecretKeySpec(getRaw(hashTheKey(plainText), AESSalt), "AES")
            val cipher = Cipher.getInstance(cypherInstance)
            cipher.init(
                Cipher.DECRYPT_MODE,
                skeySpec,
                IvParameterSpec(initializationVector),
                SecureRandom.getInstance(secureRandomAlgorithm)
            )
            val decrypted = cipher.doFinal(encryted_bytes)
            return String(decrypted, Charset.defaultCharset())
        }

        private fun getRaw(plainText: CharArray, salt: String): ByteArray? {
            try {
                val factory = SecretKeyFactory.getInstance(secretKeyInstance)
                val spec: KeySpec =
                    PBEKeySpec(plainText, salt.toByteArray(), pswdIterations, keySize)
                return factory.generateSecret(spec).encoded
            } catch (e: InvalidKeySpecException) {
                e.printStackTrace()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            return ByteArray(0)
        }
        private fun hashTheKey(key: String?): CharArray {
            val messageDigest = MessageDigest.getInstance(digestAlgorithm)
            messageDigest.update(key!!.toByteArray(Charset.defaultCharset()))
            return Base64.encodeToString(messageDigest.digest(), Base64.NO_PADDING).toCharArray()
        }



/*
        fun encrypt(data: String?): String? {
            if (data == null) return null
            val secretKey = getSecretKey(hashTheKey(mBuilder.getKey()))
            val dataBytes = data.toByteArray(charset(mBuilder.getCharsetName()))
            val cipher = Cipher.getInstance(mBuilder.getAlgorithm())
            cipher.init(
                Cipher.ENCRYPT_MODE,
                secretKey,
                mBuilder.getIvParameterSpec(),
                mBuilder.getSecureRandom()
            )
            return Base64.encodeToString(cipher.doFinal(dataBytes), mBuilder.getBase64Mode())
        }

        /**
         * This is a sugar method that calls encrypt method and catch the exceptions returning
         * `null` when it occurs and logging the error
         *
         * @param data the String to be encrypted
         *
         * @return the encrypted String or `null` if you send the data as `null`
         */
        fun encryptOrNull(data: String?): String? {
            return try {
                encrypt(data)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

        /**
         * This is a sugar method that calls encrypt method in background, it is a good idea to use this
         * one instead the default method because encryption can take several time and with this method
         * the process occurs in a AsyncTask, other advantage is the Callback with separated methods,
         * one for success and other for the exception
         *
         * @param data     the String to be encrypted
         * @param callback the Callback to handle the results
         */
        fun encryptAsync(data: String?, callback: Callback?) {
            if (callback == null) return
            Thread {
                try {
                    val encrypt = encrypt(data)
                    if (encrypt == null) {
                        callback.onError(Exception("Encrypt return null, it normally occurs when you send a null data"))
                    }
                    callback.onSuccess(encrypt)
                } catch (e: Exception) {
                    callback.onError(e)
                }
            }.start()
        }

        /**
         * Decrypt a String
         *
         * @param data the String to be decrypted
         *
         * @return the decrypted String or `null` if you send the data as `null`
         *
         * @throws UnsupportedEncodingException       if the Builder charset name is not supported or if
         * the Builder charset name is not supported
         * @throws NoSuchAlgorithmException           if the Builder digest algorithm is not available
         * or if this has no installed provider that can
         * provide the requested by the Builder secret key
         * type or it is `null`, empty or in an invalid
         * format
         * @throws NoSuchPaddingException             if no installed provider can provide the padding
         * scheme in the Builder digest algorithm
         * @throws InvalidAlgorithmParameterException if the specified parameters are inappropriate for
         * the cipher
         * @throws InvalidKeyException                if the specified key can not be used to initialize
         * the cipher instance
         * @throws InvalidKeySpecException            if the specified key specification cannot be used
         * to generate a secret key
         * @throws BadPaddingException                if the padding of the data does not match the
         * padding scheme
         * @throws IllegalBlockSizeException          if the size of the resulting bytes is not a
         * multiple of the cipher block size
         * @throws NullPointerException               if the Builder digest algorithm is `null` or
         * if the specified Builder secret key type is
         * `null`
         * @throws IllegalStateException              if the cipher instance is not initialized for
         * encryption or decryption
         */
        @Throws(
            UnsupportedEncodingException::class,
            NoSuchAlgorithmException::class,
            InvalidKeySpecException::class,
            NoSuchPaddingException::class,
            InvalidAlgorithmParameterException::class,
            InvalidKeyException::class,
            BadPaddingException::class,
            IllegalBlockSizeException::class
        )
        fun decrypt(data: String?): String? {
            if (data == null) return null
            val dataBytes: ByteArray = Base64.decode(data, mBuilder.getBase64Mode())
            val secretKey = getSecretKey(hashTheKey(mBuilder.getKey()))
            val cipher = Cipher.getInstance(mBuilder.getAlgorithm())
            cipher.init(
                Cipher.DECRYPT_MODE,
                secretKey,
                mBuilder.getIvParameterSpec(),
                mBuilder.getSecureRandom()
            )
            val dataBytesDecrypted = cipher.doFinal(dataBytes)
            return String(dataBytesDecrypted)
        }

        /**
         * This is a sugar method that calls decrypt method and catch the exceptions returning
         * `null` when it occurs and logging the error
         *
         * @param data the String to be decrypted
         *
         * @return the decrypted String or `null` if you send the data as `null`
         */
        fun decryptOrNull(data: String?): String? {
            return try {
                decrypt(data)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

        /**
         * This is a sugar method that calls decrypt method in background, it is a good idea to use this
         * one instead the default method because decryption can take several time and with this method
         * the process occurs in a AsyncTask, other advantage is the Callback with separated methods,
         * one for success and other for the exception
         *
         * @param data     the String to be decrypted
         * @param callback the Callback to handle the results
         */
        fun decryptAsync(data: String?, callback: Callback?) {
            if (callback == null) return
            Thread {
                try {
                    val decrypt = decrypt(data)
                    if (decrypt == null) {
                        callback.onError(Exception("Decrypt return null, it normally occurs when you send a null data"))
                    }
                    callback.onSuccess(decrypt)
                } catch (e: Exception) {
                    callback.onError(e)
                }
            }.start()
        }

        /**
         * creates a 128bit salted aes key
         *
         * @param key encoded input key
         *
         * @return aes 128 bit salted key
         *
         * @throws NoSuchAlgorithmException     if no installed provider that can provide the requested
         * by the Builder secret key type
         * @throws UnsupportedEncodingException if the Builder charset name is not supported
         * @throws InvalidKeySpecException      if the specified key specification cannot be used to
         * generate a secret key
         * @throws NullPointerException         if the specified Builder secret key type is `null`
         */
        @Throws(
            NoSuchAlgorithmException::class,
            UnsupportedEncodingException::class,
            InvalidKeySpecException::class
        )
        private fun getSecretKey(key: CharArray): SecretKey {
            val factory = SecretKeyFactory.getInstance(mBuilder.getSecretKeyType())
            val spec: KeySpec = PBEKeySpec(
                key,
                mBuilder.getSalt().toByteArray(charset(mBuilder.getCharsetName())),
                mBuilder.getIterationCount(),
                mBuilder.getKeyLength()
            )
            val tmp = factory.generateSecret(spec)
            return SecretKeySpec(tmp.encoded, mBuilder.getKeyAlgorithm())
        }

        /**
         * takes in a simple string and performs an sha1 hash
         * that is 128 bits long...we then base64 encode it
         * and return the char array
         *
         * @param key simple inputted string
         *
         * @return sha1 base64 encoded representation
         *
         * @throws UnsupportedEncodingException if the Builder charset name is not supported
         * @throws NoSuchAlgorithmException     if the Builder digest algorithm is not available
         * @throws NullPointerException         if the Builder digest algorithm is `null`
         */
        @Throws(UnsupportedEncodingException::class, NoSuchAlgorithmException::class)
        private fun hashTheKey(key: String?): CharArray {
            val messageDigest = MessageDigest.getInstance(mBuilder.getDigestAlgorithm())
            messageDigest.update(key!!.toByteArray(charset(mBuilder.getCharsetName())))
            return Base64.encodeToString(messageDigest.digest(), Base64.NO_PADDING).toCharArray()
        }

        /**
         * When you encrypt or decrypt in callback mode you get noticed of result using this interface
         */
        interface Callback {
            /**
             * Called when encrypt or decrypt job ends and the process was a success
             *
             * @param result the encrypted or decrypted String
             */
            fun onSuccess(result: String?)

            /**
             * Called when encrypt or decrypt job ends and has occurred an error in the process
             *
             * @param exception the Exception related to the error
             */
            fun onError(exception: Exception?)
        }

        /**
         * This class is used to create an Encryption.java instance, you should provide ALL data or start
         * with the Default Builder provided by the getDefaultBuilder method
         */
        class Builder {
            /**
             * @return the IvParameterSpec bytes array
             */
            private lateinit var iv: ByteArray

            /**
             * @return the length of key
             */
            private var keyLength = 0

            /**
             * @return the Base 64 mode
             */
            private var base64Mode = 0

            /**
             * @return the number of times the password is hashed
             */
            private var iterationCount = 0

            /**
             * @return the value used for salting
             */
            private var salt: String? = null

            /**
             * @return the key
             */
            private var key: String? = null

            /**
             * @return the algorithm
             */
            private var algorithm: String? = null

            /**
             * @return the key algorithm
             */
            private var keyAlgorithm: String? = null

            /**
             * @return the charset name
             */
            private var charsetName: String? = null

            /**
             * @return the type of aes key that will be created, on KITKAT+ the API has changed, if you
             * are getting problems please @see [http://android-developers.blogspot.com.br/2013/12/changes-to-secretkeyfactory-api-in.html](http://android-developers.blogspot.com.br/2013/12/changes-to-secretkeyfactory-api-in.html)
             */
            private var secretKeyType: String? = null

            /**
             * @return the message digest algorithm
             */
            private var digestAlgorithm: String? = null

            /**
             * @return the algorithm used to generate the secure random
             */
            private var secureRandomAlgorithm: String? = null

            /**
             * @return the SecureRandom
             */
            private var secureRandom: SecureRandom? = null

            /**
             * @return the IvParameterSpec
             */
            private var ivParameterSpec: IvParameterSpec? = null

            /**
             * Build the Encryption.java with the provided information
             *
             * @return a new Encryption.java instance with provided information
             *
             * @throws NoSuchAlgorithmException if the specified SecureRandomAlgorithm is not available
             * @throws NullPointerException     if the SecureRandomAlgorithm is `null` or if the
             * IV byte array is null
             */
            @Throws(NoSuchAlgorithmException::class)
            fun build(): Encryption.java {
                setSecureRandom(SecureRandom.getInstance(secureRandomAlgorithm))
                setIvParameterSpec(IvParameterSpec(iv))
                return Encryption.java(this)
            }

            /**
             * @param charsetName the new charset name
             *
             * @return this instance to follow the Builder patter
             */
            fun setCharsetName(charsetName: String?): Builder {
                this.charsetName = charsetName
                return this
            }

            /**
             * @param algorithm the algorithm to be used
             *
             * @return this instance to follow the Builder patter
             */
            fun setAlgorithm(algorithm: String?): Builder {
                this.algorithm = algorithm
                return this
            }

            /**
             * @param keyAlgorithm the keyAlgorithm to be used in keys
             *
             * @return this instance to follow the Builder patter
             */
            fun setKeyAlgorithm(keyAlgorithm: String?): Builder {
                this.keyAlgorithm = keyAlgorithm
                return this
            }

            /**
             * @param base64Mode set the base 64 mode
             *
             * @return this instance to follow the Builder patter
             */
            fun setBase64Mode(base64Mode: Int): Builder {
                this.base64Mode = base64Mode
                return this
            }

            /**
             * @param secretKeyType the type of AES key that will be created, on KITKAT+ the API has
             * changed, if you are getting problems please @see [http://android-developers.blogspot.com.br/2013/12/changes-to-secretkeyfactory-api-in.html](http://android-developers.blogspot.com.br/2013/12/changes-to-secretkeyfactory-api-in.html)
             *
             * @return this instance to follow the Builder patter
             */
            fun setSecretKeyType(secretKeyType: String?): Builder {
                this.secretKeyType = secretKeyType
                return this
            }

            /**
             * @param salt the value used for salting
             *
             * @return this instance to follow the Builder patter
             */
            fun setSalt(salt: String?): Builder {
                this.salt = salt
                return this
            }

            /**
             * @param key the key.
             *
             * @return this instance to follow the Builder patter
             */
            fun setKey(key: String?): Builder {
                this.key = key
                return this
            }

            /**
             * @param keyLength the length of key
             *
             * @return this instance to follow the Builder patter
             */
            fun setKeyLength(keyLength: Int): Builder {
                this.keyLength = keyLength
                return this
            }

            /**
             * @param iterationCount the number of times the password is hashed
             *
             * @return this instance to follow the Builder patter
             */
            fun setIterationCount(iterationCount: Int): Builder {
                this.iterationCount = iterationCount
                return this
            }

            /**
             * @param secureRandomAlgorithm the algorithm to generate the secure random
             *
             * @return this instance to follow the Builder patter
             */
            fun setSecureRandomAlgorithm(secureRandomAlgorithm: String?): Builder {
                this.secureRandomAlgorithm = secureRandomAlgorithm
                return this
            }

            /**
             * @param iv the byte array to create a new IvParameterSpec
             *
             * @return this instance to follow the Builder patter
             */
            fun setIv(iv: ByteArray): Builder {
                this.iv = iv
                return this
            }

            /**
             * @param secureRandom the Secure Random
             *
             * @return this instance to follow the Builder patter
             */
            fun setSecureRandom(secureRandom: SecureRandom?): Builder {
                this.secureRandom = secureRandom
                return this
            }

            /**
             * @param ivParameterSpec the IvParameterSpec
             *
             * @return this instance to follow the Builder patter
             */
            fun setIvParameterSpec(ivParameterSpec: IvParameterSpec?): Builder {
                this.ivParameterSpec = ivParameterSpec
                return this
            }

            /**
             * @param digestAlgorithm the algorithm to be used to get message digest instance
             *
             * @return this instance to follow the Builder patter
             */
            fun setDigestAlgorithm(digestAlgorithm: String?): Builder {
                this.digestAlgorithm = digestAlgorithm
                return this
            }

            companion object {
                /**
                 * @return an default builder with the follow defaults:
                 * the default char set is UTF-8
                 * the default base mode is Base64
                 * the Secret Key Type is the PBKDF2WithHmacSHA1
                 * the default salt is "some_salt" but can be anything
                 * the default length of key is 128
                 * the default iteration count is 65536
                 * the default algorithm is AES in CBC mode and PKCS 5 Padding
                 * the default secure random algorithm is SHA1PRNG
                 * the default message digest algorithm SHA1
                 */
                fun getDefaultBuilder(key: String?, salt: String?, iv: ByteArray): Builder {
                    return Builder()
                        .setIv(iv)
                        .setKey(key)
                        .setSalt(salt)
                        .setKeyLength(128)
                        .setKeyAlgorithm("AES")
                        .setCharsetName("UTF8")
                        .setIterationCount(1)
                        .setDigestAlgorithm("SHA1")
                        .setBase64Mode(Base64.DEFAULT)
                        .setAlgorithm("AES/CBC/PKCS5Padding")
                        .setSecureRandomAlgorithm("SHA1PRNG")
                        .setSecretKeyType("PBKDF2WithHmacSHA1")
                }
            }
        }

        companion object {
            const val encryption_key = "Qwm23c*3df._edjDSA"
            const val encryption_salt = "!sdjk4_*tRLo2"
            val Iv_value = byteArrayOf(1, 2, 1, 9, 8, 5, 4, 3, 2, 5, 6, 4, 3, 8, 1, 0)
            private val ivSpec = IvParameterSpec(Iv_value)

            /**
             * @return an default encryption instance or `null` if occur some Exception, you can
             * create yur own Encryption.java instance using the Encryption.java.Builder
             */
            fun getDefault(key: String?, salt: String?, iv: ByteArray): Encryption.java? {
                return try {
                    Builder.getDefaultBuilder(key, salt, iv).build()
                } catch (e: NoSuchAlgorithmException) {
                    e.printStackTrace()
                    null
                }
            }

            fun getencryptedValue(input: String): String? {
                var enc_value = ""
                val con = Constants()
                val enc = getDefault(encryption_key, encryption_salt, ivSpec.iv)
                try {
                    enc_value = enc!!.encrypt(input)
                } catch (e: Exception) {
                    println("Error in encrypting :$input")
                    e.printStackTrace()
                }
                return enc_value
            }

             fun getdecryptedValue(input: String): String? {
                var dec_value = ""
                val con = Constants()
                val enc = getDefault(encryption_key, encryption_salt, ivSpec.iv)
                try {
                    dec_value = enc!!.decrypt(input)
                } catch (e: Exception) {
                    println("Error in decrypting :$input")
                    e.printStackTrace()
                }
                return dec_value
            }
        }
    }

    }*/
    }
}