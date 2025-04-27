package com.itsivag.neopop_compose.tilt_button
import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsivag.neopop_compose.theme.Black
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NeopopNonFloatingTiltButton(
    text: String, onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val height = 150f
    val depth = height + 30f
    val angle = 75f
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    // Add clicked state
    var isClicked by remember { mutableStateOf(false) }

    // Create a combined interaction state
    val isInteracting = isPressed || isClicked

    // Animate the press effect
    val pressOffsetAnimation by animateFloatAsState(
        targetValue = if (isInteracting) 10f else 0f,
        animationSpec = tween(
            durationMillis = 50,
            easing = EaseInOutBounce
        ),
        label = "pressAnimation"
    )

    // Animate the shadow visibility
    val shadowAlpha by animateFloatAsState(
        targetValue = if (isInteracting) 0f else 1f,
        animationSpec = tween(
            durationMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "shadowAlphaAnimation"
    )

    // Animate shadow height for top-to-bottom fade effect
    val shadowHeight by animateFloatAsState(
        targetValue = if (isInteracting) 0f else (depth - height),
        animationSpec = tween(
            durationMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "shadowHeightAnimation"
    )

    Box(
        modifier = modifier
            .wrapContentHeight()
            .height((height / 2).dp)
            .fillMaxWidth()
            .clickable(
                interactionSource,
                null,
                onClick = {
                    isClicked = true
                    onClick()
                    MainScope().launch {
                        delay(50)
                        isClicked = false
                    }
                }
            )
            .offset(y = pressOffsetAnimation.dp), // Use animated value
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            Modifier
                .fillMaxSize()
        ) {
            // Main button
            val path = Path().apply {
                moveTo(angle, 0f)
                lineTo(size.width - angle, 0f)
                lineTo(size.width, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path = path, color = White)

            // Animated shadow with vertical fade
            if (shadowAlpha > 0f && shadowHeight > 0f) {
                // Calculate the current shadow depth based on animation
                val currentShadowDepth = height + shadowHeight

                // Create shadow path with current height
                val shadowPath = Path().apply {
                    moveTo(0f, height)
                    lineTo(20f, currentShadowDepth)
                    lineTo(size.width - 20, currentShadowDepth)
                    lineTo(size.width, height)
                    close()
                }

                drawPath(
                    path = shadowPath,
                    color = White.copy(alpha = 0.8f * shadowAlpha)
                )
            }
        }

        Text(
            text,
            color = Black,
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