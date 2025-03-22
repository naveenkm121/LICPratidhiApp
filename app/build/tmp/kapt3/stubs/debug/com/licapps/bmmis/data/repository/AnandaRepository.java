package com.licapps.bmmis.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\t0\b2\u0006\u0010\u000b\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\t0\bJ\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\t0\b2\u0006\u0010\u000b\u001a\u00020&J\u001a\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\t0\b2\u0006\u0010\u000b\u001a\u000202J\u001a\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\t0\b2\u0006\u0010I\u001a\u00020JR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lcom/licapps/bmmis/data/repository/AnandaRepository;", "", "remoteDataSource", "Lcom/licapps/bmmis/data/api/BMMisRemoteDataSource;", "localDataSource", "Lcom/licapps/bmmis/data/localdb/PlanDao;", "(Lcom/licapps/bmmis/data/api/BMMisRemoteDataSource;Lcom/licapps/bmmis/data/localdb/PlanDao;)V", "getActivisationData", "Landroidx/lifecycle/LiveData;", "Lcom/licapps/bmmis/utils/Resource;", "Lcom/licapps/bmmis/data/model/activisation/ActivisationListRes;", "request", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "getAnandaData", "Lcom/licapps/bmmis/data/model/ananda/AnandaRes;", "getAvailableResource", "Lcom/licapps/bmmis/data/model/resource/ResourceListRes;", "getBOCdata", "Lcom/licapps/bmmis/data/model/boc/BOCListRes;", "getChannelWiseNB", "Lcom/licapps/bmmis/data/model/channelwise/ChannelwiseNBRes;", "getClaimsData", "Lcom/licapps/bmmis/data/model/claims/ClaimsRes;", "getEMHRData", "Lcom/licapps/bmmis/data/model/emhr/EmhrRes;", "Lcom/licapps/bmmis/data/model/emhr/EmhrReq;", "getInactiveCLIAList", "Lcom/licapps/bmmis/data/model/inactive/InactiveDORes;", "getInactiveCliaForDayList", "getInactiveCliaForMonthList", "getInactiveDOForDayList", "getInactiveDOForMonthList", "getInactiveResources", "Lcom/licapps/bmmis/data/model/inactive/InactiveRes;", "getLaunchStatus", "Lcom/licapps/bmmis/data/model/util/LaunchRes;", "getMABData", "Lcom/licapps/bmmis/data/model/mab/MABListRes;", "Lcom/licapps/bmmis/data/model/mab/MABReq;", "getNBForDay", "Lcom/licapps/bmmis/data/model/nbforday/NBForDayRes;", "getNBperformanceByA2B", "Lcom/licapps/bmmis/data/model/nbperformance/NBPerformanceRes;", "getNBperformanceByG", "getNBperformanceByV", "getNBperformanceMonthByA2B", "getNBperformanceMonthByG", "getNBperformanceMonthByV", "getNuaData", "Lcom/licapps/bmmis/data/model/nua/NuaRes;", "Lcom/licapps/bmmis/data/model/nua/NuaReq;", "getPersistenceData", "Lcom/licapps/bmmis/data/model/persistence/PersistenceRes;", "getPersistenceOnPremData", "getPlanPerfData", "Lcom/licapps/bmmis/data/model/planperf/PlanPerfRes;", "getProspCenturionsList", "Lcom/licapps/bmmis/data/model/prospectives/ProspectivesListRes;", "getProspMDRTCommList", "getProspectivesList", "getResBuildingData", "Lcom/licapps/bmmis/data/model/resbuilding/ResBuildingRes;", "getTopAgentsByFP", "Lcom/licapps/bmmis/data/model/topperformers/PerformersListRes;", "getTopAgentsByNOP", "getTopCLIAsByFP", "getTopCLIAsByNOP", "getTopDevByFP", "getTopDevByNOP", "getWishes", "Lcom/licapps/bmmis/data/model/WishesRes;", "login", "Lcom/licapps/bmmis/data/model/login/LoginRes;", "loginRequest", "Lcom/licapps/bmmis/data/model/login/LoginReq;", "app_debug"})
public final class AnandaRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.api.BMMisRemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.localdb.PlanDao localDataSource = null;
    
    @javax.inject.Inject()
    public AnandaRepository(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.BMMisRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.localdb.PlanDao localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.login.LoginRes>> login(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.login.LoginReq loginRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.WishesRes>> getWishes(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.util.LaunchRes>> getLaunchStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> getProspectivesList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> getProspMDRTCommList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> getProspCenturionsList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> getTopDevByNOP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> getTopDevByFP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> getTopAgentsByNOP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> getTopAgentsByFP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> getTopCLIAsByNOP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> getTopCLIAsByFP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> getNBperformanceByV(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> getNBperformanceByG(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> getNBperformanceByA2B(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> getNBperformanceMonthByG(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> getNBperformanceMonthByV(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> getNBperformanceMonthByA2B(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.resource.ResourceListRes>> getAvailableResource(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.boc.BOCListRes>> getBOCdata(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.channelwise.ChannelwiseNBRes>> getChannelWiseNB(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbforday.NBForDayRes>> getNBForDay(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.resbuilding.ResBuildingRes>> getResBuildingData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.ananda.AnandaRes>> getAnandaData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.mab.MABListRes>> getMABData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.mab.MABReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.activisation.ActivisationListRes>> getActivisationData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveRes>> getInactiveResources(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> getInactiveDOForDayList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> getInactiveDOForMonthList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> getInactiveCliaForDayList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> getInactiveCliaForMonthList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> getInactiveCLIAList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.claims.ClaimsRes>> getClaimsData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.planperf.PlanPerfRes>> getPlanPerfData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.persistence.PersistenceRes>> getPersistenceData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.persistence.PersistenceRes>> getPersistenceOnPremData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nua.NuaRes>> getNuaData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.nua.NuaReq request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.emhr.EmhrRes>> getEMHRData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.emhr.EmhrReq request) {
        return null;
    }
}