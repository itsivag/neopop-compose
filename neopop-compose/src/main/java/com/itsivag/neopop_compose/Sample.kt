package com.itsivag.neopop_compose

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.style.TextAlign
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
import com.itsivag.neopop_compose.theme.PopGrey
import com.itsivag.neopop_compose.theme.StrokeGreen
import com.itsivag.neopop_compose.theme.TiltYellow
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.circaFontFamily
import com.itsivag.neopop_compose.theme.gilroyFontFamily
import com.itsivag.neopop_compose.theme.overPassMono
import com.itsivag.neopop_compose.tilt_button.NeopopFloatingStrokeTiltButton
import com.itsivag.neopop_compose.tilt_button.NeopopFloatingTiltButton
import com.itsivag.neopop_compose.tilt_button.NeopopNonFloatingTiltButton

@Preview
@Composable
fun Sample() {
    NeoPopTheme {
        Scaffold {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(8.dp)
                    .border(width = 1.dp, color = PopGrey)
                    .padding(16.dp)
            ) {
                item {
                    Text(
                        "neopop - compose\nframework",
                        fontFamily = circaFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        lineHeight = 54.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp, bottom = 64.dp)
                    )
                }
                item {
                    ElementLabel("Floating Tilt Button")

                    NeopopFloatingTiltButton(
                        text = "Play now",
                        onClick = {},
                        modifier = Modifier.padding(vertical = 32.dp),
                    )
                }

                item {
                    ElementLabel("Non Floating Tilt Button")

                    NeopopNonFloatingTiltButton(
                        text = "Play now",
                        onClick = {},
                        modifier = Modifier.padding(vertical = 32.dp)
                    )

                }

                item {
                    ElementLabel("Floating Stroke Button")

                    NeopopFloatingStrokeTiltButton(
                        text = "Play now",
                        onClick = {},
                        modifier = Modifier.padding(vertical = 32.dp)
                    )
                }

                item {
                    ElementLabel("Elevated Button")
                    NeoPopElevatedButton(
                        text = "Pay me", onClick = {}, modifier = Modifier.padding(vertical = 32.dp)
                    )
                }
                item {
                    ElementLabel("Flat Button")
                    NeopopFlatButton(
                        text = "Pay now",
                        onClick = {},
                        modifier = Modifier.padding(vertical = 32.dp)
                    )
                }

                item {
                    ElementLabel("Elevated Stroke Button")

                    NeopopElevatedStrokeButton(
                        text = "Pay me", onClick = {}, modifier = Modifier.padding(vertical = 32.dp)
                    )
                }

                item {
                    ElementLabel("Flat Button")

                    NeopopFlatStrokeButton(
                        text = "Pay now",
                        onClick = {},
                        modifier = Modifier.padding(vertical = 32.dp)
                    )
                }


            }
        }
    }
}

@Composable
fun ElementLabel(t: String) {
    Text(
        "* $t",
        fontFamily = overPassMono,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    )

    HorizontalDivider(color = PopGrey.copy(alpha = 0.5f))
}

