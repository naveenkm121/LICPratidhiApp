package com.licapps.bmmis.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/licapps/bmmis/data/repository/PlansRepository;", "", "remoteDataSource", "Lcom/licapps/bmmis/data/api/PlanRemoteDataSource;", "localDataSource", "Lcom/licapps/bmmis/data/localdb/PlanDao;", "(Lcom/licapps/bmmis/data/api/PlanRemoteDataSource;Lcom/licapps/bmmis/data/localdb/PlanDao;)V", "downloadFile", "Landroidx/lifecycle/LiveData;", "Lcom/licapps/bmmis/utils/Resource;", "Lokhttp3/ResponseBody;", "url", "", "app_debug"})
public final class PlansRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.api.PlanRemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.localdb.PlanDao localDataSource = null;
    
    @javax.inject.Inject()
    public PlansRepository(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.PlanRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.localdb.PlanDao localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<okhttp3.ResponseBody>> downloadFile(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
}