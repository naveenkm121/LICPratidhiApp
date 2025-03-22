package com.licapps.bmmis.data.model.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00ab\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0019J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u00d9\u0002\u0010E\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010I\u001a\u00020JH\u00d6\u0001J\t\u0010K\u001a\u00020LH\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001bR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b\u00a8\u0006M"}, d2 = {"Lcom/licapps/bmmis/data/model/util/AppData;", "", "user_type", "", "Lcom/licapps/bmmis/data/model/SpinnerItemModel;", "qualifications", "age_proofs", "address_proofs", "id_proofs", "marital_status", "occupation", "nature_of_duties", "source_of_income", "obj_of_insurance", "income_proof", "tax_brackets", "relationships", "state_Of_health", "terms_of_acceptance", "medical_options", "policy_status", "installment_mode", "death_settlement_period", "header_progress", "bank_account_type", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAddress_proofs", "()Ljava/util/List;", "getAge_proofs", "getBank_account_type", "getDeath_settlement_period", "getHeader_progress", "getId_proofs", "getIncome_proof", "getInstallment_mode", "getMarital_status", "getMedical_options", "getNature_of_duties", "getObj_of_insurance", "getOccupation", "getPolicy_status", "getQualifications", "getRelationships", "getSource_of_income", "getState_Of_health", "getTax_brackets", "getTerms_of_acceptance", "getUser_type", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class AppData {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> user_type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> qualifications = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> age_proofs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> address_proofs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> id_proofs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> marital_status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> occupation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> nature_of_duties = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> source_of_income = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> obj_of_insurance = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> income_proof = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> tax_brackets = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> relationships = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> state_Of_health = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> terms_of_acceptance = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> medical_options = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> policy_status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> installment_mode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> death_settlement_period = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> header_progress = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> bank_account_type = null;
    
    public AppData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> user_type, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> qualifications, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> age_proofs, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> address_proofs, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> id_proofs, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> marital_status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> occupation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> nature_of_duties, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> source_of_income, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> obj_of_insurance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> income_proof, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> tax_brackets, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> relationships, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> state_Of_health, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> terms_of_acceptance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> medical_options, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> policy_status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> installment_mode, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> death_settlement_period, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> header_progress, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> bank_account_type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getUser_type() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getQualifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getAge_proofs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getAddress_proofs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getId_proofs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getMarital_status() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getOccupation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getNature_of_duties() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getSource_of_income() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getObj_of_insurance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getIncome_proof() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getTax_brackets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getRelationships() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getState_Of_health() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getTerms_of_acceptance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getMedical_options() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getPolicy_status() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getInstallment_mode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getDeath_settlement_period() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getHeader_progress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> getBank_account_type() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.licapps.bmmis.data.model.util.AppData copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> user_type, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> qualifications, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> age_proofs, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> address_proofs, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> id_proofs, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> marital_status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> occupation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> nature_of_duties, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> source_of_income, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> obj_of_insurance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> income_proof, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> tax_brackets, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> relationships, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> state_Of_health, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> terms_of_acceptance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> medical_options, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> policy_status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> installment_mode, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> death_settlement_period, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> header_progress, @org.jetbrains.annotations.NotNull()
    java.util.List<com.licapps.bmmis.data.model.SpinnerItemModel> bank_account_type) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}