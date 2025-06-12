package com.finance.breef.presentation.screens.main.state_hoisting

import com.finance.breef.domain.models.Balance

sealed class BreefMainScreenState {

    data class Content(
        val balance: Balance
    ) : BreefMainScreenState()

    data object Loading : BreefMainScreenState()

    data object Empty : BreefMainScreenState()

    data object Error : BreefMainScreenState()
}
