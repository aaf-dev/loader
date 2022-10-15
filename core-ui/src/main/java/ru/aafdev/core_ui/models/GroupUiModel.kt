package ru.aafdev.core_ui.models

data class GroupUiModel(
    val id: String,
    val link: String,
    val badgeUiModel: BadgeUiModel?,
    val items: List<ItemUiModel>
)
