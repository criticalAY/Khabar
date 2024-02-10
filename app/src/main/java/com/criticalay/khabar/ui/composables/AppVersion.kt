package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.criticalay.khabar.R

@Composable
fun AppVersion(
    modifier: Modifier = Modifier,
    appVersion: String
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .semantics(mergeDescendants = true) {}
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                fontSize = 18.sp,
                text = stringResource(id = R.string.setting_app_version_title)
            )

            Text(
                fontSize = 18.sp,
                text = appVersion
            )

        }

    }
}