package com.licapps.bmmis.ui.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\'H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u00132\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001fH\u0002J\b\u00105\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/licapps/bmmis/ui/fragments/WishesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/licapps/bmmis/ui/adapters/WishesAdapter$WishItemListener;", "Lcom/licapps/bmmis/ui/adapters/WishesTagsRVAdapter$WishTagsItemListener;", "()V", "adapter", "Lcom/licapps/bmmis/ui/adapters/WishesAdapter;", "apiRequest", "Lcom/licapps/bmmis/data/model/prospectives/CommonReq;", "<set-?>", "Lcom/licapps/bmmis/databinding/WishesFragmentBinding;", "binding", "getBinding", "()Lcom/licapps/bmmis/databinding/WishesFragmentBinding;", "setBinding", "(Lcom/licapps/bmmis/databinding/WishesFragmentBinding;)V", "binding$delegate", "Lcom/licapps/bmmis/utils/AutoClearedValue;", "customAlertDialogView", "Landroid/view/View;", "materialAlertDialogBuilder", "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;", "viewModel", "Lcom/licapps/bmmis/ui/viewmodels/WishesViewModel;", "getViewModel", "()Lcom/licapps/bmmis/ui/viewmodels/WishesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "wishesTagsRVAdapter", "Lcom/licapps/bmmis/ui/adapters/WishesTagsRVAdapter;", "onClickedWish", "", "wish", "Lcom/licapps/bmmis/data/model/Wish;", "x", "", "y", "onClickedWishTag", "wishTag", "Lcom/licapps/bmmis/data/model/WishTag;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setProgressBar", "b", "", "setupObservers", "setupRecyclerView", "app_debug"})
public final class WishesFragment extends androidx.fragment.app.Fragment implements com.licapps.bmmis.ui.adapters.WishesAdapter.WishItemListener, com.licapps.bmmis.ui.adapters.WishesTagsRVAdapter.WishTagsItemListener {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.utils.AutoClearedValue binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.licapps.bmmis.ui.adapters.WishesAdapter adapter;
    private com.licapps.bmmis.ui.adapters.WishesTagsRVAdapter wishesTagsRVAdapter;
    private android.view.View customAlertDialogView;
    private com.google.android.material.dialog.MaterialAlertDialogBuilder materialAlertDialogBuilder;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.data.model.prospectives.CommonReq apiRequest = null;
    
    public WishesFragment() {
        super();
    }
    
    private final com.licapps.bmmis.databinding.WishesFragmentBinding getBinding() {
        return null;
    }
    
    private final void setBinding(com.licapps.bmmis.databinding.WishesFragmentBinding p0) {
    }
    
    private final com.licapps.bmmis.ui.viewmodels.WishesViewModel getViewModel() {
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
    public void onClickedWish(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.Wish wish, float x, float y) {
    }
    
    @java.lang.Override()
    public void onClickedWishTag(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.WishTag wishTag) {
    }
    
    private final void setProgressBar(boolean b) {
    }
}