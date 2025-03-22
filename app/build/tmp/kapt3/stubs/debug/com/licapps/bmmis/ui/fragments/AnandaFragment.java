package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/licapps/bmmis/ui/fragments/AnandaFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;", "()V", "apiRequest", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "<set-?>", "Lcom/licapps/bmmis/databinding/FragmentAnandaBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/FragmentAnandaBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/FragmentAnandaBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/AnandaViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/AnandaViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "whichRequest", "", "onClickedListItem", "", "case", "Lcom/licapps/bmmis/data/model/topperformers/Performer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setData", "anandaRes", "Lcom/licapps/bmmis/data/model/ananda/AnandaItem;", "setInitialUI", "screenToShow", "", "setProgressBar", "b", "", "setRadioButtons", "setupObservers", "app_debug"})
public final class AnandaFragment extends androidx.fragment.app.Fragment implements com.licapps.bmmis.ui.adapters.TopPerformersListAdapter.CasesListItemListener {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.model.prospectives.CommonReq apiRequest = null;
    private int whichRequest = 1;
    
    public AnandaFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.FragmentAnandaBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.FragmentAnandaBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.AnandaViewModel getViewModel() {
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
    
    private final void setRadioButtons() {
    }
    
    private final void setInitialUI(java.lang.String screenToShow) {
    }
    
    private final void setupObservers() {
    }
    
    private final void setData(com.licapps.bmmis.data.model.ananda.AnandaItem anandaRes) {
    }
    
    @java.lang.Override()
    public void onClickedListItem(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.topperformers.Performer p0_1523096) {
    }
    
    private final void setProgressBar(boolean b) {
    }
}