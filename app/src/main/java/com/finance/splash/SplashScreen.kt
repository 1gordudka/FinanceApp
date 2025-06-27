package com.finance.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.finance.common.ui.theme.FinanceAppTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun SplashScreen(
    onNext: () -> Unit
) {
    val emojis = remember { generateParticles() }

    LaunchedEffect(Unit) {
        delay(3000)
        onNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FinanceAppTheme.colors.primary)
    ) {
        emojis.forEach { particle ->
            AnimatedMoneyParticle(particle)
        }

        Text(
            text = "💰",
            fontSize = 54.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .scale(1.8f)
        )
    }
}


fun generateParticles(): List<EmojiParticle> {
    val screenWidth = 800f
    val screenHeight = 1800f
    val emojis = listOf("💸", "💰", "💵", "💲")

    return List(20) {
        EmojiParticle(
            emoji = emojis.random(),
            startX = (-100..screenWidth.toInt()).random().toFloat(),
            endX = (-100..screenWidth.toInt()).random().toFloat(),
            startY = (-300..-50).random().toFloat(),
            endY = screenHeight + (0..200).random(),
            rotationSpeed = Random.nextFloat() * 2f + 0.5f, // от 0.5 до 2.5
            scale = Random.nextFloat() * 0.6f + 0.8f,
            durationMillis = (1500..3000).random()
        )
    }
}
