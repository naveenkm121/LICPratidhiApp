package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/licapps/bmmis/utils/CommonUtility;", "", "()V", "Companion", "app_debug"})
public final class CommonUtility {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATE_FORMAT_DDMMYYYY = "dd-MM-yyyy";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.utils.CommonUtility.Companion Companion = null;
    
    public CommonUtility() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\u0010\u0010\'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0010\u0010)\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0002042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020!J\u000e\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004J\b\u00109\u001a\u0004\u0018\u00010\u0004J\u0016\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=J\u0018\u0010>\u001a\u00020\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010?\u001a\u00020@J\u001c\u0010A\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CJ\u0018\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0004J0\u0010G\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040Hj\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0004`I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020!0CJ\u000e\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004J\u0016\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004J\u0006\u0010O\u001a\u00020\u0004J\u0006\u0010P\u001a\u00020\u0004J\u0006\u0010Q\u001a\u00020\u0004J\u0006\u0010R\u001a\u00020\u0004J\u0010\u0010S\u001a\u00020T2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0010\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WJ\u0010\u0010X\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u0004J\u0010\u0010Z\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\\\u001a\u00020T2\b\u0010]\u001a\u0004\u0018\u00010\u0004J\u0016\u0010^\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0004J\u0016\u0010_\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010`\u001a\u00020\u0004J\u000e\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020cJ\u0016\u0010d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010e\u001a\u00020\u0004J\u000e\u0010f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010g\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006k"}, d2 = {"Lcom/licapps/bmmis/utils/CommonUtility$Companion;", "", "()V", "DATE_FORMAT_DDMMYYYY", "", "getDATE_FORMAT_DDMMYYYY", "()Ljava/lang/String;", "DATE_FORMAT_YYYYMMDD", "getDATE_FORMAT_YYYYMMDD", "callNumberFromApp", "", "context", "Landroid/content/Context;", "number", "capitalize", "s", "checkNullAndSetDefaultNo", "key", "checkNullAndSetDefaultYes", "composeEmail", "email", "subject", "convertDoubletoIndiaCurrency", "convertNumtoIndiaCurrency", "downloadPdf", "", "baseActivity", "url", "title", "encodeURItoB64", "uri", "Landroid/net/Uri;", "getAgeFromDOB", "", "year", "month", "day", "getAgeFromDOBYYYYMMDD", "dobInYYYYMMDD", "getAgeLBD", "dob", "getAgeNBD", "getAppDataInfo", "Lcom/licapps/bmmis/data/model/util/AppDataInfo;", "getAppVersionCode", "getAppVersionName", "getByteArray", "", "getBytes", "inputStream", "Ljava/io/InputStream;", "getCurrencyInShort", "", "getDOBfromAge", "age", "getDateYYYYMMDDFromDDMMYYY", "ddmmyyyy", "getDeviceName", "getImageFromBase64", "base64String", "imageView", "Landroid/widget/ImageView;", "getImageUriFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "getIndexOfSpinnerFromKey", "spinnerList", "", "Lcom/licapps/bmmis/data/model/SpinnerItemModel;", "getJsonDataFromAsset", "fileName", "getModeMapFromModeList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mode", "getPaymentModeFullName", "getPercentage", "part", "total", "getTodayDateDDMMYYYY", "getTodayDateForNBDDMMYYYY", "getTodayDateForNBYYYYMMDD", "getTodayDateYYYYMMDD", "isSwitchSelected", "", "isValidEmail", "target", "", "isValidPANNumber", "panNumber", "isValidPhoneNumber", "phoneNumber", "isValidPinCode", "pinCode", "launchBrowser", "launchPlayStore", "packageName", "logoutAppSession", "activity", "Landroid/app/Activity;", "setAppLocale", "language", "shareApp", "storeToPDFandOpen", "directoryName", "base", "planNumber", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDATE_FORMAT_DDMMYYYY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDATE_FORMAT_YYYYMMDD() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getJsonDataFromAsset(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String fileName) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTodayDateForNBDDMMYYYY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTodayDateForNBYYYYMMDD() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTodayDateYYYYMMDD() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTodayDateDDMMYYYY() {
            return null;
        }
        
        public final boolean isValidEmail(@org.jetbrains.annotations.Nullable()
        java.lang.CharSequence target) {
            return false;
        }
        
        public final boolean isValidPinCode(@org.jetbrains.annotations.Nullable()
        java.lang.String pinCode) {
            return false;
        }
        
        public final boolean isValidPhoneNumber(@org.jetbrains.annotations.Nullable()
        java.lang.String phoneNumber) {
            return false;
        }
        
        public final boolean isValidPANNumber(@org.jetbrains.annotations.Nullable()
        java.lang.String panNumber) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDateYYYYMMDDFromDDMMYYY(@org.jetbrains.annotations.NotNull()
        java.lang.String ddmmyyyy) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri getImageUriFromBitmap(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap bitmap) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String encodeURItoB64(@org.jetbrains.annotations.Nullable()
        android.net.Uri uri, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final byte[] getByteArray(android.net.Uri uri, android.content.Context context) {
            return null;
        }
        
        @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
        @org.jetbrains.annotations.Nullable()
        public final byte[] getBytes(@org.jetbrains.annotations.NotNull()
        java.io.InputStream inputStream) throws java.io.IOException {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.HashMap<java.lang.Integer, java.lang.String> getModeMapFromModeList(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.Integer> mode) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAgeFromDOBYYYYMMDD(@org.jetbrains.annotations.NotNull()
        java.lang.String dobInYYYYMMDD) {
            return null;
        }
        
        public final int getAgeFromDOB(int year, int month, int day) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String convertNumtoIndiaCurrency(@org.jetbrains.annotations.Nullable()
        java.lang.String number) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String convertDoubletoIndiaCurrency(@org.jetbrains.annotations.Nullable()
        java.lang.String number) {
            return null;
        }
        
        private final double getCurrencyInShort(java.lang.String number) {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDOBfromAge(int age) {
            return null;
        }
        
        public final int getAgeNBD(@org.jetbrains.annotations.Nullable()
        java.lang.String dob) {
            return 0;
        }
        
        public final int getAgeLBD(@org.jetbrains.annotations.Nullable()
        java.lang.String dob) {
            return 0;
        }
        
        public final long downloadPdf(@org.jetbrains.annotations.NotNull()
        android.content.Context baseActivity, @org.jetbrains.annotations.Nullable()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        java.lang.String title) {
            return 0L;
        }
        
        public final void storeToPDFandOpen(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String directoryName, @org.jetbrains.annotations.NotNull()
        java.lang.String base, @org.jetbrains.annotations.NotNull()
        java.lang.String planNumber) {
        }
        
        public final void setAppLocale(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String language) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.licapps.bmmis.data.model.util.AppDataInfo getAppDataInfo(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void getImageFromBase64(@org.jetbrains.annotations.NotNull()
        java.lang.String base64String, @org.jetbrains.annotations.NotNull()
        android.widget.ImageView imageView) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPaymentModeFullName(@org.jetbrains.annotations.NotNull()
        java.lang.String mode) {
            return null;
        }
        
        public final int getIndexOfSpinnerFromKey(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> spinnerList) {
            return 0;
        }
        
        public final boolean isSwitchSelected(@org.jetbrains.annotations.Nullable()
        java.lang.String key) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String checkNullAndSetDefaultNo(@org.jetbrains.annotations.Nullable()
        java.lang.String key) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String checkNullAndSetDefaultYes(@org.jetbrains.annotations.Nullable()
        java.lang.String key) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAppVersionName(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final long getAppVersionCode(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return 0L;
        }
        
        public final void launchBrowser(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String url) {
        }
        
        public final void launchPlayStore(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String packageName) {
        }
        
        public final void shareApp(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void callNumberFromApp(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.lang.String number) {
        }
        
        public final void composeEmail(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String email, @org.jetbrains.annotations.Nullable()
        java.lang.String subject) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDeviceName() {
            return null;
        }
        
        private final java.lang.String capitalize(java.lang.String s) {
            return null;
        }
        
        public final void logoutAppSession(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPercentage(@org.jetbrains.annotations.NotNull()
        java.lang.String part, @org.jetbrains.annotations.NotNull()
        java.lang.String total) {
            return null;
        }
    }
}