package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J$\u0010\u0016\u001a\u00020\f\"\u0004\b\u0000\u0010\u00172\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u0002H\u00170\tj\b\u0012\u0004\u0012\u0002H\u0017`\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/ResBuildingListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/licapps/bmmis/ui/adapters/ResBuildingViewHolder;", "forWhom", "", "listener", "Lcom/licapps/bmmis/ui/adapters/ResBuildingListAdapter$ResBuildItemListener;", "(Ljava/lang/String;Lcom/licapps/bmmis/ui/adapters/ResBuildingListAdapter$ResBuildItemListener;)V", "items", "Ljava/util/ArrayList;", "", "clear", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "T", "Lkotlin/collections/ArrayList;", "ResBuildItemListener", "app_debug"})
public final class ResBuildingListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.licapps.bmmis.ui.adapters.ResBuildingViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String forWhom = null;
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.ResBuildingListAdapter.ResBuildItemListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.Object> items = null;
    
    public ResBuildingListAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String forWhom, @org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.ResBuildingListAdapter.ResBuildItemListener listener) {
        super();
    }
    
    public final <T extends java.lang.Object>void setItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> items) {
    }
    
    public final void clear() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.licapps.bmmis.ui.adapters.ResBuildingViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.ResBuildingViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H&\u00a8\u0006\u0006"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/ResBuildingListAdapter$ResBuildItemListener;", "", "onClickedCard", "", "cardName", "requestType", "app_debug"})
    public static abstract interface ResBuildItemListener {
        
        public abstract void onClickedCard(@org.jetbrains.annotations.NotNull()
        java.lang.Object cardName);
        
        public abstract void onClickedCard(@org.jetbrains.annotations.NotNull()
        java.lang.Object cardName, @org.jetbrains.annotations.NotNull()
        java.lang.Object requestType);
    }
}