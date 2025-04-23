package com.itsivag.neopop_compose.tilt_button

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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsivag.neopop_compose.theme.Black
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily

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



    Box(
        modifier = modifier
            .wrapContentHeight()
            .height((height / 2).dp)
            .fillMaxWidth()
            .clickable(interactionSource, null, onClick = onClick)
            .offset(y = if (isPressed) 10.dp else 0.dp),
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
            drawPath(path = path, color = White)

            if (!isPressed)
                drawPath(path = Path().apply {
                    moveTo(0f, height)
                    lineTo(20f, depth)
                    lineTo(size.width - 20, depth)
                    lineTo(size.width, height)
                    close()
                }, color = White.copy(alpha = 0.8f))
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

