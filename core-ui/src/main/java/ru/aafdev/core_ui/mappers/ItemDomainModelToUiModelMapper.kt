package ru.aafdev.core_ui.mappers

import ru.aafdev.core_data.models.ItemDomainModel
import ru.aafdev.core_ui.models.ItemUiModel

class ItemDomainModelToUiModelMapper(
    private val badgeMapper: BadgeDomainModelToUiModelMapper
) : (ItemDomainModel) -> ItemUiModel {
    override fun invoke(model: ItemDomainModel): ItemUiModel {
        return ItemUiModel(
            id = model.id,
            link = model.link,
            badge = badgeMapper(model.badge),
            title = model.title
        )
    }
}