package com.finance.splash

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun AnimatedMoneyParticle(particle: EmojiParticle) {
    val x = remember { Animatable(particle.startX) }
    val y = remember { Animatable(particle.startY) }
    val rotation = remember { Animatable(0f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            alpha.animateTo(1f, animationSpec = tween(300))
        }
        launch {
            x.animateTo(particle.endX, tween(particle.durationMillis))
        }
        launch {
            y.animateTo(particle.endY, tween(particle.durationMillis))
        }
        launch {
            rotation.animateTo(360f * particle.rotationSpeed, tween(particle.durationMillis))
        }
    }

    Text(
        text = particle.emoji,
        fontSize = (32 * particle.scale).sp,
        modifier = Modifier
            .graphicsLayer {
                translationX = x.value
                translationY = y.value
                rotationZ = rotation.value
            }
    )
}



data class EmojiState(
    val startX: Float = (-200..200).random().toFloat(),
    val endX: Float = (-200..200).random().toFloat(),
    val startY: Float = (300..600).random().toFloat(),
    val endY: Float = (-500..-300).random().toFloat(),
    val duration: Int = (800..1600).random()
)

data class EmojiParticle(
    val emoji: String,
    val startX: Float,
    val endX: Float,
    val startY: Float,
    val endY: Float,
    val rotationSpeed: Float,
    val scale: Float,
    val durationMillis: Int,
)
