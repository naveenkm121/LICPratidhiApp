package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/WishesTagsRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/licapps/bmmis/ui/adapters/WishTagsViewHolder;", "listener", "Lcom/licapps/bmmis/ui/adapters/WishesTagsRVAdapter$WishTagsItemListener;", "(Lcom/licapps/bmmis/ui/adapters/WishesTagsRVAdapter$WishTagsItemListener;)V", "items", "", "Lcom/licapps/bmmis/data/model/WishTag;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "WishTagsItemListener", "app_debug"})
public final class WishesTagsRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.licapps.bmmis.ui.adapters.WishTagsViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.WishesTagsRVAdapter.WishTagsItemListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.licapps.bmmis.data.model.WishTag> items;
    
    public WishesTagsRVAdapter(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.WishesTagsRVAdapter.WishTagsItemListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.WishTag> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.WishTag> p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.licapps.bmmis.ui.adapters.WishTagsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.WishTagsViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/WishesTagsRVAdapter$WishTagsItemListener;", "", "onClickedWishTag", "", "wishTag", "Lcom/licapps/bmmis/data/model/WishTag;", "app_debug"})
    public static abstract interface WishTagsItemListener {
        
        public abstract void onClickedWishTag(@org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.data.model.WishTag wishTag);
    }
}