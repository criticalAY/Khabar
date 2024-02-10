package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.criticalay.khabar.R

@Composable
fun Empty(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Icon(
                modifier = Modifier.size(80.dp),
                imageVector = Icons.Rounded.Newspaper,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = stringResource(id = R.string.empty_state_message),
            fontSize = 16.sp
        )
    }
}