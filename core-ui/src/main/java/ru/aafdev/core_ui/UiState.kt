package ru.aafdev.core_ui

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Error(val message: String?, val throwable: Throwable) : UiState<Nothing>()
    data class Success <Data> (val data: Data) : UiState<Data>()
}
