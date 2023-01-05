package com.personal.project.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.project.repository.AstronomyRepository
import com.personal.project.network.AstronomyService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val astronomyRepository: AstronomyRepository,
    private val service: AstronomyService,
) : ViewModel() {

    fun getNasaApi() {
        viewModelScope.launch(Dispatchers.Main) {
            val value = astronomyRepository.getNasaApi(service)
            value.title
        }
    }
}
