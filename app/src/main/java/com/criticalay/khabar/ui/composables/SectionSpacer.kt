package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun SectionSpacer(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .height(48.dp)
            .alpha(0.12f)
            .background(color = MaterialTheme.colorScheme.onSurface)

    ){

    }
}