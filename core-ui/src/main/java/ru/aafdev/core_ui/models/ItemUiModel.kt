package ru.aafdev.core_ui.models

data class ItemUiModel(
    val id: String,
    val link: String,
    val badge: BadgeUiModel?,
    val title: String
)
