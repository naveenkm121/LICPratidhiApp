package com.licapps.bmmis.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/licapps/bmmis/data/api/PlanRemoteDataSource;", "Lcom/licapps/bmmis/data/api/BaseDataSource;", "planServices", "Lcom/licapps/bmmis/data/api/PlanServices;", "(Lcom/licapps/bmmis/data/api/PlanServices;)V", "downloadFile", "Lcom/licapps/bmmis/utils/Resource;", "Lokhttp3/ResponseBody;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PlanRemoteDataSource extends com.licapps.bmmis.data.api.BaseDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.api.PlanServices planServices = null;
    
    @javax.inject.Inject()
    public PlanRemoteDataSource(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.PlanServices planServices) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object downloadFile(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<? extends okhttp3.ResponseBody>> $completion) {
        return null;
    }
}