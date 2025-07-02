package com.finance.brief.presentation.screens.main.state_hoisting

import com.finance.brief.domain.models.Balance

sealed class BriefMainScreenState {

    data class Content(
        val balance: Balance,
    ) : BriefMainScreenState()

    data class Update(
        val balance: Balance
    ) : BriefMainScreenState()

    data object Loading : BriefMainScreenState()

    data object Empty : BriefMainScreenState()

    data object Error : BriefMainScreenState()
}
