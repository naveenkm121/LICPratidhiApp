package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/WishViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemBinding", "Lcom/licapps/bmmis/databinding/ItemWishRvBinding;", "listener", "Lcom/licapps/bmmis/ui/adapters/WishesAdapter$WishItemListener;", "(Lcom/licapps/bmmis/databinding/ItemWishRvBinding;Lcom/licapps/bmmis/ui/adapters/WishesAdapter$WishItemListener;)V", "wish", "Lcom/licapps/bmmis/data/model/Wish;", "bind", "", "item", "onClick", "v", "Landroid/view/View;", "app_debug"})
public final class WishViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.databinding.ItemWishRvBinding itemBinding = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.WishesAdapter.WishItemListener listener = null;
    private com.licapps.bmmis.data.model.Wish wish;
    
    public WishViewHolder(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.databinding.ItemWishRvBinding itemBinding, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.WishesAdapter.WishItemListener listener) {
        super(null);
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public final void bind(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.data.model.Wish item) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
}