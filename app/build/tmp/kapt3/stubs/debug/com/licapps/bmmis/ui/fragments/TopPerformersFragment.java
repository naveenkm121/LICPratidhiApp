package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0017H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0016J\u001a\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00104\u001a\u00020\"H\u0002J\b\u00105\u001a\u00020\"H\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u0012H\u0002J\b\u00108\u001a\u00020\"H\u0002J\b\u00109\u001a\u00020\"H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\u0010\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/licapps/bmmis/ui/fragments/TopPerformersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;", "()V", "adapter", "Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter;", "apiRequest", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "<set-?>", "Lcom/licapps/bmmis/databinding/FragmentTopPerformersBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/FragmentTopPerformersBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/FragmentTopPerformersBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "isNOPSelected", "", "sortFPAsc", "sortNOPAsc", "topPerformersList", "Ljava/util/ArrayList;", "Lcom/licapps/bmmis/data/model/topperformers/Performer;", "type", "", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/TopPerformersViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/TopPerformersViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "whichRequest", "onClickedListItem", "", "case", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "menu", "Landroid/view/Menu;", "onViewCreated", "view", "setChipsGroup", "setOnClickHandle", "setProgressBar", "b", "setRadioButtons", "setupObservers", "setupRecyclerView", "sortResult", "sortFilter", "", "app_debug"})
public final class TopPerformersFragment extends androidx.fragment.app.Fragment implements com.licapps.bmmis.ui.adapters.TopPerformersListAdapter.CasesListItemListener {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.licapps.bmmis.ui.adapters.TopPerformersListAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.licapps.bmmis.data.model.topperformers.Performer> topPerformersList;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.model.prospectives.CommonReq apiRequest = null;
    private int whichRequest = 0;
    private int type = 0;
    private boolean sortFPAsc = true;
    private boolean sortNOPAsc = true;
    private boolean isNOPSelected = true;
    
    public TopPerformersFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.FragmentTopPerformersBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.FragmentTopPerformersBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.TopPerformersViewModel getViewModel() {
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
    
    private final void setChipsGroup() {
    }
    
    private final void setRadioButtons() {
    }
    
    private final void setOnClickHandle() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupObservers() {
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
    
    private final void sortResult(java.lang.String sortFilter) {
    }
    
    @java.lang.Override()
    public void onClickedListItem(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.topperformers.Performer p0_1523096) {
    }
    
    private final void setProgressBar(boolean b) {
    }
}