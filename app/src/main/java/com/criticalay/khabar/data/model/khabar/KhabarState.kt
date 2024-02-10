package com.criticalay.khabar.data.model.khabar

import com.criticalay.khabar.data.Khabar

data class KhabarState(
    val status: KhabarStatus = KhabarStatus.LOADING,
    val khabar:List<Khabar>? = null
)