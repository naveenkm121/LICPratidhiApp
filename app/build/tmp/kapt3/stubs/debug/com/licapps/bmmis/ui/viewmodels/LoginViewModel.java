package com.licapps.bmmis.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/licapps/bmmis/ui/viewmodels/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/licapps/bmmis/data/repository/AnandaRepository;", "(Lcom/licapps/bmmis/data/repository/AnandaRepository;)V", "_request", "Landroidx/lifecycle/MutableLiveData;", "Lcom/licapps/bmmis/data/model/login/LoginReq;", "_response", "Landroidx/lifecycle/LiveData;", "Lcom/licapps/bmmis/utils/Resource;", "Lcom/licapps/bmmis/data/model/login/LoginRes;", "response", "getResponse", "()Landroidx/lifecycle/LiveData;", "login", "", "request", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.repository.AnandaRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.licapps.bmmis.data.model.login.LoginReq> _request = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.login.LoginRes>> _response = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.login.LoginRes>> response = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.repository.AnandaRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.login.LoginRes>> getResponse() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.login.LoginReq request) {
    }
}