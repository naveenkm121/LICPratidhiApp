package com.licapps.bmmis.data.model.util

import com.licapps.bmmis.data.model.SpinnerItemModel

data class AppDataInfo(
    val app_data: AppData
)

data class AppData(
    val user_type: List<SpinnerItemModel>,
    val qualifications: List<SpinnerItemModel>,
    val age_proofs: List<SpinnerItemModel>,
    val address_proofs: List<SpinnerItemModel>,
    val id_proofs: List<SpinnerItemModel>,
    val marital_status: List<SpinnerItemModel>,
    val occupation: List<SpinnerItemModel>,
    val nature_of_duties: List<SpinnerItemModel>,
    val source_of_income:List<SpinnerItemModel>,
    val obj_of_insurance:List<SpinnerItemModel>,
    val income_proof:List<SpinnerItemModel>,
    val tax_brackets:List<SpinnerItemModel>,
    val relationships:List<SpinnerItemModel>,
    val state_Of_health:List<SpinnerItemModel>,
    val terms_of_acceptance:List<SpinnerItemModel>,
    val medical_options:List<SpinnerItemModel>,
    val policy_status:List<SpinnerItemModel>,
    val installment_mode:List<SpinnerItemModel>,
    val death_settlement_period:List<SpinnerItemModel>,
    val header_progress:List<SpinnerItemModel>,
    val bank_account_type:List<SpinnerItemModel>,

)