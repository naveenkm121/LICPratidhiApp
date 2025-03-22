package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/licapps/bmmis/utils/AlertDialogListener;", "", "onNegativeButton", "", "dialog", "Landroid/content/DialogInterface;", "onNeutralButton", "onPositiveButton", "app_debug"})
public abstract interface AlertDialogListener {
    
    public abstract void onPositiveButton(@org.jetbrains.annotations.Nullable()
    android.content.DialogInterface dialog);
    
    public abstract void onNegativeButton(@org.jetbrains.annotations.Nullable()
    android.content.DialogInterface dialog);
    
    public abstract void onNeutralButton(@org.jetbrains.annotations.Nullable()
    android.content.DialogInterface dialog);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        public static void onNegativeButton(@org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.utils.AlertDialogListener $this, @org.jetbrains.annotations.Nullable()
        android.content.DialogInterface dialog) {
        }
        
        public static void onNeutralButton(@org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.utils.AlertDialogListener $this, @org.jetbrains.annotations.Nullable()
        android.content.DialogInterface dialog) {
        }
    }
}