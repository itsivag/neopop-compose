package com.itsivag.neopop_compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsivag.neopop_compose.theme.Black
import com.itsivag.neopop_compose.theme.NeoPopTheme
import com.itsivag.neopop_compose.theme.PopGrey
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sin
import kotlin.math.tan

@Preview
@Composable
fun Sample() {
    NeoPopTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp)
            ) {
//                NeoPopElevatedButton(
//                    text = "Pay now",
//                    modifier = Modifier.fillMaxWidth(),
//                    onClick = { /* Handle click */ })

                Button3D()
            }
        }
    }
}

@Composable
fun NeoPopElevatedButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    haptics: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val currentOffset = if (isPressed) 0.dp else (-4).dp

    val haptic = LocalHapticFeedback.current

    Box(
        modifier = modifier
            .wrapContentSize()
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = PopGrey, shape = RectangleShape)
                .height(48.dp)
                .fillMaxWidth()
        )

        // Main button
        Button(
            onClick = {
                if (haptics)
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                onClick()
            },
            interactionSource = interactionSource, // Use the interaction source to detect press
            modifier = Modifier
                .offset(x = currentOffset, y = currentOffset)
                .align(Alignment.TopStart)
                .height(48.dp)
                .fillMaxWidth(),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = null
        ) {
            Text(
                text = text,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
fun Button3D() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.clickable(interactionSource, indication = null) {}
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
            val depth = canvasHeight * 0.1f

            // Calculate dimensions
            val w = canvasWidth - depth
            val h = canvasHeight - depth

            // Calculate offset for pressed state
            val offsetX = if (isPressed) depth else 0f
            val offsetY = if (isPressed) depth else 0f

            // Bottom side (grey)
            val bottomSideColor = Color(200, 200, 200) // PopGrey
            val bottomSide = Path().apply {
                moveTo(0f, h)
                lineTo(depth, canvasHeight)
                lineTo(canvasWidth, canvasHeight)
                lineTo(w, h)
                close()
            }
            drawPath(bottomSide, color = bottomSideColor)

            // Right side (lighter grey)
            val rightSideColor = Color(190, 190, 190, 255)
            val rightSide = Path().apply {
                moveTo(w, 0f)
                lineTo(canvasWidth, depth)
                lineTo(canvasWidth, canvasHeight)
                lineTo(w, h)
                close()
            }
            drawPath(rightSide, color = rightSideColor)

            // White front face (drawn last to overlay when not pressed)
            val frontFaceColor = Color.White
            drawRect(
                color = frontFaceColor,
                topLeft = Offset(offsetX, offsetY),
                size = Size(w, h)
            )
        }

        Text(
            "Pay now",
            color = Black,
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.offset(
                x = if (isPressed) 1.dp else 0.dp,
                y = if (isPressed) 1.dp else 0.dp
            )
        )
    }
}