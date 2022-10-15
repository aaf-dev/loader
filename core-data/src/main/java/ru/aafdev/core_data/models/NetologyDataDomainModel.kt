package ru.aafdev.core_data.models

data class NetologyDataDomainModel(
    val groups: List<GroupDomainModel>,
    val direction: DirectionDomainModel?
)
