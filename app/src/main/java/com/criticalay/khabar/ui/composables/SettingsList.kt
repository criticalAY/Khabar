package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.criticalay.khabar.BuildConfig
import com.criticalay.khabar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    onBackPressed:() -> Unit
){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.settings),
                    modifier = Modifier.padding(start = 10.dp)
                )
            },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(R.string.go_back))

                }
            },
            scrollBehavior = scrollBehavior
        )

        AppVersion(modifier = Modifier.fillMaxWidth(),
            appVersion = (BuildConfig.VERSION_CODE).toString()
        )

        Divider()
    }

}