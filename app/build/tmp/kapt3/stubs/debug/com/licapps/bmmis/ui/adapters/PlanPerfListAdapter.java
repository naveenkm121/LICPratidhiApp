package com.licapps.bmmis.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u000e2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/PlanPerfListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/licapps/bmmis/ui/adapters/PlanPerfListViewHolder;", "listener", "Lcom/licapps/bmmis/ui/adapters/PlanPerfListAdapter$CasesListItemListener;", "screenToShow", "", "(Lcom/licapps/bmmis/ui/adapters/PlanPerfListAdapter$CasesListItemListener;Ljava/lang/String;)V", "items", "Ljava/util/ArrayList;", "Lcom/licapps/bmmis/data/model/planperf/PlanPerfItem;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "Lkotlin/collections/ArrayList;", "CasesListItemListener", "app_debug"})
public final class PlanPerfListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.licapps.bmmis.ui.adapters.PlanPerfListViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.licapps.bmmis.ui.adapters.PlanPerfListAdapter.CasesListItemListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String screenToShow = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.licapps.bmmis.data.model.planperf.PlanPerfItem> items = null;
    
    public PlanPerfListAdapter(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.PlanPerfListAdapter.CasesListItemListener listener, @org.jetbrains.annotations.NotNull()
    java.lang.String screenToShow) {
        super();
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.licapps.bmmis.data.model.planperf.PlanPerfItem> items) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.licapps.bmmis.ui.adapters.PlanPerfListViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.licapps.bmmis.ui.adapters.PlanPerfListViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/licapps/bmmis/ui/adapters/PlanPerfListAdapter$CasesListItemListener;", "", "onClickedListItem", "", "case", "Lcom/licapps/bmmis/data/model/planperf/PlanPerfItem;", "app_debug"})
    public static abstract interface CasesListItemListener {
        
        public abstract void onClickedListItem(@org.jetbrains.annotations.NotNull()
        com.licapps.bmmis.data.model.planperf.PlanPerfItem p0_1523096);
    }
}