package com.licapps.bmmis.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/licapps/bmmis/utils/DateTimeUtility;", "", "()V", "Companion", "OnDateSelectListener", "app_debug"})
public final class DateTimeUtility {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATE_FORMAT_DDMMYYYY = "dd-MM-yyyy";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
    @org.jetbrains.annotations.NotNull()
    public static final com.licapps.bmmis.utils.DateTimeUtility.Companion Companion = null;
    
    public DateTimeUtility() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/licapps/bmmis/utils/DateTimeUtility$Companion;", "", "()V", "DATE_FORMAT_DDMMYYYY", "", "getDATE_FORMAT_DDMMYYYY", "()Ljava/lang/String;", "DATE_FORMAT_YYYYMMDD", "getDATE_FORMAT_YYYYMMDD", "getDateStringFromLong", "dateInLong", "", "getFYStartDate", "showDateDialog", "", "startDate", "endDate", "isProposal", "", "listener", "Lcom/licapps/bmmis/utils/DateTimeUtility$OnDateSelectListener;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "app_debug"})
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
        
        public final void showDateDialog(long startDate, long endDate, boolean isProposal, @org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.utils.DateTimeUtility.OnDateSelectListener listener, @org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentManager fragmentManager) {
        }
        
        public final long getFYStartDate() {
            return 0L;
        }
        
        private final java.lang.String getDateStringFromLong(long dateInLong) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/licapps/bmmis/utils/DateTimeUtility$OnDateSelectListener;", "", "onDateSelected", "", "selectedDate", "", "app_debug"})
    public static abstract interface OnDateSelectListener {
        
        public abstract void onDateSelected(@org.jetbrains.annotations.NotNull()
        java.lang.String selectedDate);
    }
}