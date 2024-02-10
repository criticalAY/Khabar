package com.criticalay.khabar.data.model.khabar

import android.content.Context

sealed class KhabarEvent {
    data object Refresh: KhabarEvent()

    data class Open(val context: Context,val url: String) : KhabarEvent()
}