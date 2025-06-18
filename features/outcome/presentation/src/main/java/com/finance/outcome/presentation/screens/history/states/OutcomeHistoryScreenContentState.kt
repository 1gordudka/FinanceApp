package com.finance.outcome.presentation.screens.history.states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.GrayDivider
import com.finance.common.ui.components.TransactionCard
import com.finance.domain.transaction.Transaction
import com.finance.outcome.presentation.screens.history.components.InfoCard
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenState

@Composable
fun OutcomeHistoryScreenContentState(
    startDate: String,
    endDate: String,
    amount: String,
    currency: String,
    transactions: List<Transaction>,
    onTransactionClick: (Transaction) -> Unit
){

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
                name = it.name,
                amount = it.amount,
                currency = it.currency,
                time = it.time,
                emoji = it.emoji,
                comment = it.comment,
                onClick = {onTransactionClick(it)},
                modifier = Modifier
            )
            GrayDivider()
        }
    }
}