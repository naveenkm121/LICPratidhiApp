package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/licapps/bmmis/utils/SaveSharedPreference;", "", "()V", "getDeviceId", "", "context", "Landroid/content/Context;", "getLoggedStatus", "", "(Landroid/content/Context;)Ljava/lang/Boolean;", "getPin", "getUserDetails", "Lcom/licapps/bmmis/data/model/login/LoginData;", "getUserDetailsPreferences", "Landroid/content/SharedPreferences;", "login", "", "loginRes", "Lcom/licapps/bmmis/data/model/login/LoginRes;", "logout", "setDeviceId", "deviceId", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "setPin", "pin", "app_debug"})
public final class SaveSharedPreference {
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.utils.SaveSharedPreference INSTANCE = null;
    
    private SaveSharedPreference() {
        super();
    }
    
    private final android.content.SharedPreferences getUserDetailsPreferences(android.content.Context context) {
        return null;
    }
    
    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    public final void login(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.login.LoginRes loginRes) {
    }
    
    public final void logout(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean setPin(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPin(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeviceId(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean setDeviceId(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId) {
        return null;
    }
    
    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLoggedStatus(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.licapps.bmmis.data.model.login.LoginData getUserDetails(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
}