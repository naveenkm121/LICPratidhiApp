package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/licapps/bmmis/utils/DebugHandler;", "", "()V", "Companion", "app_debug"})
public final class DebugHandler {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOG_TAG = "LIC_AGENT_APP ::";
    private static final boolean ENABLE_LOGS = true;
    private static final int VERBOSE = android.util.Log.VERBOSE;
    private static final int DEBUG = android.util.Log.DEBUG;
    private static final int INFO = android.util.Log.INFO;
    private static final int WARN = android.util.Log.WARN;
    private static final int ERROR = android.util.Log.ERROR;
    private static final int WTF = android.util.Log.ASSERT;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_TAG = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String tag = null;
    private static final int LEVEL = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.utils.DebugHandler.Companion Companion = null;
    
    public DebugHandler() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/licapps/bmmis/utils/DebugHandler$Companion;", "", "()V", "DEBUG", "", "DEFAULT_TAG", "", "ENABLE_LOGS", "", "ERROR", "INFO", "LEVEL", "LOG_TAG", "VERBOSE", "WARN", "WTF", "tag", "log", "", "message", "logException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void logException(@org.jetbrains.annotations.Nullable()
        java.lang.Exception e) {
        }
        
        public final void log(@org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
    }
}