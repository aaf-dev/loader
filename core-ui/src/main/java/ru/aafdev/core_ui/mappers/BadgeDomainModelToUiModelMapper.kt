package ru.aafdev.core_ui.mappers

import ru.aafdev.core_data.models.BadgeDomainModel
import ru.aafdev.core_ui.models.BadgeUiModel

class BadgeDomainModelToUiModelMapper : (BadgeDomainModel?) -> BadgeUiModel? {
    override fun invoke(model: BadgeDomainModel?): BadgeUiModel? {
        if (model == null) return null

        return BadgeUiModel(
            text = model.text,
            color = model.color,
            bgColor = model.bgColor
        )
    }
}