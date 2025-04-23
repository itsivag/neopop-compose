package com.itsivag.neopop_compose

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.itsivag.neopop_compose.pop_button.NeoPopElevatedButton
import com.itsivag.neopop_compose.pop_button.NeopopElevatedStrokeButton
import com.itsivag.neopop_compose.pop_button.NeopopFlatButton
import com.itsivag.neopop_compose.pop_button.NeopopFlatStrokeButton
import com.itsivag.neopop_compose.theme.Black
import com.itsivag.neopop_compose.theme.NeoPopTheme
import com.itsivag.neopop_compose.theme.StrokeGreen
import com.itsivag.neopop_compose.theme.TiltYellow
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.gilroyFontFamily
import com.itsivag.neopop_compose.tilt_button.NeopopFloatingStrokeTiltButton
import com.itsivag.neopop_compose.tilt_button.NeopopFloatingTiltButton
import com.itsivag.neopop_compose.tilt_button.NeopopNonFloatingTiltButton

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
                NeoPopElevatedButton(
                    text = "Pay me",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                NeopopFlatButton(
                    text = "Pay now",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                NeopopElevatedStrokeButton(
                    text = "Pay me",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                NeopopFlatStrokeButton(
                    text = "Pay now",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp)
                )

                NeopopFloatingTiltButton(
                    text = "Play now",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp),
                )

                NeopopNonFloatingTiltButton(
                    text = "Play now",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp)
                )

                NeopopFloatingStrokeTiltButton(
                    text = "Play now",
                    onClick = {},
                    modifier = Modifier.padding(vertical = 24.dp)
                )
            }
        }
    }
}

