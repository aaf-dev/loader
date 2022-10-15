package ru.aafdev.core_ui.models

import ru.aafdev.core_ui.models.base.BaseUiModel

data class NetologyDataUiModel(
    val groups: List<GroupUiModel>,
    val direction: DirectionUiModel?
) : BaseUiModel()
