package com.itsivag.neopop_compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsivag.neopop_compose.pop_button.NeoPopElevatedButton
import com.itsivag.neopop_compose.pop_button.NeopopElevatedStrokeButton
import com.itsivag.neopop_compose.pop_button.NeopopFlatButton
import com.itsivag.neopop_compose.pop_button.NeopopFlatStrokeButton
import com.itsivag.neopop_compose.theme.NeoPopTheme
import com.itsivag.neopop_compose.theme.PopGrey
import com.itsivag.neopop_compose.theme.White
import com.itsivag.neopop_compose.theme.circaFontFamily
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

