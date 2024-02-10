package com.criticalay.khabar.view_model

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.criticalay.khabar.R
import com.criticalay.khabar.data.Khabar
import com.criticalay.khabar.data.model.khabar.KhabarEvent
import com.criticalay.khabar.data.model.khabar.KhabarState
import com.criticalay.khabar.data.model.khabar.KhabarStatus
import com.criticalay.khabar.utils.Network
import com.criticalay.khabar.utils.internet.ApiClient
import com.criticalay.khabar.utils.internet.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber

class KhabarViewModel : ViewModel() {

    val uiState = MutableStateFlow(KhabarState())
    private val coroutineScope = MainScope()

    fun loadKhabar() {
        uiState.value = uiState.value.copy(
            status = KhabarStatus.LOADING
        )
        coroutineScope.launch {
            try {

                val fetchedKhabar = fetchTopHeadlines(ApiClient.apiService, HeadlinesType.TOP_HEADLINES)
                if (fetchedKhabar != null) {
                    Timber.d("Successfully fetched the data")
                    uiState.value = uiState.value.copy(
                        status = KhabarStatus.SUCCESS,
                        khabar = listOf(fetchedKhabar)
                    )
                }
            } catch (e: Exception) {
                Timber.w("Error retrieving the data from the API", e)
                uiState.value = uiState.value.copy(
                    status = KhabarStatus.ERROR
                )
            }
        }
    }

    fun loadKhabarEntertainment() {
        uiState.value = uiState.value.copy(
            status = KhabarStatus.LOADING
        )

        coroutineScope.launch {
            try {

                val fetchedKhabar =  fetchTopHeadlines(ApiClient.apiService, HeadlinesType.ENTERTAINMENT)
                if (fetchedKhabar != null) {
                    Timber.d("Successfully fetched the data")
                    uiState.value = uiState.value.copy(
                        status = KhabarStatus.SUCCESS,
                        khabar = listOf(fetchedKhabar)
                    )
                }
            } catch (e: Exception) {
                Timber.w("Error retrieving the data from the API", e)
                uiState.value = uiState.value.copy(
                    status = KhabarStatus.ERROR
                )
            }
        }
    }

    fun loadKhabarTech() {
        uiState.value = uiState.value.copy(
            status = KhabarStatus.LOADING
        )

        coroutineScope.launch {
            try {

                val fetchedKhabar =  fetchTopHeadlines(ApiClient.apiService, HeadlinesType.TECH_CRUNCH)
                if (fetchedKhabar != null) {
                    Timber.d("Successfully fetched the data")
                    uiState.value = uiState.value.copy(
                        status = KhabarStatus.SUCCESS,
                        khabar = listOf(fetchedKhabar)
                    )
                }
            } catch (e: Exception) {
                Timber.w("Error retrieving the data from the API", e)
                uiState.value = uiState.value.copy(
                    status = KhabarStatus.ERROR
                )
            }
        }
    }

    enum class HeadlinesType {
        TOP_HEADLINES,
        TECH_CRUNCH,
        ENTERTAINMENT
    }

    suspend fun fetchTopHeadlines(apiService: ApiService, headlinesType: HeadlinesType): Khabar? {
        return withContext(Dispatchers.IO) {
            try {
                val response = when (headlinesType) {
                    HeadlinesType.TOP_HEADLINES -> apiService.getTopHeadlinesCoroutine()
                    HeadlinesType.TECH_CRUNCH -> apiService.getTeachCrunch()
                    HeadlinesType.ENTERTAINMENT -> apiService.getEntertainment()
                }
                response
            } catch (e: HttpException) {
                Timber.v(e)
                null
            } catch (e: Throwable) {
                Timber.v(e)
                null
            }
        }
    }

    fun openNews(context: Context, url:String){
        if (Network.isInternetAvailable(context = context)){
            val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(webIntent)
        }else{
            Toast.makeText(context, context.getString(R.string.network_issue), Toast.LENGTH_SHORT).show()
        }
    }



    fun handleEvent(khabarEvent: KhabarEvent) {
        when (khabarEvent) {
            is KhabarEvent.Open -> {
                openNews(context = khabarEvent.context,khabarEvent.url )
            }
            KhabarEvent.Refresh -> {
               // TODO()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}