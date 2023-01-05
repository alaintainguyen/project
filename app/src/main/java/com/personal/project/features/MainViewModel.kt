package com.personal.project.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.project.domain.model.AstronomyBean
import com.personal.project.domain.repository.AstronomyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val astronomyRepository: AstronomyRepository) : ViewModel() {

    private val eventChannel = Channel<MainEvent>(Channel.UNLIMITED)
    val eventsFlow = eventChannel.receiveAsFlow()

    private val _stateFlow = MutableStateFlow(UiState())

    val uiState: StateFlow<UiState> = _stateFlow

    fun getNasaApi() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val response = astronomyRepository.getAstronomyList(getDateMinus10(), getCurrentDate())
                _stateFlow.value = _stateFlow.value.copy(astronomyList = response)
            } catch(e: Exception) {
                _stateFlow.value = _stateFlow.value.copy(errorMessage = e.message)
            }
        }
    }

    private fun getDateMinus10(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -9)
        return SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(calendar.time)
    }

    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        return SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(calendar.time)
    }

    data class UiState(
        val errorMessage: String? = "",
        val astronomyList: List<AstronomyBean>? = emptyList()
    )

    sealed class MainEvent
    object OnItemClickedEvent: MainEvent()
}
