package ru.aafdev.core_data.models

data class ItemDomainModel(
    val id: String,
    val link: String,
    val badge: BadgeDomainModel?,
    val title: String
)
