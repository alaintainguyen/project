package com.personal.project.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.project.domain.repository.AstronomyRepository
import com.personal.project.network.AstronomyService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val astronomyRepository: AstronomyRepository,
    private val service: AstronomyService,
) : ViewModel() {

    fun getNasaApi() {
        viewModelScope.launch(Dispatchers.Main) {
            val value = astronomyRepository.getAstronomyList(getCurrentDate(), getDateMinus10())
            val toto = ""
        }
    }

    private fun getDateMinus10(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -29)
        return SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(calendar.time)
    }

    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        return SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(calendar.time)
    }
}
