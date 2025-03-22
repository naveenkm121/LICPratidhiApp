package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/licapps/bmmis/utils/EncryptUtil;", "", "()V", "Companion", "app_debug"})
public final class EncryptUtil {
    private static final int pswdIterations = 1;
    private static final int keySize = 128;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String cypherInstance = "AES/CBC/PKCS5Padding";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String secretKeyInstance = "PBKDF2WithHmacSHA1";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String plainText = "Qwm23c*3df._edjDSA";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String AESSalt = "@34dt*";
    @org.jetbrains.annotations.NotNull()
    private static final byte[] initializationVector = {(byte)1, (byte)2, (byte)1, (byte)9, (byte)8, (byte)5, (byte)4, (byte)3, (byte)2, (byte)5, (byte)6, (byte)4, (byte)3, (byte)8, (byte)1, (byte)0};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String digestAlgorithm = "SHA1";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String secureRandomAlgorithm = "SHA1PRNG";
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.utils.EncryptUtil.Companion Companion = null;
    
    public EncryptUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/licapps/bmmis/utils/EncryptUtil$Companion;", "", "()V", "AESSalt", "", "cypherInstance", "digestAlgorithm", "initializationVector", "", "keySize", "", "plainText", "pswdIterations", "secretKeyInstance", "secureRandomAlgorithm", "decrypt", "textToDecrypt", "encrypt", "textToEncrypt", "getRaw", "", "salt", "getSalt", "get_SHA_512_SecurePassword", "passwordToHash", "hashTheKey", "key", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String get_SHA_512_SecurePassword(@org.jetbrains.annotations.NotNull()
        java.lang.String passwordToHash) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSalt() {
            return null;
        }
        
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
        @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String encrypt(@org.jetbrains.annotations.NotNull()
        java.lang.String textToEncrypt) throws java.lang.Exception {
            return null;
        }
        
        @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String decrypt(@org.jetbrains.annotations.Nullable()
        java.lang.String textToDecrypt) throws java.lang.Exception {
            return null;
        }
        
        private final byte[] getRaw(char[] plainText, java.lang.String salt) {
            return null;
        }
        
        private final char[] hashTheKey(java.lang.String key) {
            return null;
        }
    }
}