package com.nextu.nextu_android_advanced.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme
import com.nextu.nextu_android_advanced.ui.theme.Typography

@Composable
fun ErrorContent(error: Throwable, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error.message.toString(),
            style = Typography.labelMedium,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ErrorContentPreview() {
    NextU_android_advancedTheme {
        ErrorContent(Throwable("Mocked Error"))
    }
}