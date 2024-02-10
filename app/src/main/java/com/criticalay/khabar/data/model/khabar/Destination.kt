package com.criticalay.khabar.data.model.khabar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val icon: ImageVector? = null,
) {
    data object Home : Destination("home")

    data object Settings : Destination("settings", Icons.Default.Settings)

    companion object {
        fun fromString(route: String): Destination {
            return when (route) {
                Settings.path -> Settings
                else -> Home
            }
        }
    }
}