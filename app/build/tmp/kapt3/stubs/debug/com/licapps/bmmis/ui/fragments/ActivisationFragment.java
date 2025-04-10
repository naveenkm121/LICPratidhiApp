package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u001eH\u0002J\b\u00108\u001a\u00020\u001eH\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006<"}, d2 = {"Lcom/licapps/bmmis/ui/fragments/ActivisationFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/licapps/bmmis/ui/adapters/ResBuildingListAdapter$ResBuildItemListener;", "()V", "activisationList", "Ljava/util/ArrayList;", "Lcom/licapps/bmmis/data/model/activisation/ActivisationItem;", "adapter", "Lcom/licapps/bmmis/ui/adapters/ResBuildingListAdapter;", "apiRequest", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "<set-?>", "Lcom/licapps/bmmis/databinding/FragmentResBuildingBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/FragmentResBuildingBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/FragmentResBuildingBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "sortDaysAsc", "", "sortMonthAsc", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/ActivisationViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/ActivisationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addTotalItem", "", "onClickedCard", "cardName", "", "requestType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "menu", "Landroid/view/Menu;", "onViewCreated", "view", "setInitialUI", "setOnClickFun", "setProgressBar", "b", "setupObservers", "setupRecyclerView", "sortResult", "sortFilter", "", "app_debug"})
public final class ActivisationFragment extends androidx.fragment.app.Fragment implements com.licapps.bmmis.ui.adapters.ResBuildingListAdapter.ResBuildItemListener {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.licapps.bmmis.ui.adapters.ResBuildingListAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.licapps.bmmis.data.model.activisation.ActivisationItem> activisationList;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.model.prospectives.CommonReq apiRequest = null;
    private boolean sortDaysAsc = true;
    private boolean sortMonthAsc = true;
    
    public ActivisationFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.FragmentResBuildingBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.FragmentResBuildingBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.ActivisationViewModel getViewModel() {
        return null;
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
    
    private final void setupRecyclerView() {
    }
    
    private final void setOnClickFun() {
    }
    
    private final void setupObservers() {
    }
    
    private final void addTotalItem() {
    }
    
    private final void sortResult(java.lang.String sortFilter) {
    }
    
    @java.lang.Override()
    public void onPrepareOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setProgressBar(boolean b) {
    }
    
    @java.lang.Override()
    public void onClickedCard(@org.jetbrains.annotations.NotNull()
    java.lang.Object cardName) {
    }
    
    @java.lang.Override()
    public void onClickedCard(@org.jetbrains.annotations.NotNull()
    java.lang.Object cardName, @org.jetbrains.annotations.NotNull()
    java.lang.Object requestType) {
    }
}