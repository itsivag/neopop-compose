package com.itsivag.neopop_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itsivag.neopop_compose.theme.NeoPopTheme

@Preview
@Composable
fun Sample() {
    NeoPopTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp)
            ) {}
        }
    }
}

