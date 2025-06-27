package com.finance.common.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class FinanceAppPaddings(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val standard: Dp = 12.dp,
    val medium: Dp = 16.dp,
    val mediumLarge: Dp = 18.dp,
    val large: Dp = 22.dp,
    val extraLarge: Dp = 26.dp
)

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



object FinanceAppTheme{

    val paddings: FinanceAppPaddings = FinanceAppPaddings()

    val colors: FinanceAppColors = FinanceAppColors()
}
