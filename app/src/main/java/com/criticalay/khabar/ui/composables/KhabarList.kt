package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.criticalay.khabar.data.Khabar
import com.criticalay.khabar.data.model.khabar.KhabarEvent
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext

@Composable
fun KhabarList(
    modifier: Modifier = Modifier,
    khabars: List<Khabar>,
    khabarEventListener: (id: KhabarEvent) -> Unit
) {
    val context= LocalContext.current
    LazyColumn(modifier = modifier) {
        items(khabars, key = { item -> item.articles }) {
            for (article in it.articles) {
                KhabarItem(article = article){
                    khabarEventListener(KhabarEvent.Open(context = context, url = article.url))
                }
            }
        }
    }
}