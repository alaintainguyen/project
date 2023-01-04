package com.personal.projectapplication.features

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.personal.projectapplication.di.NetworkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class MainViewModel(application: Application) : AndroidViewModel(application) {
    val context = getApplication<Application>()

    fun getNasaApi() {
        viewModelScope.launch(Dispatchers.Main) {

        }
    }
}
