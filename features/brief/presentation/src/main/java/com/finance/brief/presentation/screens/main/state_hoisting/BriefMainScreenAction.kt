package com.finance.brief.presentation.screens.main.state_hoisting

import com.finance.brief.domain.models.Balance

sealed class BriefMainScreenAction {

    data object OnScreenEntered : BriefMainScreenAction()

    data object OnEditButton : BriefMainScreenAction()

    data object OnExitEdit : BriefMainScreenAction()

    data class OnUpdateInfo(val balance: Balance) : BriefMainScreenAction()
}