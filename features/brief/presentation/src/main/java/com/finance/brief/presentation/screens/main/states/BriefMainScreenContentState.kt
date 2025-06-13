package com.finance.brief.presentation.screens.main.states

import androidx.compose.runtime.Composable
import com.finance.brief.presentation.screens.main.components.BalanceCard
import com.finance.brief.presentation.screens.main.components.CurrencyChooser
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.common.ui.components.GrayDivider

@Composable
fun BriefMainScreenContentState(
    balance: String,
    currency: String,
    onAction: (BriefMainScreenAction) -> Unit
) {

    BalanceCard(balance, currency) { }
    GrayDivider()
    CurrencyChooser(currency) { }

}