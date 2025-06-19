package com.finance.income.presentation.screens.history.states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.GrayDivider
import com.finance.common.ui.components.TransactionCard
import com.finance.domain.transaction.Transaction
import com.finance.income.presentation.screens.history.components.InfoCard

@Composable
fun IncomeHistoryScreenContentState(
    startDate: String,
    endDate: String,
    amount: String,
    currency: String,
    transactions: List<Transaction>,
    onTransactionClick: (Transaction) -> Unit
) {
    InfoCard("Начало", startDate)
    GrayDivider()
    InfoCard("Конец", endDate)
    GrayDivider()
    InfoCard("Сумма", "$amount $currency")

    LazyColumn {

        items(
            transactions, key = {it.id}
        ){
            TransactionCard(
                name = it.category.name,
                amount = it.amount,
                currency = it.account.currency,
                time = it.createdAt,
                emoji = it.category.emoji,
                comment = it.comment,
                onClick = {onTransactionClick(it)},
                modifier = Modifier
            )
            GrayDivider()
        }
    }
} 