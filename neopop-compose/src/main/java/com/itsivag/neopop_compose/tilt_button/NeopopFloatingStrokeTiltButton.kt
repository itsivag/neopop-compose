package com.itsivag.neopop_compose.tilt_button

import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.itsivag.neopop_compose.theme.StrokeGreen
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NeopopFloatingStrokeTiltButton(
    text: String, onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val height = 150f
    val depth = height + 30f
    val angle = 75f
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var isClicked by remember {
        mutableStateOf(false)
    }

    // Combined interaction state
    val isInteracting = isPressed || isClicked

    // Remember last animation position to avoid jumps
    var lastAnimatedYPosition by remember { mutableFloatStateOf(5f) }
    var shouldPauseAnimation by remember { mutableStateOf(false) }

    val infiniteTransition = rememberInfiniteTransition(label = "floatingTransition")
    val floatingAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "floatingAnimation"
    )

    if (!shouldPauseAnimation) {
        lastAnimatedYPosition = floatingAnimation
    }

    LaunchedEffect(isInteracting) {
        if (isInteracting) {
            shouldPauseAnimation = true
            delay(5000)
            if (!isPressed && !isClicked) {
                shouldPauseAnimation = false
            }
        } else {
            shouldPauseAnimation = false
        }
    }

    val animatedY = if (!shouldPauseAnimation) floatingAnimation else lastAnimatedYPosition

    val shimmerOffset by infiniteTransition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerAnimation"
    )

    val pressOffsetAnimation by animateFloatAsState(
        targetValue = if (isInteracting) 12f else 0f,
        animationSpec = tween(
            durationMillis = 50,
            easing = EaseInOutBounce
        ),
        label = "pressAnimation"
    )

    Box(
        modifier = modifier
            .wrapContentHeight()
            .height((height / 2).dp)
            .fillMaxWidth()
            .clickable(interactionSource, null) {
                isClicked = true
                onClick()
                MainScope().launch {
                    delay(50)
                    isClicked = false
                }
            }
            // Use separate offset modifiers to help avoid interference
            .offset(y = animatedY.dp)
            .offset(y = pressOffsetAnimation.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            Modifier
                .fillMaxSize()
        ) {
            // ...rest of canvas code remains the same...
            val path = Path().apply {
                moveTo(angle, 0f)
                lineTo(size.width - angle, 0f)
                lineTo(size.width, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path = path, color = StrokeGreen, style = Stroke(width = 2f))
            clipPath(path) {
                val rectWidth = 125f
                val smallerRectWidth = 75f
                val gap = 25f
                val xPosition = shimmerOffset % (size.width + rectWidth + gap) - rectWidth - gap
                val progress = (xPosition + rectWidth + gap) / (size.width + rectWidth + gap)
                val slantAngle = lerp(-angle * 2f, angle * 2f, progress)
                fun drawSlantedRect(startX: Float, width: Float, color: Color) {
                    val slantedRectPath = Path().apply {
                        val topLeftX = startX
                        val topRightX = startX + width
                        val bottomLeftX = topLeftX + slantAngle
                        val bottomRightX = topRightX + slantAngle
                        moveTo(topLeftX, 0f)
                        lineTo(topRightX, 0f)
                        lineTo(bottomRightX, height)
                        lineTo(bottomLeftX, height)
                        close()
                    }
                    drawPath(
                        path = slantedRectPath,
                        color = color,
                        blendMode = BlendMode.SrcAtop
                    )
                }
                drawSlantedRect(xPosition, smallerRectWidth, White)
                drawSlantedRect(xPosition + smallerRectWidth + gap, rectWidth, White)
            }
            drawPath(path = Path().apply {
                moveTo(0f, height)
                lineTo(20f, depth)
                lineTo(size.width - 20, depth)
                lineTo(size.width, height)
                close()
            }, color = StrokeGreen.copy(alpha = 0.5f))
        }

        Text(
            text,
            color = White,
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .offset(y = (-10).dp)
                .graphicsLayer {
                    rotationX = 20f
                    cameraDistance = 8 * density
                }
        )
    }
}
