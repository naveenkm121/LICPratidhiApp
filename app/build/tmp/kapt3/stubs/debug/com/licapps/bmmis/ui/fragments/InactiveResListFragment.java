package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00060"}, d2 = {"Lcom/licapps/bmmis/ui/fragments/InactiveResListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/licapps/bmmis/ui/adapters/CasesListAdapter$CasesListItemListener;", "()V", "adapter", "Lcom/licapps/bmmis/ui/adapters/CasesListAdapter;", "apiRequest", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "<set-?>", "Lcom/licapps/bmmis/databinding/FragmentMabDetailsBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/FragmentMabDetailsBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/FragmentMabDetailsBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "inactiveList", "Ljava/util/ArrayList;", "Lcom/licapps/bmmis/data/model/inactive/InactiveDOCLIA;", "requestType", "", "screenToShow", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/InactiveResListViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/InactiveResListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onClickedListItem", "", "case", "Lcom/licapps/bmmis/data/model/prospectives/Prospective;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setProgressBar", "b", "", "setupObservers", "setupRecyclerView", "app_debug"})
public final class InactiveResListFragment extends androidx.fragment.app.Fragment implements com.licapps.bmmis.ui.adapters.CasesListAdapter.CasesListItemListener {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.licapps.bmmis.ui.adapters.CasesListAdapter adapter;
    private java.lang.String screenToShow;
    private java.lang.String requestType;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.licapps.bmmis.data.model.inactive.InactiveDOCLIA> inactiveList;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.model.prospectives.CommonReq apiRequest = null;
    
    public InactiveResListFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.FragmentMabDetailsBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.FragmentMabDetailsBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.InactiveResListViewModel getViewModel() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void setupObservers() {
    }
    
    @java.lang.Override()
    public void onClickedListItem(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.prospectives.Prospective p0_1523096) {
    }
    
    private final void setProgressBar(boolean b) {
    }
}