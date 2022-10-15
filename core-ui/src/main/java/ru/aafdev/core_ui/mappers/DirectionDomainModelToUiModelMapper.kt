package ru.aafdev.core_ui.mappers

import ru.aafdev.core_data.models.DirectionDomainModel
import ru.aafdev.core_ui.models.DirectionUiModel

class DirectionDomainModelToUiModelMapper(
    private val badgeMapper: BadgeDomainModelToUiModelMapper
) : (DirectionDomainModel?) -> DirectionUiModel? {
    override fun invoke(model: DirectionDomainModel?): DirectionUiModel? {
        if (model == null) return null

        return DirectionUiModel(
            id = model.id,
            link = model.link,
            badgeUiModel = badgeMapper(model.badge),
            title = model.title
        )
    }
}