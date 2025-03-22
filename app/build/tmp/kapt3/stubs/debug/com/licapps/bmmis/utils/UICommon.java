package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/licapps/bmmis/utils/UICommon;", "", "()V", "Companion", "app_debug"})
public final class UICommon {
    @org.jetbrains.annotations.Nullable()
    private static android.app.Dialog progressDialog;
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.utils.UICommon.Companion Companion = null;
    
    public UICommon() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJR\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u0012J \u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\"J \u0010#\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010$\u001a\u00020\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006%"}, d2 = {"Lcom/licapps/bmmis/utils/UICommon$Companion;", "", "()V", "progressDialog", "Landroid/app/Dialog;", "getProgressDialog", "()Landroid/app/Dialog;", "setProgressDialog", "(Landroid/app/Dialog;)V", "hideProgressDialog", "", "act", "Landroid/app/Activity;", "hideSoftKeyboard", "view", "Landroid/view/View;", "showAlertDialog", "cancellable", "", "title", "", "message", "positiveBtn", "negativeBtn", "neutralBtn", "listener", "Lcom/licapps/bmmis/utils/AlertDialogListener;", "context", "Landroid/content/Context;", "showProgressDialog", "msg", "isCancelable", "showSnackbar", "duration", "", "showWebViewAlertDialog", "layoutResId", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        protected final android.app.Dialog getProgressDialog() {
            return null;
        }
        
        protected final void setProgressDialog(@org.jetbrains.annotations.Nullable()
        android.app.Dialog p0) {
        }
        
        public final void showSnackbar(@org.jetbrains.annotations.NotNull()
        android.app.Activity act, @org.jetbrains.annotations.Nullable()
        java.lang.String message, int duration) {
        }
        
        public final void hideSoftKeyboard(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        android.app.Activity act) {
        }
        
        public final void showAlertDialog(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        public final void showWebViewAlertDialog(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.lang.String message, int layoutResId) {
        }
        
        public final void showProgressDialog(@org.jetbrains.annotations.NotNull()
        android.app.Activity act, @org.jetbrains.annotations.Nullable()
        java.lang.String msg, boolean isCancelable) {
        }
        
        public final void hideProgressDialog(@org.jetbrains.annotations.NotNull()
        android.app.Activity act) {
        }
        
        public final void showAlertDialog(@org.jetbrains.annotations.Nullable()
        android.app.Activity act, boolean cancellable, @org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.Nullable()
        java.lang.String message, @org.jetbrains.annotations.Nullable()
        java.lang.String positiveBtn, @org.jetbrains.annotations.Nullable()
        java.lang.String negativeBtn, @org.jetbrains.annotations.NotNull()
        java.lang.String neutralBtn, @org.jetbrains.annotations.Nullable()
        com.licapps.bmmis.utils.AlertDialogListener listener) {
        }
    }
}