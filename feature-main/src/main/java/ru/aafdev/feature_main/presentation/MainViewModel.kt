package ru.aafdev.feature_main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.aafdev.core_data.NetworkRepository
import ru.aafdev.core_ui.UiState
import ru.aafdev.core_ui.models.NetologyDataUiModel
import ru.aafdev.feature_main.mapper.ListOfDomainModelsToListOfUiModels

class MainViewModel(
    private val networkRepository: NetworkRepository,
    private val mapper: ListOfDomainModelsToListOfUiModels
) : ViewModel() {

    private val _state: MutableSharedFlow<UiState<List<NetologyDataUiModel>>> = MutableSharedFlow()
    val state: SharedFlow<UiState<List<NetologyDataUiModel>>> = _state.asSharedFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.emit(UiState.Loading)

            kotlin.runCatching { networkRepository.getData() }
                .map(mapper)
                .onSuccess { _state.emit(UiState.Success(it)) }
                .onFailure { _state.emit(UiState.Error(it.message, it)) }
        }
    }
}