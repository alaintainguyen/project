package com.personal.project.ui.features.compose

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.personal.project.ui.features.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    MainScreen(uiState, modifier)
}

@Composable
fun MainScreen(
    uiState: MainViewModel.UiState,
    modifier: Modifier = Modifier,
) {
    Text(text = "Tailloute le meilleur")
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainScreenPreview() {
    val uiState = MainViewModel.UiState(
        errorMessage = "ErrorMessage",
        astronomyList = emptyList()
    )

    MainScreen(uiState = uiState)
}
