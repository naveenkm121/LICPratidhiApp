package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0007J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/TopPerformersViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "mContext", "Landroid/content/Context;", "itemBinding", "Lcom/licapps/bmmis/databinding/ItemPerformersBinding;", "listener", "Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;", "(Landroid/content/Context;Lcom/licapps/bmmis/databinding/ItemPerformersBinding;Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;)V", "avatarColorCache", "Ljava/util/HashMap;", "", "avatarColors", "", "", "case", "Lcom/licapps/bmmis/data/model/topperformers/Performer;", "bind", "", "item", "onClick", "v", "Landroid/view/View;", "app_debug"})
public final class TopPerformersViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.databinding.ItemPerformersBinding itemBinding = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.TopPerformersListAdapter.CasesListItemListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> avatarColors = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.HashMap<java.lang.Integer, java.lang.Integer> avatarColorCache = null;
    
    public TopPerformersViewHolder(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.databinding.ItemPerformersBinding itemBinding, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.TopPerformersListAdapter.CasesListItemListener listener) {
        super(null);
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public final void bind(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.topperformers.Performer item) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
}