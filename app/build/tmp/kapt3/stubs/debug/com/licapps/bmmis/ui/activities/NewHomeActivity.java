package com.licapps.bmmis.ui.activities;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020$H\u0016J\b\u0010.\u001a\u00020\u001dH\u0002J\u0018\u0010/\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020$R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u00062"}, d2 = {"Lcom/licapps/bmmis/ui/activities/NewHomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "binding", "Lcom/licapps/bmmis/databinding/ActivityNewHomeBinding;", "branch", "getBranch", "setBranch", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "navController", "Landroidx/navigation/NavController;", "navView", "Lcom/google/android/material/navigation/NavigationView;", "progressDialog", "Landroid/app/Dialog;", "getProgressDialog", "()Landroid/app/Dialog;", "setProgressDialog", "(Landroid/app/Dialog;)V", "hideProgressDialog", "", "logout", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onCreatePanelMenu", "featureId", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSupportNavigateUp", "setPanelUI", "showProgressDialog", "msg", "isCancelable", "app_debug"})
public final class NewHomeActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    private androidx.navigation.NavController navController;
    private com.google.android.material.navigation.NavigationView navView;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String branch = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String accessToken = "";
    @org.jetbrains.annotations.Nullable()
    private android.app.Dialog progressDialog;
    private com.licapps.bmmis.databinding.ActivityNewHomeBinding binding;
    
    public NewHomeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBranch() {
        return null;
    }
    
    public final void setBranch(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccessToken() {
        return null;
    }
    
    public final void setAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.app.Dialog getProgressDialog() {
        return null;
    }
    
    protected final void setProgressDialog(@org.jetbrains.annotations.Nullable()
    android.app.Dialog p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void showProgressDialog(@org.jetbrains.annotations.Nullable()
    java.lang.String msg, boolean isCancelable) {
    }
    
    public final void hideProgressDialog() {
    }
    
    @java.lang.Override()
    public boolean onCreatePanelMenu(int featureId, @org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    private final void setPanelUI() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public final void logout() {
    }
}