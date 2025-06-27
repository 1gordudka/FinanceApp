package com.finance.common.ui.theme


import androidx.compose.ui.graphics.Color


data class FinanceAppColors(
    val primary: Color = Color(0xFF2AE881),
    val lightPrimary: Color = Color(0xFFD4FAE6),
    val background: Color = Color.White,
    val surface: Color = Color(0xFFECE6F0),
    val onSurface: Color = Color(0xFF49454F),
    val onPrimary: Color = Color(0xFF1D1B20),
    val surfaceContainer: Color = Color(0xFFF3EDF7),
    val lightGray: Color = Color(0xFFC4BFC7)
)


object FinanceAppTheme {

    val colors: FinanceAppColors = FinanceAppColors()
}
