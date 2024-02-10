package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.criticalay.khabar.R
import com.criticalay.khabar.data.model.khabar.KhabarEvent

@Composable
fun Error(
    modifier: Modifier = Modifier,
    khabarEventListener: (inboxEvent: KhabarEvent) -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(
                id = R.string.message_content_error
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { khabarEventListener(KhabarEvent.Refresh) }) {
            Text(
                text = stringResource(
                    id = R.string.label_try_again
                )
            )
        }
    }
}