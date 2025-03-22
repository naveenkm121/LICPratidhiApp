package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/HomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/licapps/bmmis/ui/adapters/HomeAdapter$ViewHolder;", "itemList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "listener", "Lcom/licapps/bmmis/ui/adapters/HomeAdapter$CardItemListener;", "(Ljava/util/ArrayList;Lcom/licapps/bmmis/ui/adapters/HomeAdapter$CardItemListener;)V", "getItemList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CardItemListener", "ViewHolder", "app_debug"})
public final class HomeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.licapps.bmmis.ui.adapters.HomeAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> itemList = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.HomeAdapter.CardItemListener listener = null;
    
    public HomeAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> itemList, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.HomeAdapter.CardItemListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getItemList() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.licapps.bmmis.ui.adapters.HomeAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.HomeAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/HomeAdapter$CardItemListener;", "", "onClickedCard", "", "cardName", "", "app_debug"})
    public static abstract interface CardItemListener {
        
        public abstract void onClickedCard(@org.jetbrains.annotations.NotNull()
        java.lang.String cardName);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/HomeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemBinding", "Lcom/licapps/bmmis/databinding/HomeRowItemBinding;", "context", "Landroid/content/Context;", "(Lcom/licapps/bmmis/databinding/HomeRowItemBinding;Landroid/content/Context;)V", "bindItems", "", "itemName", "", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.licapps.bmmis.databinding.HomeRowItemBinding itemBinding = null;
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.databinding.HomeRowItemBinding itemBinding, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super(null);
        }
        
        @android.annotation.SuppressLint(value = {"ResourceAsColor"})
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        java.lang.String itemName) {
        }
    }
}