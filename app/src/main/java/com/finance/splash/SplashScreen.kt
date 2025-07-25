package com.finance.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.finance.common.ui.theme.FinanceAppTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun SplashScreen(
    onNext: () -> Unit
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Url("https://assets7.lottiefiles.com/packages/lf20_M9p23l.json")
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = 1,
        speed = 1f
    )

    LaunchedEffect(progress) {
        if (progress >= 1f) {
            delay(500) // Small delay after animation completes
            onNext()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FinanceAppTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {
        if (composition != null) {
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.fillMaxSize(0.6f)
            )
        } else {
            // Fallback to original animation if Lottie fails to load
            val emojis = remember { generateParticles() }
            emojis.forEach { particle ->
                AnimatedMoneyParticle(particle)
            }
            
            Text(
                text = "💰",
                fontSize = 54.sp,
                modifier = Modifier.scale(1.8f)
            )
        }
    }
}


private fun generateParticles(): List<EmojiParticle> {
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
