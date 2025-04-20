package com.itsivag.neopop_compose.pop_button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.itsivag.neopop_compose.theme.PopGrey
import com.itsivag.neopop_compose.theme.gilroyFontFamily

//@Composable
//fun NeoPopElevatedButton(
//    text: String,
//    modifier: Modifier = Modifier,
//    onClick: () -> Unit,
//    haptics: Boolean = true
//) {
//    val interactionSource = remember { MutableInteractionSource() }
//    val isPressed by interactionSource.collectIsPressedAsState()
//    val currentOffset = if (isPressed) 0.dp else (-4).dp
//
//    val haptic = LocalHapticFeedback.current
//
//    Box(
//        modifier = modifier
//            .wrapContentSize()
//            .padding(8.dp)
//    ) {
//        // Shadow/background box
//        Box(
//            modifier = Modifier
//                .background(color = PopGrey, shape = RectangleShape)
//                .height(48.dp)
//                .fillMaxWidth()
//        )
//
//        // Main button
//        Button(
//            onClick = {
//                if (haptics)
//                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
//                onClick()
//            },
//            interactionSource = interactionSource, // Use the interaction source to detect press
//            modifier = Modifier
//                .offset(x = currentOffset, y = currentOffset)
//                .align(Alignment.TopStart)
//                .height(48.dp)
//                .fillMaxWidth(),
//            shape = RectangleShape,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color.White,
//                contentColor = Color.Black
//            ),
//            elevation = null
//        ) {
//            Text(
//                text = text,
//                fontFamily = gilroyFontFamily,
//                fontWeight = FontWeight.SemiBold
//            )
//        }
//    }
//}