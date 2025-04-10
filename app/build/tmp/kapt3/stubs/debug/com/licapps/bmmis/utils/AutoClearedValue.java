package com.licapps.bmmis.utils;

/**
 * A lazy property that gets cleaned up when the fragment's view is destroyed.
 *
 * Accessing this variable while the fragment's view is destroyed will throw NPE.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0096\u0002\u00a2\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0013R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/licapps/bmmis/utils/AutoClearedValue;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)V", "_value", "Ljava/lang/Object;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "app_debug"})
public final class AutoClearedValue<T extends java.lang.Object> implements kotlin.properties.ReadWriteProperty<androidx.fragment.app.Fragment, T> {
    @org.jetbrains.annotations.NotNull()
    private final androidx.fragment.app.Fragment fragment = null;
    @org.jetbrains.annotations.Nullable()
    private T _value;
    
    public AutoClearedValue(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.fragment.app.Fragment getFragment() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public T getValue(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    @java.lang.Override()
    public void setValue(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
    T value) {
    }
}