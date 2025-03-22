package com.licapps.bmmis.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/licapps/bmmis/data/model/Limited;", "Ljava/io/Serializable;", "isPTfixed", "", "isPPTfixed", "ptEQppt", "pt", "", "", "ppt", "mode", "(ZZZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "()Z", "getMode", "()Ljava/util/List;", "getPpt", "getPt", "getPtEQppt", "app_debug"})
public final class Limited implements java.io.Serializable {
    @androidx.room.ColumnInfo(defaultValue = "false")
    private final boolean isPTfixed = false;
    @androidx.room.ColumnInfo(defaultValue = "false")
    private final boolean isPPTfixed = false;
    @androidx.room.ColumnInfo(defaultValue = "false")
    private final boolean ptEQppt = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> pt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> ppt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> mode = null;
    
    public Limited(boolean isPTfixed, boolean isPPTfixed, boolean ptEQppt, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> pt, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> ppt, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> mode) {
        super();
    }
    
    public final boolean isPTfixed() {
        return false;
    }
    
    public final boolean isPPTfixed() {
        return false;
    }
    
    public final boolean getPtEQppt() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getPt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getPpt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getMode() {
        return null;
    }
}