package ru.aafdev.core_data.models

data class DirectionDomainModel(
    val id: String,
    val link: String,
    val badge: BadgeDomainModel?,
    val title: String
)
