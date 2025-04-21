package com.itsivag.neopop_compose.pop_button

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsivag.neopop_compose.theme.Black
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily

@Composable
fun NeopopElevatedStroke(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    haptics: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val haptic = LocalHapticFeedback.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.clickable(interactionSource, indication = null) {
            onClick()
            if (haptics)
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    ) {
        Canvas(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(50.dp)
                .fillMaxWidth()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            // Define the 3D effect depth
            val depth = canvasHeight * 0.08f

            // Calculate dimensions
            val w = canvasWidth - depth
            val h = canvasHeight - depth

            // Calculate offset for pressed state
            val offsetX = if (isPressed) depth else 0f
            val offsetY = if (isPressed) depth else 0f

            // Bottom side (grey)
            val bottomSideColor = Color(200, 200, 200)
            val bottomSide = Path().apply {
                moveTo(offsetX, h + offsetY)
                lineTo(depth, canvasHeight)
                lineTo(canvasWidth, canvasHeight)
                lineTo(w + offsetX, h + offsetY)
                close()
            }
            drawPath(bottomSide, color = bottomSideColor)

            // Right side (lighter grey)
            val rightSideColor = Color(200, 200, 200)
            val rightSide = Path().apply {
                moveTo(w + offsetX, offsetY)
                lineTo(canvasWidth, depth)
                lineTo(canvasWidth, canvasHeight)
                lineTo(w + offsetX, h + offsetY)
                close()
            }
            drawPath(rightSide, color = rightSideColor)

            // White front
            drawRect(
                color = rightSideColor,
                topLeft = Offset(offsetX, offsetY),
                size = Size(w, h),
                style = Stroke(width = 2.dp.toPx())
            )

        }
        Text(
            text,
            color = White,
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .offset(
                    x = if (isPressed) 1.dp else (-1).dp,
                    y = if (isPressed) 1.dp else (-1).dp
                )
        )
    }
}