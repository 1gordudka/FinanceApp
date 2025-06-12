package com.finance.income.domain.models


sealed class IncomeCategoryListItem{

    data class IncomeCategoryLead(
        val categoryName: String,
        val formattedAmount: String,
        val currency: String,
    ) : IncomeCategoryListItem()


}
