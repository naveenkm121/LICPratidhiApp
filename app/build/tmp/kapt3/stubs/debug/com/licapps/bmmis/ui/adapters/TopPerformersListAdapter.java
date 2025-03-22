package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001e\u0010\u0014\u001a\u00020\n2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\u0015R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/licapps/bmmis/ui/adapters/TopPerformersViewHolder;", "listener", "Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;", "(Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;)V", "items", "Ljava/util/ArrayList;", "Lcom/licapps/bmmis/data/model/topperformers/Performer;", "clear", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "Lkotlin/collections/ArrayList;", "CasesListItemListener", "app_debug"})
public final class TopPerformersListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.licapps.bmmis.ui.adapters.TopPerformersViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.TopPerformersListAdapter.CasesListItemListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.licapps.bmmis.data.model.topperformers.Performer> items = null;
    
    public TopPerformersListAdapter(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.TopPerformersListAdapter.CasesListItemListener listener) {
        super();
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.licapps.bmmis.data.model.topperformers.Performer> items) {
    }
    
    public final void clear() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.licapps.bmmis.ui.adapters.TopPerformersViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.TopPerformersViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/TopPerformersListAdapter$CasesListItemListener;", "", "onClickedListItem", "", "case", "Lcom/licapps/bmmis/data/model/topperformers/Performer;", "app_debug"})
    public static abstract interface CasesListItemListener {
        
        public abstract void onClickedListItem(@org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.data.model.topperformers.Performer p0_1523096);
    }
}