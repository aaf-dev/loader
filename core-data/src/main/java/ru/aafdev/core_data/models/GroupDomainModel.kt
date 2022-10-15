package ru.aafdev.core_data.models

data class GroupDomainModel(
    val id: String,
    val link: String,
    val badge: BadgeDomainModel?,
    val items: List<ItemDomainModel>
)
