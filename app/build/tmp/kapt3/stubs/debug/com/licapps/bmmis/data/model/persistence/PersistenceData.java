package com.licapps.bmmis.data.model.persistence;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003Jw\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u000207H\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012\u00a8\u00069"}, d2 = {"Lcom/licapps/bmmis/data/model/persistence/PersistenceData;", "", "bocd", "", "pol13th_pers", "pol13th_tot", "pol25th_pers", "pol25th_tot", "pol37th_pers", "pol37th_tot", "pol49th_pers", "pol49th_tot", "pol61st_pers", "pol61st_tot", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBocd", "()Ljava/lang/String;", "setBocd", "(Ljava/lang/String;)V", "getPol13th_pers", "setPol13th_pers", "getPol13th_tot", "setPol13th_tot", "getPol25th_pers", "setPol25th_pers", "getPol25th_tot", "setPol25th_tot", "getPol37th_pers", "setPol37th_pers", "getPol37th_tot", "setPol37th_tot", "getPol49th_pers", "setPol49th_pers", "getPol49th_tot", "setPol49th_tot", "getPol61st_pers", "setPol61st_pers", "getPol61st_tot", "setPol61st_tot", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class PersistenceData {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String bocd;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol13th_pers;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol13th_tot;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol25th_pers;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol25th_tot;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol37th_pers;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol37th_tot;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol49th_pers;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol49th_tot;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol61st_pers;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pol61st_tot;
    
    public PersistenceData(@org.jetbrains.annotations.NotNull()
    java.lang.String bocd, @org.jetbrains.annotations.NotNull()
    java.lang.String pol13th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol13th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol25th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol25th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol37th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol37th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol49th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol49th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol61st_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol61st_tot) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBocd() {
        return null;
    }
    
    public final void setBocd(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol13th_pers() {
        return null;
    }
    
    public final void setPol13th_pers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol13th_tot() {
        return null;
    }
    
    public final void setPol13th_tot(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol25th_pers() {
        return null;
    }
    
    public final void setPol25th_pers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol25th_tot() {
        return null;
    }
    
    public final void setPol25th_tot(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol37th_pers() {
        return null;
    }
    
    public final void setPol37th_pers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol37th_tot() {
        return null;
    }
    
    public final void setPol37th_tot(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol49th_pers() {
        return null;
    }
    
    public final void setPol49th_pers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol49th_tot() {
        return null;
    }
    
    public final void setPol49th_tot(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol61st_pers() {
        return null;
    }
    
    public final void setPol61st_pers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPol61st_tot() {
        return null;
    }
    
    public final void setPol61st_tot(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public PersistenceData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.model.persistence.PersistenceData copy(@org.jetbrains.annotations.NotNull()
    java.lang.String bocd, @org.jetbrains.annotations.NotNull()
    java.lang.String pol13th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol13th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol25th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol25th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol37th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol37th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol49th_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol49th_tot, @org.jetbrains.annotations.NotNull()
    java.lang.String pol61st_pers, @org.jetbrains.annotations.NotNull()
    java.lang.String pol61st_tot) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}