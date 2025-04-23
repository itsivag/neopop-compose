package com.itsivag.neopop_compose.tilt_button

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.itsivag.neopop_compose.theme.Black
import com.itsivag.neopop_compose.theme.TiltYellow
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily


@Composable
fun NeopopFloatingTiltButton(
    text: String, onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val height = 150f
    val depth = height + 30f
    val angle = 75f
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val infiniteTransition = rememberInfiniteTransition()

    val animatedY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val shimmerOffset by infiniteTransition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = modifier
            .wrapContentHeight()
            .height((height / 2).dp)
            .fillMaxWidth()
            .clickable(interactionSource, null, onClick = onClick)
            .offset(y = animatedY.dp + if (isPressed) 6.dp else 0.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            Modifier
                .fillMaxSize()
        ) {
            val path = Path().apply {
                moveTo(angle, 0f)
                lineTo(size.width - angle, 0f)
                lineTo(size.width, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path = path, color = TiltYellow)

            // Animate the slanted white rectangles with changing angle
            clipPath(path) {
                val rectWidth = 125f
                val smallerRectWidth = 75f // Width of the smaller rectangle
                val gap = 25f // Gap between the two rectangles
                val xPosition = shimmerOffset % (size.width + rectWidth + gap) - rectWidth - gap

                // Calculate the progress of the rectangle across the button
                val progress = (xPosition + rectWidth + gap) / (size.width + rectWidth + gap)

                // Interpolate the slant angle based on progress
                val slantAngle = lerp(-angle * 2f, angle * 2f, progress)

                // Function to draw a slanted rectangle
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

                // Draw the smaller rectangle behind
                drawSlantedRect(xPosition, smallerRectWidth, White)

                // Draw the larger rectangle
                drawSlantedRect(xPosition + smallerRectWidth + gap, rectWidth, White)
            }

            drawPath(path = Path().apply {
                moveTo(0f, height)
                lineTo(20f, depth)
                lineTo(size.width - 20, depth)
                lineTo(size.width, height)
                close()
            }, color = TiltYellow.copy(alpha = 0.7f))
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
