package com.licapps.bmmis.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0005\u001a\u00020%H\u00a7@\u00a2\u0006\u0002\u0010&J\u001e\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00032\b\b\u0001\u0010\u0005\u001a\u000202H\u00a7@\u00a2\u0006\u0002\u00103J\u001e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010C\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00032\b\b\u0001\u0010H\u001a\u00020IH\u00a7@\u00a2\u0006\u0002\u0010J\u00a8\u0006K"}, d2 = {"Lcom/licapps/bmmis/data/api/AnandaServices;", "", "getActivisationData", "Lretrofit2/Response;", "Lcom/licapps/bmmis/data/model/activisation/ActivisationListRes;", "request", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "(Lcom/licapps/bmmis/data/model/prospectives/CommonReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWishes", "Lcom/licapps/bmmis/data/model/WishesRes;", "getAnandaData", "Lcom/licapps/bmmis/data/model/ananda/AnandaRes;", "getAvailableResource", "Lcom/licapps/bmmis/data/model/resource/ResourceListRes;", "getBOCdata", "Lcom/licapps/bmmis/data/model/boc/BOCListRes;", "getChannelWiseNB", "Lcom/licapps/bmmis/data/model/channelwise/ChannelwiseNBRes;", "getClaimsData", "Lcom/licapps/bmmis/data/model/claims/ClaimsRes;", "getEMHRData", "Lcom/licapps/bmmis/data/model/emhr/EmhrRes;", "Lcom/licapps/bmmis/data/model/emhr/EmhrReq;", "(Lcom/licapps/bmmis/data/model/emhr/EmhrReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInactiveCLIAList", "Lcom/licapps/bmmis/data/model/inactive/InactiveDORes;", "getInactiveCliaForDayList", "getInactiveCliaForMonthList", "getInactiveDOForDayList", "getInactiveDOForMonthList", "getInactiveResources", "Lcom/licapps/bmmis/data/model/inactive/InactiveRes;", "getLaunchStatus", "Lcom/licapps/bmmis/data/model/util/LaunchRes;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMABData", "Lcom/licapps/bmmis/data/model/mab/MABListRes;", "Lcom/licapps/bmmis/data/model/mab/MABReq;", "(Lcom/licapps/bmmis/data/model/mab/MABReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNBForDay", "Lcom/licapps/bmmis/data/model/nbforday/NBForDayRes;", "getNBperformanceByA2B", "Lcom/licapps/bmmis/data/model/nbperformance/NBPerformanceRes;", "getNBperformanceByG", "getNBperformanceByV", "getNBperformanceMonthByA2B", "getNBperformanceMonthByG", "getNBperformanceMonthByV", "getNuaData", "Lcom/licapps/bmmis/data/model/nua/NuaRes;", "Lcom/licapps/bmmis/data/model/nua/NuaReq;", "(Lcom/licapps/bmmis/data/model/nua/NuaReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersistenceData", "Lcom/licapps/bmmis/data/model/persistence/PersistenceRes;", "getPersistenceOnPremData", "getPlanPerfData", "Lcom/licapps/bmmis/data/model/planperf/PlanPerfRes;", "getProspCenturionsList", "Lcom/licapps/bmmis/data/model/prospectives/ProspectivesListRes;", "getProspMDRTCommList", "getProspectivesList", "getResBuildingData", "Lcom/licapps/bmmis/data/model/resbuilding/ResBuildingRes;", "getTopAgentsByFP", "Lcom/licapps/bmmis/data/model/topperformers/PerformersListRes;", "getTopAgentsByNOP", "getTopCLIAsByFP", "getTopCLIAsByNOP", "getTopDevByFP", "getTopDevByNOP", "login", "Lcom/licapps/bmmis/data/model/login/LoginRes;", "loginRequest", "Lcom/licapps/bmmis/data/model/login/LoginReq;", "(Lcom/licapps/bmmis/data/model/login/LoginReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AnandaServices {
    
    @retrofit2.http.POST(value = "newLogin")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.login.LoginReq loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.login.LoginRes>> $completion);
    
    @retrofit2.http.POST(value = "wishes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllWishes(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.WishesRes>> $completion);
    
    @retrofit2.http.GET(value = "launch")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLaunchStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.util.LaunchRes>> $completion);
    
    @retrofit2.http.POST(value = "MDRT")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProspectivesList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> $completion);
    
    @retrofit2.http.POST(value = "MDRTComm")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProspMDRTCommList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> $completion);
    
    @retrofit2.http.POST(value = "Centurion")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProspCenturionsList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.prospectives.ProspectivesListRes>> $completion);
    
    @retrofit2.http.POST(value = "TopPerfDevPol")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopDevByNOP(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion);
    
    @retrofit2.http.POST(value = "TopPerfDevFp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopDevByFP(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion);
    
    @retrofit2.http.POST(value = "TopPerfAgPol")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopAgentsByNOP(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion);
    
    @retrofit2.http.POST(value = "TopPerfAgFp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopAgentsByFP(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion);
    
    @retrofit2.http.POST(value = "TopPerfCLIPol")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopCLIAsByNOP(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion);
    
    @retrofit2.http.POST(value = "TopPerfCLIFp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopCLIAsByFP(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.topperformers.PerformersListRes>> $completion);
    
    @retrofit2.http.POST(value = "NBPerfUptoV")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBperformanceByV(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion);
    
    @retrofit2.http.POST(value = "NBPerfUptoG")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBperformanceByG(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion);
    
    @retrofit2.http.POST(value = "NBPerfUptoA2B")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBperformanceByA2B(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion);
    
    @retrofit2.http.POST(value = "NBPerfMonthG")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBperformanceMonthByG(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion);
    
    @retrofit2.http.POST(value = "NBPerfMonth")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBperformanceMonthByV(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion);
    
    @retrofit2.http.POST(value = "NBPerfMonthA2B")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBperformanceMonthByA2B(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes>> $completion);
    
    @retrofit2.http.POST(value = "Res")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAvailableResource(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.resource.ResourceListRes>> $completion);
    
    @retrofit2.http.POST(value = "BOC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBOCdata(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.boc.BOCListRes>> $completion);
    
    @retrofit2.http.POST(value = "ChannelWise")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getChannelWiseNB(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.channelwise.ChannelwiseNBRes>> $completion);
    
    @retrofit2.http.POST(value = "NBForDay")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNBForDay(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nbforday.NBForDayRes>> $completion);
    
    @retrofit2.http.POST(value = "ResBuild")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getResBuildingData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.resbuilding.ResBuildingRes>> $completion);
    
    @retrofit2.http.POST(value = "Ananda")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAnandaData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.ananda.AnandaRes>> $completion);
    
    @retrofit2.http.POST(value = "MAB")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMABData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.mab.MABReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.mab.MABListRes>> $completion);
    
    @retrofit2.http.POST(value = "Activisation")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActivisationData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.activisation.ActivisationListRes>> $completion);
    
    @retrofit2.http.POST(value = "Inactive")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInactiveResources(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.inactive.InactiveRes>> $completion);
    
    @retrofit2.http.POST(value = "InactDevDay")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInactiveDOForDayList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion);
    
    @retrofit2.http.POST(value = "InactDevMonth")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInactiveDOForMonthList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion);
    
    @retrofit2.http.POST(value = "InactCliaDay")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInactiveCliaForDayList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion);
    
    @retrofit2.http.POST(value = "InactCliaMonth")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInactiveCliaForMonthList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion);
    
    @retrofit2.http.POST(value = "Inactagclia")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInactiveCLIAList(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.inactive.InactiveDORes>> $completion);
    
    @retrofit2.http.POST(value = "Claims")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getClaimsData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.claims.ClaimsRes>> $completion);
    
    @retrofit2.http.POST(value = "Planwise")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlanPerfData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.planperf.PlanPerfRes>> $completion);
    
    @retrofit2.http.POST(value = "Persist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPersistenceData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.persistence.PersistenceRes>> $completion);
    
    @retrofit2.http.POST(value = "PersistPrem")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPersistenceOnPremData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.CommonReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.persistence.PersistenceRes>> $completion);
    
    @retrofit2.http.POST(value = "getRatingSheetDetails")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNuaData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.nua.NuaReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.nua.NuaRes>> $completion);
    
    @retrofit2.http.POST(value = "getEMHRPendingList")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEMHRData(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.emhr.EmhrReq request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.licapps.bmmis.data.model.emhr.EmhrRes>> $completion);
}