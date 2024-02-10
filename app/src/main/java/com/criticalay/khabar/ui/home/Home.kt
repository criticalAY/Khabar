package com.criticalay.khabar.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.criticalay.khabar.data.model.khabar.KhabarEvent
import com.criticalay.khabar.data.model.khabar.KhabarState
import com.criticalay.khabar.data.model.khabar.KhabarStatus
import com.criticalay.khabar.ui.composables.Empty
import com.criticalay.khabar.ui.composables.Error
import com.criticalay.khabar.ui.composables.KhabarList
import com.criticalay.khabar.ui.composables.Loading

@Composable
fun Home(
    modifier: Modifier = Modifier,
    khabarState: KhabarState,
    khabarEventListener: (khabarEvent: KhabarEvent) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        when (khabarState.status) {
            KhabarStatus.LOADING -> {
                Loading()
            }
            KhabarStatus.ERROR -> {
                Error {
                    khabarEventListener(KhabarEvent.Refresh)
                }
            }
            KhabarStatus.EMPTY -> {
                // Rare to occur
                Empty(modifier = Modifier.fillMaxSize())
            }
            else -> {
                khabarState.khabar?.let {
                    KhabarList(khabars = it, khabarEventListener = khabarEventListener)
                }
            }
        }
    }
}