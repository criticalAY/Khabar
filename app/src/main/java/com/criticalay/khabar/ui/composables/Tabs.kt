package com.criticalay.khabar.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.criticalay.khabar.data.model.tabs.TabItem
import com.criticalay.khabar.ui.home.Home
import com.criticalay.khabar.view_model.KhabarViewModel
import timber.log.Timber

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(modifier: Modifier = Modifier) {
    val tabItems = listOf(
        TabItem(
            title = "Top",
            selectedIcon = Icons.Filled.Newspaper,
            unselectedIcon = Icons.Outlined.Newspaper
        ),
        TabItem(
            title = "Tech",
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star
        ),
        TabItem(
            title = "Entertainment",
            selectedIcon = Icons.Filled.People,
            unselectedIcon = Icons.Outlined.People
        )
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) selectedTabIndex = pagerState.currentPage
    }
    Column(modifier = modifier) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = item.title) },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }
        HorizontalPager(state = pagerState, modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) { index ->
            if (tabItems[index].title=="Top"){
                val viewModel: KhabarViewModel = viewModel()
                Home(
                    khabarState = viewModel.uiState.collectAsState().value,
                    khabarEventListener = viewModel::handleEvent
                )
                Timber.d("Starting API call")
                LaunchedEffect(Unit) {
                    viewModel.loadKhabar()
                }
            }
            if (tabItems[index].title=="Tech"){
                val viewModel: KhabarViewModel = viewModel()
                Home(
                    khabarState = viewModel.uiState.collectAsState().value,
                    khabarEventListener = viewModel::handleEvent
                )
                Timber.d("Starting API call")
                LaunchedEffect(Unit) {
                    viewModel.loadKhabarTech()
                }
            }
            if (tabItems[index].title=="Entertainment"){
                val viewModel: KhabarViewModel = viewModel()
                Home(
                    khabarState = viewModel.uiState.collectAsState().value,
                    khabarEventListener = viewModel::handleEvent
                )
                Timber.d("Starting API call")
                LaunchedEffect(Unit) {
                    viewModel.loadKhabarEntertainment()
                }
            }
        }
    }
}