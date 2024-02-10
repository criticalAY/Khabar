package com.criticalay.khabar.ui.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.criticalay.khabar.ui.composables.SettingsList

@Composable
fun Settings(onBackPressed:()-> Unit){
    SettingsList(onBackPressed = { onBackPressed()})
}