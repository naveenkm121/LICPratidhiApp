package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00107\u001a\u00020)2\u0006\u00108\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020)H\u0002J\u0012\u0010<\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010=\u001a\u00020)H\u0002J\u0012\u0010>\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\u00a8\u0006B"}, d2 = {"Lcom/licapps/bmmis/ui/fragments/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appDataInfo", "Lcom/licapps/bmmis/data/model/util/AppDataInfo;", "<set-?>", "Lcom/licapps/bmmis/databinding/LoginFragmentBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/LoginFragmentBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/LoginFragmentBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "deviceId", "", "dialog", "Landroid/app/Dialog;", "isOTPUser", "", "()Z", "setOTPUser", "(Z)V", "loginRequest", "Lcom/licapps/bmmis/data/model/login/LoginReq;", "otpScreenList", "", "getOtpScreenList", "()Ljava/util/List;", "setOtpScreenList", "(Ljava/util/List;)V", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/LoginViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkIdPwdValidation", "userId", "password", "checkLogin", "", "login", "saveDetails", "loginRes", "Lcom/licapps/bmmis/data/model/login/LoginRes;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setInitialData", "setInitialUI", "setOnClickListeners", "setPinDialogUI", "setupObservers", "showPinDialog", "validatePinSetData", "pin1", "pin2", "app_debug"})
public final class LoginFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private com.licapps.bmmis.data.model.login.LoginReq loginRequest;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> otpScreenList;
    private boolean isOTPUser = false;
    private android.app.Dialog dialog;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceId = "";
    private com.licapps.bmmis.data.model.util.AppDataInfo appDataInfo;
    
    public LoginFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.LoginFragmentBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.LoginFragmentBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.LoginViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getOtpScreenList() {
        return null;
    }
    
    public final void setOtpScreenList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public final boolean isOTPUser() {
        return false;
    }
    
    public final void setOTPUser(boolean p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setInitialUI() {
    }
    
    private final void setInitialData() {
    }
    
    private final void checkLogin() {
    }
    
    private final void setOnClickListeners() {
    }
    
    private final boolean checkIdPwdValidation(java.lang.String userId, java.lang.String password) {
        return false;
    }
    
    private final void showPinDialog(com.licapps.bmmis.data.model.login.LoginRes loginRes) {
    }
    
    private final void setPinDialogUI(com.licapps.bmmis.data.model.login.LoginRes loginRes) {
    }
    
    private final void setupObservers() {
    }
    
    private final boolean validatePinSetData(java.lang.String pin1, java.lang.String pin2) {
        return false;
    }
    
    private final void login(boolean saveDetails, com.licapps.bmmis.data.model.login.LoginRes loginRes) {
    }
}