package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010\'\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006("}, d2 = {"Lcom/licapps/bmmis/ui/fragments/MABFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/licapps/bmmis/ui/adapters/MABListAdapter;", "apiRequest", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "<set-?>", "Lcom/licapps/bmmis/databinding/FragmentMabBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/FragmentMabBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/FragmentMabBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "bocItemList", "Ljava/util/ArrayList;", "Lcom/licapps/bmmis/data/model/mab/MABItem;", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/MABViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/MABViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "navigateToMABDetails", "", "month", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setOnClickListeners", "app_debug"})
public final class MABFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.licapps.bmmis.ui.adapters.MABListAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.licapps.bmmis.data.model.mab.MABItem> bocItemList;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.model.prospectives.CommonReq apiRequest = null;
    
    public MABFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.FragmentMabBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.FragmentMabBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.MABViewModel getViewModel() {
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
    
    private final void setOnClickListeners() {
    }
    
    private final void navigateToMABDetails(java.lang.String month) {
    }
}