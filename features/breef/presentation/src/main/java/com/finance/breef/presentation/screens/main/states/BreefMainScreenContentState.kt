package com.finance.breef.presentation.screens.main.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.finance.breef.presentation.screens.main.components.BalanceCard
import com.finance.breef.presentation.screens.main.components.CurrencyChooser
import com.finance.breef.presentation.screens.main.state_hoisting.BreefMainScreenAction
import com.finance.common.ui.components.GrayDivider

@Composable
fun BreefMainScreenContentState(
    balance: String,
    currency: String,
    onAction: (BreefMainScreenAction) -> Unit
) {

    BalanceCard(balance, currency) { }
    GrayDivider()
    CurrencyChooser(currency) { }

}