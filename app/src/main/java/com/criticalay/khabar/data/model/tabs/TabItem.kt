package com.criticalay.khabar.data.model.tabs

import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem (
    val title:String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector
)