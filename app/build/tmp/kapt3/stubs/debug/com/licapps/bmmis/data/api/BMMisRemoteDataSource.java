package com.licapps.bmmis.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\b\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0006H\u0086@\u00a2\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00062\u0006\u0010\b\u001a\u00020(H\u0086@\u00a2\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00062\u0006\u0010\b\u001a\u000205H\u0086@\u00a2\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00062\u0006\u0010K\u001a\u00020LH\u0086@\u00a2\u0006\u0002\u0010MR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/licapps/bmmis/data/api/BMMisRemoteDataSource;", "Lcom/licapps/bmmis/data/api/BaseDataSource;", "anandaServices", "Lcom/licapps/bmmis/data/api/AnandaServices;", "(Lcom/licapps/bmmis/data/api/AnandaServices;)V", "getActivisationData", "Lcom/licapps/bmmis/utils/Resource;", "Lcom/licapps/bmmis/data/model/activisation/ActivisationListRes;", "request", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "(Lcom/licapps/bmmis/data/model/prospectives/CommonReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWishes", "Lcom/licapps/bmmis/data/model/WishesRes;", "getAnandaData", "Lcom/licapps/bmmis/data/model/ananda/AnandaRes;", "getAvailableResource", "Lcom/licapps/bmmis/data/model/resource/ResourceListRes;", "getBOCdata", "Lcom/licapps/bmmis/data/model/boc/BOCListRes;", "getChannelWiseNB", "Lcom/licapps/bmmis/data/model/channelwise/ChannelwiseNBRes;", "getClaimsData", "Lcom/licapps/bmmis/data/model/claims/ClaimsRes;", "getEMHRData", "Lcom/licapps/bmmis/data/model/emhr/EmhrRes;", "Lcom/licapps/bmmis/data/model/emhr/EmhrReq;", "(Lcom/licapps/bmmis/data/model/emhr/EmhrReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInactiveCLIAList", "Lcom/licapps/bmmis/data/model/inactive/InactiveDORes;", "getInactiveCliaForDayList", "getInactiveCliaForMonthList", "getInactiveDOForDayList", "getInactiveDOForMonthList", "getInactiveResources", "Lcom/licapps/bmmis/data/model/inactive/InactiveRes;", "getLaunchStatus", "Lcom/licapps/bmmis/data/model/util/LaunchRes;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMABData", "Lcom/licapps/bmmis/data/model/mab/MABListRes;", "Lcom/licapps/bmmis/data/model/mab/MABReq;", "(Lcom/licapps/bmmis/data/model/mab/MABReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNBForDay", "Lcom/licapps/bmmis/data/model/nbforday/NBForDayRes;", "getNBperformanceByA2B", "Lcom/licapps/bmmis/data/model/nbperformance/NBPerformanceRes;", "getNBperformanceByG", "getNBperformanceByV", "getNBperformanceMonthByA2B", "getNBperformanceMonthByG", "getNBperformanceMonthByV", "getNuaData", "Lcom/licapps/bmmis/data/model/nua/NuaRes;", "Lcom/licapps/bmmis/data/model/nua/NuaReq;", "(Lcom/licapps/bmmis/data/model/nua/NuaReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersistenceData", "Lcom/licapps/bmmis/data/model/persistence/PersistenceRes;", "getPersistenceOnPremData", "getPlanPerfData", "Lcom/licapps/bmmis/data/model/planperf/PlanPerfRes;", "getProspCenturionsList", "Lcom/licapps/bmmis/data/model/prospectives/ProspectivesListRes;", "getProspMDRTCommList", "getProspectivesList", "getResBuildingData", "Lcom/licapps/bmmis/data/model/resbuilding/ResBuildingRes;", "getTopAgentsByFP", "Lcom/licapps/bmmis/data/model/topperformers/PerformersListRes;", "getTopAgentsByNOP", "getTopCLIAsByFP", "getTopCLIAsByNOP", "getTopDevByFP", "getTopDevByNOP", "login", "Lcom/licapps/bmmis/data/model/login/LoginRes;", "loginRequest", "Lcom/licapps/bmmis/data/model/login/LoginReq;", "(Lcom/licapps/bmmis/data/model/login/LoginReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class BMMisRemoteDataSource extends com.licapps.bmmis.data.api.BaseDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.api.AnandaServices anandaServices = null;
    
    @javax.inject.Inject()
    public BMMisRemoteDataSource(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.api.AnandaServices anandaServices) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.login.LoginReq loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.login.LoginRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllWishes(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.WishesRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProspectivesList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProspMDRTCommList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProspCenturionsList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopDevByNOP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopDevByFP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopAgentsByNOP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopAgentsByFP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopCLIAsByNOP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopCLIAsByFP(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBperformanceByV(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBperformanceByG(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBperformanceByA2B(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBperformanceMonthByG(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBperformanceMonthByV(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBperformanceMonthByA2B(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAvailableResource(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.resource.ResourceListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBOCdata(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.boc.BOCListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getChannelWiseNB(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.channelwise.ChannelwiseNBRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNBForDay(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nbforday.NBForDayRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getResBuildingData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.resbuilding.ResBuildingRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAnandaData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.ananda.AnandaRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMABData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.mab.MABReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.mab.MABListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getActivisationData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.activisation.ActivisationListRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInactiveResources(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInactiveDOForDayList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInactiveDOForMonthList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInactiveCliaForDayList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInactiveCliaForMonthList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInactiveCLIAList(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getClaimsData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.claims.ClaimsRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlanPerfData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.planperf.PlanPerfRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLaunchStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.util.LaunchRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPersistenceData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.persistence.PersistenceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPersistenceOnPremData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.persistence.PersistenceRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNuaData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.nua.NuaReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.nua.NuaRes>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEMHRData(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.emhr.EmhrReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.licapps.bmmis.utils.Resource<com.licapps.bmmis.data.model.emhr.EmhrRes>> $completion) {
        return null;
    }
}